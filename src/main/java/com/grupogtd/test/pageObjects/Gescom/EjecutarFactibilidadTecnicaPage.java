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
 * Created by ramiro.urbina on 29-11-2017.
 */
public class EjecutarFactibilidadTecnicaPage {
    @FindBy(how = How.ID, using =  "idBotonEjecutar")
    public WebElement btnEjecutar;

    public void ejecutarFactibilidadTecnicaAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Ejecutar Factibilidad Tecnica");
        WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        LOGGER.log(Level.INFO,"Se ejecuta Factibilidad Técnica");
        try {
            WaitTool.waitToLoad(driver, LOGGER);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        WindowHandTool.windowhandle(driver, LOGGER, "Revisar Factibilidades");
        driver.close();
    }
}
