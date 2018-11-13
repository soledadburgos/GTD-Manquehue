package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class CrearClientePage {
    @FindBy(how = How.ID, using =  "botonModificar")
    public WebElement btnModificar;

    public void crearClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Cliente");
        btnModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitForAlert(driver, LOGGER);
    }
}
