package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class ContactosDelCLientePage {
    @FindBy(how = How.XPATH, using =  "//table[@id='tablaInformacion']/tbody/tr[2]/td[1]/input")
    public WebElement rdPrimerContacto;

    /*@FindBy(how = How.XPATH, using =  "//table[@id='tablaInformacion']/tbody/tr[2]/td[12]/select")
    public WebElement cbbCargo;*/

    @FindBy(how = How.ID, using =  "botonSeleccionarContacto")
    public WebElement btnSeleccionar;

    public void CrearModificarContactoClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Contactos del Cliente");
        //new Select(cbbCargo).selectByVisibleText("GERENTE COMERCIAL");
        WaitTool.waitToLoad(driver, LOGGER);
        rdPrimerContacto.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);

        btnSeleccionar.sendKeys(Keys.ENTER);
    }
}
