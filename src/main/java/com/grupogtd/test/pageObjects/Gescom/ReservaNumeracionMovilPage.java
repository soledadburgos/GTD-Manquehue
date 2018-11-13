package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 30-11-2017.
 */
public class ReservaNumeracionMovilPage {
    @FindBy(how = How.XPATH, using =  "//*[@id='resultadoListadoNumeros']/tbody/tr[2]/td[1]/input")
    public WebElement cbNumero;

    @FindBy(how = How.XPATH, using =  "//*[@id='resultadoListadoNumeros']/tbody/tr[2]/td[2]/input")
    public WebElement numero;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Reservar')]")
    public WebElement btnReservarNumero;

    public String ReservarNumeroMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Reservar Numeración Móvil");
        LOGGER.log(Level.INFO, driver.getTitle());
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(3000);
        cbNumero.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnReservarNumero.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
        String numeroText = numero.getText();
        LOGGER.log(Level.INFO,"Numero", numeroText);
        driver.close();
        return numeroText;
    }
}
