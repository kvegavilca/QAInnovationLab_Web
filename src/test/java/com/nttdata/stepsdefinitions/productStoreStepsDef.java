package com.nttdata.stepsdefinitions;
import com.nttdata.steps.CartSteps;
import com.nttdata.steps.CategorySteps;
import com.nttdata.steps.IndexSteps;
import com.nttdata.steps.LoginStoreSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class productStoreStepsDef {

    private WebDriver driver;
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
            driver = getDriver();
            driver.get("https://qalab.bensg.com/store/");
            screenShot();
    }

    @When("hago clic en el botón Iniciar sesión")
    public void hagoClicEnElBotonIniciarSesion() {
        IndexSteps indexSteps = new IndexSteps(driver);
        indexSteps.clickLoginButton();
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email , String password) {

        LoginStoreSteps loginStoreSteps = new LoginStoreSteps(driver);
        loginStoreSteps.typeUser(email);
        loginStoreSteps.typePassword(password);
        loginStoreSteps.login();
        screenShot();
    }

    @And("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoriaYSubcatergoria(String categoria, String subcategoria) {
        CategorySteps categorySteps = new CategorySteps(driver);
        categorySteps.navigateToCategory(categoria, subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        CategorySteps categorySteps = new CategorySteps(driver);
        categorySteps.addFirstProductToCart(cantidad);
        screenShot();
    }

    @Then("valido en el pop-up la confirmación del producto agregado")
    public void calidoEnElPopUpLaConfirmaciónDelProductoAgregado() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validatePopupConfirmation();
        screenShot();
    }

    @And("valido en el pop-up que el monto total sea calculado correctamente")
    public void validoEnElPopUpQueElMontoTotalSeaCaculadoCorrectamente() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validatePopupTotalAmount();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.goToCart();
        screenShot();
    }

    @Then("valido el título de la página del carrito")
    public void validoElTítuloDeLaPáginaDelCarrito() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validateCartTitle();
        screenShot();
    }

    @And("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validateCartTotal();
        screenShot();
    }
}
