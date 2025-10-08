package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoryStore {
    // Categoría Clothes
    public static By labelClothes = By.xpath("//*[@id='category-3']/a");

    // Subcategoría Men (dentro de Clothes)
    public static By labelMen = By.xpath("//*[@id='left-column']/div[1]/ul/li[2]/ul/li[1]/a");

    // Botón del primer producto
    public static By firstProductAddButton = By.xpath("(//button[@data-button-action='add-to-cart'])[1]");

    // Popup de confirmación
    public static By popupMessage = By.cssSelector(".cart-content-btn .btn-primary");

    // Total en el popup
    public static By popupTotal = By.cssSelector(".cart-content .value");
}
