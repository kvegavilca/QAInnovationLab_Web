package com.nttdata.steps;

import com.nttdata.page.PopSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class CartSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ✅ Validar que el popup de confirmación se muestre
    public void validatePopupConfirmation() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(PopSteps.popupMessage));
        Assert.assertTrue("❌ El pop-up de confirmación no se muestra", popup.isDisplayed());
    }

    // ✅ Validar que el monto total del popup sea correcto
    public void validatePopupTotalAmount() {
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(PopSteps.popupTotal));
        String totalText = total.getText();
        Assert.assertTrue("❌ El monto total no se muestra correctamente", totalText.contains("$"));
    }

    // ✅ Hacer clic en el botón del carrito
    public void goToCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(PopSteps.cartButton));
        cartButton.click();
    }

    // ✅ Validar el título de la página del carrito
    public void validateCartTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopSteps.cartTitle));
        Assert.assertTrue("❌ El título del carrito no es correcto", titleElement.getText().contains("Shopping Cart"));
    }

    // ✅ Validar que el total del carrito se muestre correctamente
    public void validateCartTotal() {
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopSteps.cartTotal));
        Assert.assertTrue("❌ El total del carrito no se muestra", totalElement.isDisplayed());
    }
}
