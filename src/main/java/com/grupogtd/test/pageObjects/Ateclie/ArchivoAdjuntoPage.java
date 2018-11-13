package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.apache.http.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class ArchivoAdjuntoPage {
    @FindBy(how = How.ID, using = "botonSeleccionar")
    public WebElement btnSeleccionar;

    @FindBy(how = How.ID, using = "areaComentario")
    public WebElement txtComentario;

    @FindBy(how = How.ID, using = "botonCerrar")
    public WebElement btnCerrar;

    @FindBy(how = How.ID, using = "botonUpload")
    public WebElement btnCargar;

    @FindBy(how = How.ID, using = "botonBorrar")
    public WebElement btnBorrar;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'OK')]")
    public WebElement btnConfirmar;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/strong")
    public WebElement mensaje1;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/strong")
    public WebElement mensaje2;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/strong")
    public WebElement mensajeExitoso;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/strong")
    public WebElement mensajeBorradoExitoso;

    @FindBy(how = How.XPATH, using = "//*[@id='jqg_tablaArchivos_1']")
    public WebElement chkReclamo;

    public void adjuntarArchivoAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException, IOException {
        WindowHandTool.windowhandle(driver, LOGGER, "Archivo Adjunto");
        LOGGER.log(Level.INFO, "Creando archivo");
        File newFile = new File(path, "DOC"+id+".doc");
        newFile.getParentFile().mkdirs();
        newFile.createNewFile();
        FileWriter fw = new FileWriter(path+"/DOC"+id+".doc");
        fw.write("something");
        fw.close();
        LOGGER.log(Level.INFO, "Cargando archivo");
        btnSeleccionar.sendKeys(newFile.getAbsolutePath());
        txtComentario.sendKeys("Prueba QA");
        btnCargar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnCerrar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO, "Archivo cargado correctamente");
    }

    public void presionarBotonAgregar(WebDriver driver, Logger LOGGER, String noExisteArchivo, String debeSeleccionarArchivo) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Archivo Adjunto");
        LOGGER.log(Level.INFO, "Agregando archivo");
        btnCargar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        String est= "--";
        est = mensaje1.getText();
        Asserts.check(noExisteArchivo.equals(est),"mensaje1 correcto");
        est = mensaje2.getText();
        Asserts.check(debeSeleccionarArchivo.equals(est),"mensaje2 correcto");
    }

    public void adjuntarArchivoEvaluaMensaje(WebDriver driver, Logger LOGGER, String id, String path, String archivoGuardadoCorrectamente) throws InterruptedException, IOException {
        WindowHandTool.windowhandle(driver, LOGGER, "Archivo Adjunto");
        LOGGER.log(Level.INFO, "Creando archivo");
        File newFile = new File(path, "DOC"+id+".doc");
        newFile.getParentFile().mkdirs();
        newFile.createNewFile();
        FileWriter fw = new FileWriter(path+"/DOC"+id+".doc");
        fw.write("something");
        fw.close();
        LOGGER.log(Level.INFO, "Cargando archivo");
        btnSeleccionar.sendKeys(newFile.getAbsolutePath());
        txtComentario.sendKeys("Prueba QA");
        btnCargar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        String est= "--";
        boolean existeMensaje=true;
        do{
            try{
                est = mensajeExitoso.getText();
                LOGGER.info("mensaje actual"+est);
                Asserts.check(archivoGuardadoCorrectamente.equals(est),"mensajeExitoso correcto");
                existeMensaje = true;
            }catch (NoSuchElementException e){
                existeMensaje = false;
            }
        }while (!existeMensaje);

    }

    public void borrarReclamoAdjunto(WebDriver driver, Logger LOGGER) throws InterruptedException {
        WindowHandTool.windowhandle(driver, LOGGER, "Archivo Adjunto");
        WaitTool.waitToLoad(driver, LOGGER);
        chkReclamo.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnBorrar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void ConfirmarBorrar(WebDriver driver, Logger LOGGER, String borradoExitoso) throws InterruptedException{
        WaitTool.waitToLoad(driver, LOGGER);
        btnConfirmar.sendKeys(Keys.ENTER);
        String est= "--";
        est = mensajeBorradoExitoso.getText();
        Asserts.check(borradoExitoso.equals(est),"borradoExitoso correcto");
        WaitTool.waitToLoad(driver, LOGGER);
    }
}
