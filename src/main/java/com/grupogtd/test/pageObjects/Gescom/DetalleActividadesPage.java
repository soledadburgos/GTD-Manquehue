package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class DetalleActividadesPage {

    @FindBy(how = How.ID, using =  "estadoActividad")
    public WebElement cbbEstado;

    @FindBy(how = How.ID, using =  "subEstado")
    public WebElement cbbSubEstado;

    @FindBy(how = How.ID, using =  "asignadoA")
    public WebElement cbbAsignadoA;

    @FindBy(how = How.ID, using =  "botonFormularioModificar")
    public WebElement btnModificar;

    @FindBy(how = How.ID, using =  "nombreActividad")
    public WebElement cbbNombreActividad;

    public void cerrarActividadAction(WebDriver driver, Logger LOGGER, String path, String estado, String subEstado, String nombreActividad) throws InterruptedException{
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Detalle Actividades");
        new Select(cbbEstado).selectByVisibleText(estado);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbSubEstado).selectByVisibleText(subEstado);
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO,nombreActividad);
        btnModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
        WindowHandTool.closeWindow(driver, LOGGER, "Detalle Actividades");
        Thread.sleep(1000);
    }

    public void cerrarActividadConUsuarioAction(WebDriver driver, Logger LOGGER, String path, String estado, String subEstado, String nombreActividad) throws InterruptedException{
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Detalle Actividades");
        new Select(cbbAsignadoA).selectByVisibleText("RURBINA");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbEstado).selectByVisibleText(estado);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbSubEstado).selectByVisibleText(subEstado);
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO,nombreActividad);
        btnModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        //WindowHandTool.closeWindow(driver, LOGGER, "Detalle Actividades");
        Thread.sleep(1000);
    }
}
