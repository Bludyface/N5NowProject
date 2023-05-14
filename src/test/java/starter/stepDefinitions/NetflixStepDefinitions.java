package starter.stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import starter.pageObjects.NetflixLoginPage;
import starter.pageObjects.NetflixMainPage;


public class NetflixStepDefinitions {

    NetflixMainPage netflixMainPage;
    NetflixLoginPage netflixLoginPage;

    public NetflixStepDefinitions()
    {
        netflixMainPage = new NetflixMainPage();
        netflixLoginPage = new NetflixLoginPage();
    }

    @When("Ingreso a la pagina de Netflix")
    public void ingresoALaPaginaDeNetflix() {
        netflixMainPage.open();
    }

    @And("Maximizo la pantalla")
    public void maximizoLaPantalla() { netflixMainPage.MaximizeWindow();}

    @Then("Verifico e imprimo la actual URL")
    public void verificoEImprimoLaActualURL() {
        netflixMainPage.verifyCurrentURL();
    }

    @And("Clickeo el botón Iniciar Sesión")
    public void clickeoElBotónIniciarSesión() {
        netflixMainPage.clickLogInButton();
    }

    @Then("Se carga la página de inicio de sesión")
    public void seCargaLaPáginaDeInicioDeSesión() {
        netflixLoginPage.verifyLogInPage();
    }

    @When("Ingreso mi email {string} y password {string}")
    public void ingresoMiEmailYPassword(String email, String password) {
        netflixLoginPage.enterUserCredentials(email, password);
    }

    @And("Clickeo el botón de inicio de sesión")
    public void clickeoElBotónDeInicioDeSesión() {
        netflixLoginPage.clickLogInButton();
    }

    @Then("Se muestra un mensaje de error")
    public void seMuestraUnMensajeDeError() {
        netflixLoginPage.verifyErrorMessage();
    }
}
