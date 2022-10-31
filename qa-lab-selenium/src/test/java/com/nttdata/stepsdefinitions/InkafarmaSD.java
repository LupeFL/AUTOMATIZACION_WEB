package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InkafarmaSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InkafarmaSD {

    private WebDriver driver;
    private Scenario scenario;

    private InkafarmaSteps inkafarmaSteps(WebDriver driver){
        return new InkafarmaSteps(driver);
    }

    //@Steps

    private InkafarmaSteps inkafarmaSteps;

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }


    //PRIMER ESCENARIO: LOGEO EN LA PAGINA WEB DE INKAFARMA



    @Given("estoy en la pagina web de Inkafarma")
    public void estoyEnLaPaginaWebDeInkafarma() {
        inkafarmaSteps = new InkafarmaSteps(driver);
        driver.get("https://inkafarma.pe/");
        screenShot();

    }

    @When("doy click en inicio de sesion")
    public void doyClickEnInicioDeSesion() {
        inkafarmaSteps.menu();
        screenShot();

    }

    @And("selecciono ingresa con correo electronico")
    public void seleccionoIngresaConCorreoElectronico() {
        inkafarmaSteps.sesion();
        screenShot();

    }

    @And("ingreso el usuario {string}")
    public void ingresoElUsuario(String sUser) {
        inkafarmaSteps.typeUser(sUser);
        screenShot();
    }

    @And("ingreso la contraseña {string}")
    public void ingresoLaContraseña(String sPassword) {
        inkafarmaSteps.typePassword(sPassword);
        screenShot();
    }

    @And("hago click en el boton Ingresar")
    public void hagoClicEnElBotonIngresar() {
        inkafarmaSteps.login();
        screenShot();
    }

    @Then("valido que el mensaje en el menu sea {string}")
    public void validoQueElMensajeEnElMenuSea(String mensaje) {
        String name = inkafarmaSteps(driver).getName();
        Assertions.assertEquals(mensaje, name);
        screenShot();
    }



    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");

    }
}
