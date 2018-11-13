package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.ScreenShotTool;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class CrearSolicitudPage {
    
	@FindBy(how = How.LINK_TEXT, using =  "Crear/Modificar Cliente")
    public WebElement lnkCrearModificarCte;

    @FindBy(how = How.LINK_TEXT, using =  "Agregar Productos a Instancias")
    public WebElement lnkAgregarProductosAInstancias;

    @FindBy(how = How.LINK_TEXT, using =  "Buscar Cuenta Servicio")
    public WebElement lnkBuscarCtaServicio;

    @FindBy(how = How.LINK_TEXT, using =  "Buscar Cta Servicio")
    public WebElement lnkBuscarCtaServicioMovil;

    @FindBy(how = How.LINK_TEXT, using =  "Servicio Solicitado")
    public WebElement lnkServicioSolicitado;

    @FindBy(how = How.LINK_TEXT, using =  "Datos de la venta")
    public WebElement lnkDatosDeLaVenta;

    @FindBy(how = How.LINK_TEXT, using =  "Crear/Modificar Cta Facturación")
    public WebElement lnkCrearModificarCtaFact;

    @FindBy(how = How.LINK_TEXT, using =  "Crear/Modificar Cta Facturación")
    public WebElement lnkCrearModificarCtaFactMovil;

    @FindBy(how = How.LINK_TEXT, using =  "Buscar Cta Facturación")
    public WebElement lnkBuscarCtaFact;

    @FindBy(how = How.LINK_TEXT, using =  "Crear/Modificar Contacto - Cliente")
    public WebElement lnkCrearModificarContacto;

    @FindBy(how = How.LINK_TEXT, using =  "Crea/Modifica Contacto - Cliente")
    public WebElement lnkCrearModificarContactoMovil;

    @FindBy(how = How.LINK_TEXT, using =  "Crea/Modifica Contacto - Cliente")
    public WebElement lnkCreaModificaContacto;

    @FindBy(how = How.LINK_TEXT, using =  "Crea/Modifica Cambio de N°")
    public WebElement lnkCreaModificacambion;
    
    @FindBy(how = How.ID, using =  "botonCrearSolicitud")
    public WebElement btnCrearSolicitud;

    @FindBy(how = How.XPATH, using =  "//*[@id='centro']/p[2]/input")
    public WebElement btnFinalizarFaseBaja;

    @FindBy(how = How.XPATH, using =  "//*[@id='centro']/p[2]/input")
    public WebElement btngestorsol;

    @FindBy(how = How.XPATH, using =  "//tr[@class='titulo']/th[contains(.,'Datos de la solicitud')]/../../following-sibling::tbody/tr[1]/td[1]")
    public WebElement idSolicitud;

    @FindBy(how = How.ID, using =  "areas")
    public WebElement cbbAreas;
    
    @FindBy(how = How.ID, using =  "botonBuscar")
    public WebElement btnBuscar;
    

    public void ingresoCrearClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarCte.sendKeys(Keys.ENTER);
    }


    public void agregarProductosAInstanciasAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkAgregarProductosAInstancias.sendKeys(Keys.ENTER);
    }

    public void buscarCuentaServicioAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkBuscarCtaServicio.sendKeys(Keys.ENTER);
    }

    public void buscarCuentaServicioMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkBuscarCtaServicioMovil.sendKeys(Keys.ENTER);
    }

    public void servicioSolicitadoAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        boolean stsOK = false;
        do{
            Thread.sleep(500);
            WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
            lnkServicioSolicitado.sendKeys(Keys.ENTER);
            LOGGER.log(Level.INFO,"click a servicio solicitado");
            for (int i = 0; i < 10; i++) {
                stsOK = WindowHandTool.windowhandleStsSuper(driver, LOGGER);
                if(stsOK)
                    break;
                Thread.sleep(1000);
            }
            if(!stsOK){
                WindowHandTool.bugWindowRepair(driver, LOGGER);
            }
        }while(!stsOK);
    }

    public void datosDeLaVentaAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkDatosDeLaVenta.sendKeys(Keys.ENTER);
    }

    public void crearModificarCtaFactAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarCtaFact.sendKeys(Keys.ENTER);
    }

    public void crearModificarCtaFactMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarCtaFactMovil.sendKeys(Keys.ENTER);
    }

    public void buscarCtaFactAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkBuscarCtaFact.sendKeys(Keys.ENTER);
    }

    public void crearModificarContactoClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarContacto.sendKeys(Keys.ENTER);
    }

    public void crearModificarContactoClienteMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarContactoMovil.sendKeys(Keys.ENTER);
    }

    
    public void creaModificaContactoClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCrearModificarContacto.sendKeys(Keys.ENTER);
    }
    
    public void creamodificacambiodenumeroAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        lnkCreaModificacambion.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }
    
    public String finalizarFaseAltaAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        ScreenShotTool.screenshot(path,"_Alta-Resumen", driver, LOGGER);
        btnCrearSolicitud.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
      //  WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Alta-Finalizada", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} creada", idSol);
        driver.close();
        return idSol;
    }

    public String finalizarFase1BajaAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        ScreenShotTool.screenshot(path,"_Baja-Resumen", driver, LOGGER);
        btnCrearSolicitud.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
       // WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Baja-Finalizada", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} creada", idSol);
        return idSol;
    }

    public void finalizarFase2BajaAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnFinalizarFaseBaja.sendKeys(Keys.ENTER);
        ScreenShotTool.screenshot(path,"_Baja-Finalizada", driver, LOGGER);
        driver.close();
    }


    public String getwindow(WebDriver driver, Logger LOGGER) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        return driver.getWindowHandle();
    }

    public String finalizarFase1AdendumAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnCrearSolicitud.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        //WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Adendum-Resumen", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} creada", idSol);
        return idSol;
    }

    public void finalizarFase2AdendumAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnFinalizarFaseBaja.sendKeys(Keys.ENTER);
        //WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Adendum-Resumen", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} finalizada", idSol);
        driver.close();
    }

    public String finalizarFase1TrasladoAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnCrearSolicitud.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Traslado-Resumen", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} creada", idSol);
        return idSol;
    }

    public void finalizarFase2TrasladoAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnFinalizarFaseBaja.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_Traslado-Resumen", driver, LOGGER);
        driver.close();
    }

    public String finalizarFase1Action(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        Thread.sleep(500);
        WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        ScreenShotTool.screenshot(path,"_agregar-producto-Resumen", driver, LOGGER);
        btnCrearSolicitud.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_agregar-producto-Finalizada", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} creada", idSol);
        return idSol;
    }
    
    public void finalizarFase2Action(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
    	WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btnFinalizarFaseBaja.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        ScreenShotTool.screenshot(path,"_agregar-producto-Finalizada", driver, LOGGER);
        String idSol = idSolicitud.getText();
        LOGGER.log(Level.INFO,"Solicitud {0} finalizada", idSol);
        btngestorsol.sendKeys(Keys.ENTER);
        //driver.close();
    } 
    
    public void GestorSolicitudAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
    	WindowHandTool.windowhandle(driver, LOGGER, "Crear Solicitud");
        btngestorsol.sendKeys(Keys.ENTER);
        //WaitTool.waitToLoad(driver, LOGGER);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
}
