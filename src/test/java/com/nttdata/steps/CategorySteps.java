package com.nttdata.steps;
import org.openqa.selenium.JavascriptExecutor;

import com.nttdata.page.CategoryStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategorySteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public CategorySteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToCategory(String category, String subcategory) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Seleccionar categoría
            if (category.equalsIgnoreCase("Clothes")) {
                WebElement categoryElement = wait.until(
                        ExpectedConditions.elementToBeClickable(CategoryStore.labelClothes)
                );
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryElement);
                categoryElement.click();
                System.out.println(" Categoría seleccionada: Clothes");
            } else {
                throw new IllegalArgumentException("Categoría no reconocida: " + category);
            }

            // Seleccionar subcategoría
            if (subcategory.equalsIgnoreCase("Men")) {
                WebElement subCategoryElement = wait.until(
                        ExpectedConditions.elementToBeClickable(CategoryStore.labelMen)
                );
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subCategoryElement);
                subCategoryElement.click();
                System.out.println(" Subcategoría seleccionada: Men");
            } else {
                throw new IllegalArgumentException("Subcategoría no reconocida: " + subcategory);
            }

        } catch (Exception e) {
            System.out.println("Error al navegar a categoría o subcategoría: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Agrega N unidades del primer producto al carrito.
     * @param quantity cantidad de unidades
     */
    public void addFirstProductToCart(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            WebElement addButton = wait.until(
                    ExpectedConditions.elementToBeClickable(CategoryStore.firstProductAddButton)
            );

            for (int i = 0; i < quantity; i++) {
                addButton.click();
                System.out.println(" Producto agregado al carrito (" + (i + 1) + ")");
                Thread.sleep(1000); // pequeña pausa para evitar errores por clicks rápidos
            }

        } catch (Exception e) {
            System.out.println("Error al agregar producto al carrito: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

