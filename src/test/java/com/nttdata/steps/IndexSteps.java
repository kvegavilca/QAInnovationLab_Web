package com.nttdata.steps;

import com.nttdata.page.indexStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IndexSteps {
    private WebDriver driver;

    public IndexSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(indexStore.loginBtn)).click();
    }
}
