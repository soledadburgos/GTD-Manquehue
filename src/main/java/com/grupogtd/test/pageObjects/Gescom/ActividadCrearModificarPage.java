package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.ScreenShotTool;
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
public class ActividadCrearModificarPage {

    @FindBy(how = How.ID, using =  "estadoActividad")
    public WebElement cbbEstado;

    @FindBy(how = How.ID, using =  "subEstado")
    public WebElement cbbSubEstado;

    @FindBy(how = How.ID, using =  "botonFormularioModificar")
    public WebElement btnModificar;

    @FindBy(how = How.ID, using =  "nombreActividad")
    public WebElement cbbNombreActividad;

    public void cerrarActividadAction(WebDriver driver, Logger LOGGER, String path, String estado, String subEstado) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Actividad Crear Modificar");
        new Select(cbbEstado).selectByVisibleText(estado);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbSubEstado).selectByVisibleText(subEstado);
        WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_"+new Select(cbbNombreActividad).getFirstSelectedOption().getText(), driver, LOGGER);
        btnModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitForAlert(driver, LOGGER);
    }
}
