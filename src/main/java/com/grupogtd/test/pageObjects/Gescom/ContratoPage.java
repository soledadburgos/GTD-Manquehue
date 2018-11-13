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
public class ContratoPage {
    @FindBy(how = How.LINK_TEXT, using =  "CREAR")
    public WebElement btnCrear;

    @FindBy(how = How.LINK_TEXT, using =  "VOLVER")
    public WebElement btnVolver;

    public void crearContratoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Contrato");
        btnCrear.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnVolver.sendKeys(Keys.ENTER);
    }
}
