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

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;


/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class GestorSolicitudPage {
   
	@FindBy(how = How.ID, using =  "areas")
    public WebElement cbbAreas;

    @FindBy(how = How.ID, using =  "idSolicitud")
    public WebElement txtIdSolicitud;

    @FindBy(how = How.ID, using =  "rutCliente")
    public WebElement txtRutCliente;

    @FindBy(how = How.ID, using =  "botonBuscar")
    public WebElement btnBuscar;

    @FindBy(how = How.XPATH, using = "//input[@name='idSolicitudRadio']")
    public WebElement radio1;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tablaInformacion\"]/tbody/tr[1]/td[contains(.,'Tipo de solicitud')]/../../../following-sibling::table/tbody/tr/td[4]")
    public WebElement estado1;

    @FindBy(how = How.ID, using = "iOperacion")
    public WebElement cbbOperacion;

    @FindBy(how = How.ID, using = "iEjecutar")
    public WebElement btnEjecutar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tablaInformacion\"]/tbody/tr[2]/td/div/table/tbody[2]/tr/td[9]")
    public WebElement activoSolic;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tablaInformacion\"]/tbody/tr[1]/td[1]/a")
    public WebElement detalle;



    public void buscarSolicitudAction(WebDriver driver, Logger LOGGER, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        new Select(cbbAreas).selectByValue("-1");
 //       WaitTool.waitToLoad(driver, LOGGER);
        txtIdSolicitud.sendKeys(id);
        btnBuscar.sendKeys(Keys.ENTER);
    }

    public boolean aprobarRevisionComercialAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        String est= "--";
        est = estado1.getText();
        if(!("REVISION COMERCIAL (3)".equals(est))){
            return false;
        }
        checkEstadoSolicitud(driver, LOGGER, path, id);
//        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
  //      WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Aprobar revision comercial");
    //    WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
      //  WaitTool.waitToLoad(driver, LOGGER);
        return true;
    }

    public void ejecutarFactibilidadTecnica(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        Thread.sleep(2000);
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        checkEstadoSolicitud(driver, LOGGER, path, id);
//        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
  //      WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Ejecutar Factibilidad Técnica");
    //    WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
      //  WaitTool.waitToLoad(driver, LOGGER);




    }

    public void AgregarProductosAInstanciaAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        checkEstadoSolicitud(driver, LOGGER, path, id);
 //       WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
   //     WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Agregar productos a instancia");
     //   WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
       // WaitTool.waitToLoad(driver, LOGGER);
    }

    public void AgregarProductosCUAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        checkEstadoSolicitud(driver, LOGGER, path, id);
//        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
  //      WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Agregar productos a instancia");
    //    WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
      //  WaitTool.waitToLoad(driver, LOGGER);
        detalle.sendKeys(Keys.ENTER);
        //WaitTool.waitToLoad(driver, LOGGER);
        String activo = activoSolic.getText();
        LOGGER.info("activo: "+activo);
    }

    public void ReservaNumeracionMovilAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        checkEstadoSolicitud(driver, LOGGER, path, id);
//        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
  //      WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Reserva Numeracion Movil");
    //    WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
      //  WaitTool.waitToLoad(driver, LOGGER);
    }

    public void GestionarContratoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        //checkEstadoSolicitud(driver, LOGGER, path, id);
        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Gestionar Contrato");
        WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void checkEstadoSolicitud(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        LOGGER.log(Level.INFO, "Estado de la solicitud: {0}: ", estado1.getText());
        ScreenShotTool.screenshot(path,"_Solicitud-Estado-"+estado1.getText(), driver, LOGGER);
    }

    public void esperarEstadoSolicitud(WebDriver driver, Logger LOGGER, String estado, String id, String path) throws InterruptedException{
        Thread.sleep(2000);
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        txtIdSolicitud.clear();
        txtIdSolicitud.sendKeys(id);
        String est= "--";
        do {
            Thread.sleep(3000);
            btnBuscar.sendKeys(Keys.ENTER);
 //           WaitTool.waitToLoad(driver, LOGGER);
            est = estado1.getText();
            LOGGER.log(Level.INFO, "Estado de la solicitud: {0}: ", est);
        } while (!est.equalsIgnoreCase(estado));
        checkEstadoSolicitud(driver, LOGGER, path, id);
    }

    public void buscarRutAction(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        new Select(cbbAreas).selectByValue("-1");
//        WaitTool.waitToLoad(driver, LOGGER);
        txtRutCliente.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
  //      WaitTool.waitToLoad(driver, LOGGER);
    }
    
    public void buscarSolicitud2Action(WebDriver driver, Logger LOGGER, String idSol) throws InterruptedException{
    	Thread.sleep(2000);
    	WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        new Select(cbbAreas).selectByValue("-1");
        WaitTool.waitToLoad(driver, LOGGER);
        //txtIdSolicitud.sendKeys(idSol);
        btnBuscar.sendKeys(Keys.ENTER);
         
    }
    
    public void esperarEstadoSolicitud2(WebDriver driver, Logger LOGGER, String estado, String id, String path) throws InterruptedException{
        Thread.sleep(2000);
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        String est= "--";
        do {
            Thread.sleep(3000);
            btnBuscar.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            est = estado1.getText();
            LOGGER.log(Level.INFO, "Estado de la solicitud: {0}: ", est);
        } while (!est.equalsIgnoreCase(estado));
        checkEstadoSolicitud(driver, LOGGER, path, id);
    }
    
    public void esperarEstadoSolicitud3(WebDriver driver, Logger LOGGER, String estado, String id, String path) throws InterruptedException{
        Thread.sleep(2000);
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        String est= "--";
        do {
            Thread.sleep(3000);
            btnBuscar.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            est = estado1.getText();
            LOGGER.log(Level.INFO, "Estado de la solicitud: {0}: ", est);
        } while (!est.equalsIgnoreCase(estado));
        checkEstadoSolicitud(driver, LOGGER, path, id);
    }

    
    public void ModificarProductoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        //checkEstadoSolicitud(driver, LOGGER, path, id);
        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Modificar productos");
        WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }
    
    public void AgregarProductoAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
        //checkEstadoSolicitud(driver, LOGGER, path, id);
        WaitTool.waitToLoad(driver, LOGGER);
        radio1.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbOperacion).selectByVisibleText("Agregar productos a instancia");
        WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }
    
 }
