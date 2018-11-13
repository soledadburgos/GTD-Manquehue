package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.ScreenShotTool;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class CrearReclamoPage {
    @FindBy(how = How.ID, using = "botonCancelar")
    public WebElement btnCancelar;

    @FindBy(how = How.ID, using = "rut")
    public WebElement txtRut;

    @FindBy(how = How.ID, using = "idReclamo")
    public WebElement txtIdReclamo;

    @FindBy(how = How.XPATH, using = "//*[@id='digitoRut']/../input[@type='button']")
    public WebElement btnBuscarCliente;

    @FindBy(how = How.ID, using = "idOrigenReclamo")
    public WebElement cbbOrigenReclamo;

    @FindBy(how = How.ID, using = "subArea")
    public WebElement cbbSubArea;

    @FindBy(how = How.ID, using = "tipoReclamo")
    public WebElement cbbTipoReclamo;

    @FindBy(how = How.ID, using = "medioNotificacion")
    public WebElement cbbTipoNotificacion;

    @FindBy(how = How.ID, using = "telefono")
    public WebElement txtTelefono;

    @FindBy(how = How.ID, using = "area")
    public WebElement rdAreaExterna;

    @FindBy(how = How.XPATH, using = "//*/label[@for='responsableFalla.gtdManquehue']/input")
    public WebElement rdResponsableFalla;

    @FindBy(how = How.ID, using = "//*/label[@for='area.interna']/input")
    public WebElement rdAreaInterna;

    @FindBy(how = How.ID, using = "botonTresPuntosSintomas")
    public WebElement btnIngresarSintomas;

    @FindBy(how = How.ID, using = "botonTresPuntosSolucion")
    public WebElement btnIngresarCausaSolucion;

    @FindBy(how = How.ID, using = "severidad")
    public WebElement cbbSeveridad;

    @FindBy(how = How.ID, using = "prioridad")
    public WebElement cbbPrioridad;

    @FindBy(how = How.ID, using = "propietario")
    public WebElement cbbPropietario;

    @FindBy(how = How.ID, using = "estadoReclamo")
    public WebElement cbbEstadoReclamo;

    @FindBy(how = How.ID, using = "subEstado")
    public WebElement cbbSubEstado;

    @FindBy(how = How.ID, using = "botonNuevoReclamo")
    public WebElement btnNuevoReclamo;

    @FindBy(how = How.ID, using = "botonGuardar")
    public WebElement btnGuardar;

    @FindBy(how = How.ID, using = "botonExportarExcel")
    public WebElement btnExportarExcel;

    @FindBy(how = How.XPATH, using = "/html/body/form/table[3]/tbody/tr/td[1]/input")
    public WebElement btnVerCrearModificar;

    @FindBy(how = How.ID, using = "botonIngresarBitacora")
    public WebElement btnIngresarBitacora;

    @FindBy(how = How.ID, using = "botonArchivoAdjunto")
    public WebElement btnArchivoAdjunto;

    @FindBy(how = How.ID, using = "botonActividadReclamo")
    public WebElement btnActividadReclamo;

    public String crearReclamoAction(WebDriver driver, Logger LOGGER, String rut, String familia, String tipo, String sintoma, String path) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);
        btnBuscarCliente.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO, "Buscando cliente");
        PageFactory.initElements(driver, BuscarClientePorRutPage.class).seleccionarServicioAction(driver, LOGGER, rut, familia);
        LOGGER.log(Level.INFO, "Servicio seleccionado");
        try{
            WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
        }catch (Exception e){
            LOGGER.log(Level.INFO, "Cliente REP {0}", e.getMessage());
        }
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO, "Completando datos");

        boolean existIdOrigenReclamo;
        do{
            try{
                new Select(cbbOrigenReclamo).selectByVisibleText("CLIENTE");
                existIdOrigenReclamo = true;
            }catch(NoSuchElementException e){
                existIdOrigenReclamo = false;
            }
        }while(!existIdOrigenReclamo);

        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);
        rdAreaExterna.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        if(!familia.equalsIgnoreCase("PREGUNTA")){
            new Select(cbbSubArea).selectByVisibleText("RECLAMO");
        }else{
            new Select(cbbSubArea).selectByVisibleText("PREGUNTA");
        }
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbTipoReclamo).selectByVisibleText(tipo);
        WaitTool.waitToLoad(driver, LOGGER);
        boolean seleccionaTipoNotificacion = true;
        if(familia.equalsIgnoreCase("FIDELIZACION")||familia.equalsIgnoreCase("PREGUNTA")){
            seleccionaTipoNotificacion = false;
        }
        if(seleccionaTipoNotificacion){
            new Select(cbbTipoNotificacion).selectByVisibleText("CARTA CERTIFICADA");
            WaitTool.waitToLoad(driver, LOGGER);
        }
        WaitTool.waitToLoad(driver, LOGGER);
        txtTelefono.clear();
        txtTelefono.sendKeys("922112233");
        WaitTool.waitToLoad(driver, LOGGER);
        btnIngresarSintomas.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO, "Ingresando sintomas");
        PageFactory.initElements(driver, ModificaSintomasReclamoPage.class).modificarSintomasAction(driver, LOGGER, sintoma);
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(3000);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
        ScreenShotTool.screenshot(path,"_Sintomas", driver, LOGGER);
        LOGGER.log(Level.INFO, "Sintomas ingresados");
        LOGGER.log(Level.INFO, "Ingresando estado");
        new Select(cbbSeveridad).selectByVisibleText("CON SERVICIO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbPrioridad).selectByVisibleText("BAJO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbPropietario).selectByVisibleText("RURBINA");
        WaitTool.waitToLoad(driver, LOGGER);
        if(familia.equalsIgnoreCase("FIDELIZACION")){
            new Select(cbbSubEstado).selectByVisibleText("ESPERANDO AL CLIENTE");
            WaitTool.waitToLoad(driver, LOGGER);
        }
        if(familia.equalsIgnoreCase("FACTURACION")||familia.equalsIgnoreCase("COMERCIAL")){
            btnIngresarBitacora.sendKeys(Keys.ENTER);
            PageFactory.initElements(driver, BitacoraReclamoPage.class).ingresaBitacoraAction(driver, LOGGER, "Prueba QA");
            Thread.sleep(2000);
            WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
            WaitTool.waitToLoad(driver, LOGGER);
        }
        LOGGER.log(Level.INFO, "Guardando reclamo");
        btnGuardar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitForAlert(driver, LOGGER);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(3000);
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);
        boolean existIdReclamo = true;
        String id = "";
        String nombrePantalla = "Crear Reclamo";
        int intentos = 0;
        do{
            try{
                intentos++;
                id = txtIdReclamo.getAttribute("value");
                existIdReclamo = true;
            }catch(NoSuchElementException e){
                existIdReclamo = false;
                if(intentos>15){
                    nombrePantalla = "Consultar Modificar Reclamo";
                }
                WindowHandTool.windowhandle(driver, LOGGER, nombrePantalla);
            }
        }while(!existIdReclamo);

        while("".equals(id)){
            WindowHandTool.windowhandle(driver, LOGGER, nombrePantalla);
            WaitTool.waitToLoad(driver, LOGGER);
            id = txtIdReclamo.getAttribute("value");
            LOGGER.info("id: "+id);
        }
        Thread.sleep(2000);
        btnCancelar.sendKeys(Keys.ENTER);
        return id;
    }

    public void cerrarReclamoAction(WebDriver driver, Logger LOGGER, String rut, String familia, String solucion, String path, String id) throws InterruptedException, IOException {
        WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);

        LOGGER.log(Level.INFO, "Ingresando solución");
        btnIngresarCausaSolucion.sendKeys(Keys.ENTER);
        PageFactory.initElements(driver, IngresaCausaSolucionPage.class).ingresaCausaSolucionAction(driver, LOGGER, familia, solucion);
        WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
        if(familia.equalsIgnoreCase("FACTURACION")){
            btnActividadReclamo.sendKeys(Keys.ENTER);
            PageFactory.initElements(driver, TodasLasActividades.class).cerrarActividadReclamoAction(driver, LOGGER, path);
            WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
        }if(familia.equalsIgnoreCase("FACTURACION")||familia.equalsIgnoreCase("SERVICIOS")){
            btnArchivoAdjunto.sendKeys(Keys.ENTER);
            PageFactory.initElements(driver, ArchivoAdjuntoPage.class).presionarBotonAgregar(driver, LOGGER, "NO existen archivos adjuntos", "Falta seleccionar un archivo");
            PageFactory.initElements(driver, ArchivoAdjuntoPage.class).adjuntarArchivoAction(driver, LOGGER, id, path);
            WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
        }
        LOGGER.log(Level.INFO, "Modificando estado");
        new Select(cbbEstadoReclamo).selectByVisibleText("CERRADO");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbSubEstado).selectByVisibleText("SELECCIONE");
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);
        if(!familia.equalsIgnoreCase("FIDELIZACION")){
            new Select(cbbSubEstado).selectByVisibleText("RESUELTO");
        }else{
            new Select(cbbSubEstado).selectByVisibleText("CLIENTE FIDELIZADO");
        }
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        new Actions(driver).moveToElement(btnExportarExcel).perform();
        ScreenShotTool.screenshot(path,"_Cerrado", driver, LOGGER);
    }

    public void presionarBotonArchivoAdjunto(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WaitTool.waitToLoad(driver, LOGGER);
        btnArchivoAdjunto.sendKeys(Keys.ENTER);
        WindowHandTool.windowhandle(driver, LOGGER, "Consultar Modificar Reclamo");
    }
}
