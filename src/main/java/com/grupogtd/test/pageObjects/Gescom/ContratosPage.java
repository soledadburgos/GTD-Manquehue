package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class ContratosPage {
    @FindBy(how = How.ID, using =  "BotonCrear")
    public WebElement btnCrear;

    @FindBy(how = How.XPATH, using =  "//*[@id='oddrow']/td[9]/input[@type='file']")
    public WebElement seleccionarArchivo;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaFinalizar']/tbody/tr/td/input[@value='Finalizar']")
    public WebElement btnFinalizar;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaFinalizar']/tbody/tr/td/input[@value='Cerrar']")
    public WebElement btnCerrar;

    public void crearContratoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Contratos");
        btnCrear.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void cargaArchivoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Contratos");
        File outputFile = new File(path);
        String archivo = outputFile.listFiles()[0].getAbsolutePath();
        seleccionarArchivo.sendKeys(archivo);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnCerrar.sendKeys(Keys.ENTER);
    }

    public void finalizarAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Contratos");
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
        btnCerrar.sendKeys(Keys.ENTER);
    }
}
