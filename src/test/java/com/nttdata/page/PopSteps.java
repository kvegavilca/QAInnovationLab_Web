package com.nttdata.page;
import org.openqa.selenium.By;

public class PopSteps {

    public static By popupMessage = By.id("popup-message");
    public static By popupTotal = By.id("popup-total");
    public static By cartButton = By.id("cart");
    public static By cartTitle = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    public static By cartTotal = By.id("cart-total");
}
