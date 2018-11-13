package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.ScreenShotTool;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class GestorReclamosPage {
    @FindBy(how = How.ID, using = "numeroReclamo")
    public WebElement txtNumeroReclamo;

    @FindBy(how = How.ID, using = "numeroReclamoPadre")
    public WebElement txtNumeroReclamoPadre;

    @FindBy(how = How.ID, using = "familiaReclamo")
    public WebElement txtFamiliaReclamo;

    @FindBy(how = How.ID, using = "rutCliente")
    public WebElement txtRutCliente;

    @FindBy(how = How.ID, using = "fechaDesde")
    public WebElement txtFechaDesde;

    @FindBy(how = How.XPATH, using = "/html/body/form/div[1]/table[3]/tbody/tr/td[2]/input")
    public WebElement btnBuscar;

    @FindBy(how = How.XPATH, using = "/html/body/form/table[3]/tbody/tr/td[1]/input")
    public WebElement btnVerCrearModificar;

    @FindBy(how = How.XPATH, using = "/html/body/form/table[2]/tbody/tr/td[1]/input")
    public WebElement btnVerCrearModificarConDatos;

    @FindBy(how = How.ID, using = "fechaDesdePicker")
    public WebElement btnFechaDesde;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/table/thead/tr[2]/td[2]")
    public WebElement btnMesAnterior;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/table/tbody/tr[1]/td[7]")
    public WebElement btnDiaMesAnterior;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/table/thead/tr[1]/td[3]")
    public WebElement btnCierraCalendario;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pager_reclamo_right\"]/div")
    public WebElement mensaje;


    public void verCrearModificarReclamoAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
        LOGGER.log(Level.INFO, "Ingresando a VER/CREAR/MODIFICAR RECLAMO");
        btnVerCrearModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void buscarReclamoAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO, "Buscando Reclamo {0}", id);
        txtNumeroReclamo.clear();
        txtNumeroReclamo.sendKeys(id);
        btnBuscar.sendKeys(Keys.ENTER);
        new Actions(driver).contextClick(driver.findElement(By.xpath("//*[@id='1']/td[contains(.,'"+id+"')]"))).perform();
        ScreenShotTool.screenshot(path,"_Abierto", driver, LOGGER);
        btnVerCrearModificarConDatos.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void presionarBotonBuscar(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
        WaitTool.waitToLoad(driver, LOGGER);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void seleccionFechaDesde(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
        WaitTool.waitToLoad(driver, LOGGER);
        btnFechaDesde.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnMesAnterior.click();
        WaitTool.waitToLoad(driver, LOGGER);
        btnDiaMesAnterior.click();
        WaitTool.waitToLoad(driver, LOGGER);
        try{
            btnCierraCalendario.click();
        }catch(ElementNotVisibleException e){
            System.out.println("No se encuentra el elemento "+e);
        }
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void ingresaRut(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
        WaitTool.waitToLoad(driver, LOGGER);
        txtRutCliente.clear();
        txtRutCliente.sendKeys(rut);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void validaQueExistenReclamos(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WaitTool.waitToLoad(driver, LOGGER);
        String est= "--";
        est = mensaje.getText();
        Asserts.check(!("Sin registros que mostrar".equals(est)),"mensaje correcto");
    }
}
