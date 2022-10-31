package com.nttdata.steps;

import com.nttdata.page.InkafarmaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InkafarmaSteps {

    private WebDriver driver;

    //constructor
    public InkafarmaSteps(WebDriver driver){
        this.driver = driver;
    }


    public void menu(){

        try {
            Thread.sleep(8000);
            this.driver.findElement(InkafarmaPage.menu).click();
        } catch (Exception e) {
            System.out.println("La pagina demoró en cargar más de 10 segundos");
        }


    }

    public void sesion(){


        try {
            Thread.sleep(8000);
            this.driver.findElement(InkafarmaPage.sesion).click();
        } catch (Exception e) {
            System.out.println("Se demoró en cargar el menu de opciones de inicio de sesion");
        }

    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */



    public void typeUser(String user){

        try {
            Thread.sleep(3000);
            WebElement userInputElement = driver.findElement(InkafarmaPage.userInput);
            userInputElement.sendKeys(user);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(InkafarmaPage.loginButton));

        } catch (Exception e) {
            System.out.println("Se demoró en aparecer el cuadro de texto de entrada para ingresar el usuario");
        }//puede usarse para que no colapse y siga realizando otras acciones




    }



    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(InkafarmaPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(InkafarmaPage.loginButton).click();

    }

    public String getName(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(800));
        return this.driver.findElement(InkafarmaPage.nameAccount).getText();
    }

}
