package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.ScreenShotTool;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class InstalacionesPage {
    @FindBy(how = How.XPATH, using = "//*[@id='fr']/frame[@name='treeframe']")
    public WebElement frameMenu;

    @FindBy(how = How.XPATH, using = "//*/a[contains(.,'Gestor de OT')]")
    public WebElement lnkGestorDeOt;

    @FindBy(how = How.XPATH, using = "//*[@id='fr']/frame[@name='basefrm']")
    public WebElement frameMain;

    @FindBy(how = How.ID, using = "idSolicitud")
    public WebElement txtIdSolicitud;

    @FindBy(how = How.ID, using = "botonBuscar")
    public WebElement btnBuscar;

    @FindBy(how = How.XPATH, using = "//*/a[contains(.,'Administrador Equipos')]")
    public WebElement btnAdminEquipos;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'TELEVISION')]/../td[1]/input")
    public WebElement otTelevisionRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'ADSL')]/../td[1]/input")
    public WebElement otADSLRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[1]/input")
    public WebElement otFibraFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[1]/input")
    public WebElement otVozFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'INT FTTH')]/../td[1]/input")
    public WebElement otIntFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'TV FTTH')]/../td[1]/input")
    public WebElement otTvFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'FIBRA FTTH')]/../td[6]")
    public WebElement otEstadoFibraFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'VOZ FTTH')]/../td[6]")
    public WebElement otEstadoVozFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'INT FTTH')]/../td[6]")
    public WebElement otEstadoIntFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'TV FTTH')]/../td[6]")
    public WebElement otEstadoTvFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'TELEVISION')]/../td[6]")
    public WebElement otEstadoTelevisionRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'ADSL')]/../td[6]")
    public WebElement otEstadoADSLRd;

    @FindBy(how = How.XPATH, using = "//*[@id='gestorOT']/tbody/tr/td[contains(.,'MOVIL_VOZ_POSTPAGO')]/../td[1]/input")
    public WebElement otMovilRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA LINEA FTTH')]/../td[1]/input")
    public WebElement plantillaAltaFibraFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'BAJA ADSL')]/../td[1]/input")
    public WebElement plantillaBajaADSLRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA TV COAXIAL')]/../td[1]/input")
    public WebElement plantillaAltaTelevisionRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA ADSL')]/../td[1]/input")
    public WebElement plantillaAltaADSLRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA LINEA VOZ FTTH')]/../td[1]/input")
    public WebElement plantillaAltaVozFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA LINEA INT FTTH')]/../td[1]/input")
    public WebElement plantillaAltaIntFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA LINEA TV FTTH')]/../td[1]/input")
    public WebElement plantillaAltaTvFTTHRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'BAJA MEDIO FISICO')]/../td[1]/input")
    public WebElement plantillabajaMedioFisicoRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'BAJA TV-CU')]/../td[1]/input")
    public WebElement plantillabajaTvCURd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'TRASLADO MEDIO FISICO CU A FTTH')]/../td[1]/input")
    public WebElement plantillaTrasladoCuAFtthRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA INT FTTH X TRASLADO ADSL C/R')]/../td[1]/input")
    public WebElement plantillaTrasladoIntRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'TRASLADO TV COAXIAL A TV FTTH')]/../td[1]/input")
    public WebElement plantillaTrasladoTVtRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'TRASLADO CU ADSL C/R A FTTH')]/../td[1]/input")
    public WebElement plantillaTrasladoVOZRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ADENDUM CAMBIO PLAN INTERNET FTTH')]/../td[1]/input")
    public WebElement plantillaAdendumCambioPlanInternetRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ADENDUM INSTALACION EQUIPO')]/../td[1]/input")
    public WebElement plantillaAdendumAdendumInstalacionEquipoRd;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaActividadCollapse']/div/div/div/table/tbody/tr/td[contains(.,'ALTA SERVICIO MOVIL')]/../td[1]/input")
    public WebElement plantillaAltaMovilRd;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ACCESODX')]/../td[6]")
    public WebElement estadoACCESODX;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'ACCESODX')]/../td[6]")
    public WebElement estadoACCESODX2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'EJECCRUZ')]/../td[6]")
    public WebElement estadoEJECCRUZ;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'EJECCRUZ')]/../td[6]")
    public WebElement estadoEJECCRUZ2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'INSTALAD')]/../td[6]")
    public WebElement estadoINSTALAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'INSTALAD')]/../td[6]")
    public WebElement estadoINSTALAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'OPERCOM')]/../td[6]")
    public WebElement estadoOPERCOM;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'OPERCOM')]/../td[6]")
    public WebElement estadoOPERCOM2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'AGVTAS')]/../td[6]")
    public WebElement estadoAGVTAS;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'HEADEND')]/../td[6]")
    public WebElement estadoHEADEND;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ASIGNAD')]/../td[6]")
    public WebElement estadoASIGNAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'ASIGNAD')]/../td[6]")
    public WebElement estadoASIGNAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[3]/td[contains(.,'ASIGNAD')]/../td[6]")
    public WebElement estadoASIGNAD3;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SOPFTTH')]/../td[6]")
    public WebElement estadoSOPFTTH;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SISTEMAS')]/../td[6]")
    public WebElement estadoSISTEMAS;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SOPFTTH')]/../td[5]")
    public WebElement nombreActividadSOPFTTH;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ACCESODX')]/../td[5]")
    public WebElement nombreActividadACCESODX;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'ACCESODX')]/../td[5]")
    public WebElement nombreActividadACCESODX2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'HEADEND')]/../td[5]")
    public WebElement nombreActividadHEADEND;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'OPERCOM')]/../td[5]")
    public WebElement nombreActividadOPERCOM;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'OPERCOM')]/../td[5]")
    public WebElement nombreActividadOPERCOM2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'EJECCRUZ')]/../td[5]")
    public WebElement nombreActividadEJECCRUZ;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'EJECCRUZ')]/../td[5]")
    public WebElement nombreActividadEJECCRUZ2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'INSTALAD')]/../td[5]")
    public WebElement nombreActividadINSTALAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'INSTALAD')]/../td[5]")
    public WebElement nombreActividadINSTALAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'AGVTAS')]/../td[5]")
    public WebElement nombreActividadAGVTAS;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ASIGNAD')]/../td[5]")
    public WebElement nombreActividadASIGNAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'ASIGNAD')]/../td[5]")
    public WebElement nombreActividadASIGNAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[3]/td[contains(.,'ASIGNAD')]/../td[5]")
    public WebElement nombreActividadASIGNAD3;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[5]")
    public WebElement nombreActividadValidaPeriferico;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SISTEMAS')]/../td[5]")
    public WebElement nombreActividadSISTEMAS;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ACCESODX')]/../td[3]/a")
    public WebElement linkACCESODX;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'ACCESODX')]/../td[3]/a")
    public WebElement linkACCESODX2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SOPFTTH')]/../td[3]/a")
    public WebElement linkSOPFTTH;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'HEADEND')]/../td[3]/a")
    public WebElement linkHEADEND;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'EJECCRUZ')]/../td[3]/a")
    public WebElement linkEJECCRUZ;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[contains(.,'EJECCRUZ')]/../td[3]/a")
    public WebElement linkEJECCRUZ2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'INSTALAD')]/../td[3]/a")
    public WebElement linkINSTALAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[3]/a")
    public WebElement linkINSTALAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'AGVTAS')]/../td[3]/a")
    public WebElement linkAGVTAS;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'OPERCOM')]/../td[3]/a")
    public WebElement linkOPERCOM;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[3]/a")
    public WebElement linkOPERCOM2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'ASIGNAD')]/../td[3]/a")
    public WebElement linkASIGNAD;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[2]/td[3]/a")
    public WebElement linkASIGNAD2;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr[3]/td[3]/a")
    public WebElement linkASIGNAD3;

    @FindBy(how = How.XPATH, using = "//*[@id='activ']/tbody/tr/td[contains(.,'SISTEMAS')]/../td[3]/a")
    public WebElement linkSISTEMAS;

    public void buscarSolicitudAction(WebDriver driver, Logger LOGGER, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        WaitTool.waitToLoad(driver, LOGGER);
        driver.switchTo().frame(frameMenu);
        lnkGestorDeOt.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        driver.switchTo().frame(frameMain);
        txtIdSolicitud.sendKeys(id);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void administradorEquiposAction(WebDriver driver, Logger LOGGER, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(2000);
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        driver.switchTo().frame(frameMain);
        btnAdminEquipos.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void CierreActividadAction(WebDriver driver, Logger LOGGER, String glosa, String path, WebElement servicio, WebElement plantilla, WebElement estadoArea, WebElement linkArea, WebElement nombreActividad) throws InterruptedException{
        DetalleActividadesPage detalleActividadesPage = PageFactory.initElements(driver, DetalleActividadesPage.class);
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        driver.switchTo().frame(frameMain);
        LOGGER.log(Level.INFO,"Cerrando Actividad {0}",glosa);
        String est = "";
        servicio.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        do{
            try {
                plantilla.sendKeys(Keys.SPACE);
                WaitTool.waitToLoad(driver, LOGGER);
                est = estadoArea.getText();
                LOGGER.log(Level.INFO,"Estado de la actividad: "+est);
                if(est.equalsIgnoreCase("AUTOMATICA")){
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO,e.getMessage());
            }
        }while(est.equalsIgnoreCase("AUTOMATICA"));
        if(est.equalsIgnoreCase("EN PROGRESO")|| est.equalsIgnoreCase("MANUAL")){
            LOGGER.log(Level.INFO,"Cerrando actividad {0}",nombreActividad.getText());
            boolean tri = false;
            do{
                try {
                    linkArea.sendKeys(Keys.ENTER);
                    Thread.sleep(2000);
                    detalleActividadesPage.cerrarActividadAction(driver, LOGGER, path, "CERRADA", "OK", nombreActividad.getText());
                    tri = true;
                } catch (Exception e) {
                    LOGGER.log(Level.INFO,e.getMessage());
                }
            }while(!tri);

        }
    }

    public void CierreAltaAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "FIBRA FTTH ACCESODX", path, otFibraFTTHRd, plantillaAltaFibraFTTHRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "FIBRA FTTH EJECCRUZ", path, otFibraFTTHRd, plantillaAltaFibraFTTHRd, estadoEJECCRUZ, linkEJECCRUZ, nombreActividadEJECCRUZ);
        CierreActividadAction(driver, LOGGER, "FIBRA FTTH INSTALAD", path, otFibraFTTHRd, plantillaAltaFibraFTTHRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "VOZ FTTH ACCESODX", path, otVozFTTHRd, plantillaAltaVozFTTHRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "VOZ FTTH INSTALAD", path, otVozFTTHRd, plantillaAltaVozFTTHRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "INT FTTH INSTALAD", path, otIntFTTHRd, plantillaAltaIntFTTHRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "INT FTTH INSTALAD", path, otIntFTTHRd, plantillaAltaIntFTTHRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TV FTTH INSTALAD", path, otTvFTTHRd, plantillaAltaTvFTTHRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "TV FTTH INSTALAD", path, otTvFTTHRd, plantillaAltaTvFTTHRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
    }

    public void cierreBajaAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA AGVTAS", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoAGVTAS, linkAGVTAS, nombreActividadAGVTAS);
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA ASIGNAD", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoASIGNAD, linkASIGNAD, nombreActividadASIGNAD);
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA ACCESODX", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA INSTALAD", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA EJECCRUZ", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoEJECCRUZ, linkEJECCRUZ, nombreActividadEJECCRUZ);
        CierreActividadAction(driver, LOGGER, "BAJA COMPLETA ASIGNAD", path, otFibraFTTHRd, plantillabajaMedioFisicoRd, estadoASIGNAD, linkASIGNAD, nombreActividadASIGNAD);
    }

    public void cierreBajaCUAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        ForzarCierreActividadAutomaticaAction(driver, LOGGER, "BAJA TV CU HEADEND", path, otTelevisionRd, plantillabajaTvCURd, estadoHEADEND, linkHEADEND, nombreActividadHEADEND);
        CierreActividadAction(driver, LOGGER, "BAJA TV CU INSTALAD", path, otTelevisionRd, plantillabajaTvCURd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);

        CierreActividadAction(driver, LOGGER, "BAJA ADSL ASIGNAD", path, otADSLRd, plantillaBajaADSLRd, estadoASIGNAD, linkASIGNAD, nombreActividadASIGNAD);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL ASIGNAD", path, otADSLRd, plantillaBajaADSLRd, estadoASIGNAD3, linkASIGNAD3, nombreActividadASIGNAD3);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL ACCESODX", path, otADSLRd, plantillaBajaADSLRd, estadoACCESODX2, linkACCESODX2, nombreActividadACCESODX2);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL OPERCOM", path, otADSLRd, plantillaBajaADSLRd, estadoOPERCOM, linkOPERCOM, nombreActividadOPERCOM);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL EJECCRUZ", path, otADSLRd, plantillaBajaADSLRd, estadoEJECCRUZ2, linkEJECCRUZ2, nombreActividadEJECCRUZ2);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL INSTALAD", path, otADSLRd, plantillaBajaADSLRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "BAJA ADSL ASIGNAD", path, otADSLRd, plantillaBajaADSLRd, estadoASIGNAD, linkASIGNAD, nombreActividadASIGNAD);
    }

    public void cierreAdendumTriPlayAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "CAMBIO PLAN INT FTTH X ADENDUM CAMBIO PLAN INTERNET FTTH", path, otIntFTTHRd, plantillaAdendumCambioPlanInternetRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        //CierreActividadAction(driver, LOGGER, "ADENDUM INSTALACION EQUIPO", path, otVozFTTHRd, plantillaAdendumAdendumInstalacionEquipoRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
    }


    public void esperarEstadoSolicitudAction(WebDriver driver, Logger LOGGER, String estado, WebElement otEstado, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        driver.switchTo().frame(frameMain);
        txtIdSolicitud.clear();
        txtIdSolicitud.sendKeys(id);
        do {
            Thread.sleep(3000);
            btnBuscar.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            LOGGER.log(Level.INFO, "Estado de la solicitud en instalación: {0}: ", otEstado.getText());
        } while (!otEstado.getText().equalsIgnoreCase(estado));
        ScreenShotTool.screenshot(path, "_Instalaciones-"+otEstado.getText(), driver, LOGGER);
    }

    public void esperarEstadosAltaTriplayAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoFibraFTTHRd, id, path);
    }

    public void esperarEstadosBajaTriplayAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoFibraFTTHRd, id, path);
    }

    public void esperarEstadosAdendumTriplayAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoIntFTTHRd, id, path);
        //esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoVozFTTHRd, id, path);
    }

    public void esperarEstadosAltaTriplayCUAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoTelevisionRd, id, path);
        //esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoADSLRd, id, path);
    }

    public void CierreAltaCUAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "TELEVISION INSTALAD", path, otTelevisionRd, plantillaAltaTelevisionRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "ADSL OPERCOM", path, otADSLRd, plantillaAltaADSLRd, estadoOPERCOM, linkOPERCOM, nombreActividadOPERCOM);
        CierreActividadAction(driver, LOGGER, "ADSL ACCESODX", path, otADSLRd, plantillaAltaADSLRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "ADSL EJECCRUZ", path, otADSLRd, plantillaAltaADSLRd, estadoEJECCRUZ, linkEJECCRUZ, nombreActividadEJECCRUZ);
        CierreActividadAction(driver, LOGGER, "ADSL INSTALAD", path, otADSLRd, plantillaAltaADSLRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
    }

    public void cierreTrasladoAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "TRASLADO FIBRA FTTH ACCESODX", path, otFibraFTTHRd, plantillaTrasladoCuAFtthRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "TRASLADO FIBRA FTTH EJECCRUZ", path, otFibraFTTHRd, plantillaTrasladoCuAFtthRd, estadoEJECCRUZ, linkEJECCRUZ, nombreActividadEJECCRUZ);
        CierreActividadAction(driver, LOGGER, "TRASLADO FIBRA FTTH INSTALAD", path, otFibraFTTHRd, plantillaTrasladoCuAFtthRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TRASLADO FIBRA FTTH SOPFTTH", path, otFibraFTTHRd, plantillaTrasladoCuAFtthRd, estadoSOPFTTH, linkSOPFTTH, nombreActividadSOPFTTH);
        CierreActividadAction(driver, LOGGER, "TRASLADO INT FTTH INSTALAD", path, otIntFTTHRd, plantillaTrasladoIntRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TRASLADO TV FTTH INSTALAD", path, otTvFTTHRd, plantillaTrasladoTVtRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TRASLADO TV FTTH INSTALAD", path, otTvFTTHRd, plantillaTrasladoTVtRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TRASLADO VOZ FTTH INSTALAD", path, otVozFTTHRd, plantillaTrasladoVOZRd, estadoINSTALAD, linkINSTALAD, nombreActividadINSTALAD);
        CierreActividadAction(driver, LOGGER, "TRASLADO VOZ FTTH EJECCRUZ", path, otVozFTTHRd, plantillaTrasladoVOZRd, estadoEJECCRUZ, linkEJECCRUZ, nombreActividadEJECCRUZ);
        CierreActividadAction(driver, LOGGER, "TRASLADO VOZ FTTH ACCESODX", path, otVozFTTHRd, plantillaTrasladoVOZRd, estadoACCESODX, linkACCESODX, nombreActividadACCESODX);
        CierreActividadAction(driver, LOGGER, "TRASLADO VOZ FTTH ASIGNAD", path, otVozFTTHRd, plantillaTrasladoVOZRd, estadoASIGNAD, linkASIGNAD, nombreActividadASIGNAD);
    }

    public void esperarEstadosTrasladoAction(WebDriver driver, Logger LOGGER, String id, String path) throws InterruptedException{
        Thread.sleep(1000);
        esperarEstadoSolicitudAction(driver, LOGGER, "SOLICITUD ACTIVA (11)", otEstadoFibraFTTHRd, id, path);
    }

    public void CierreAltaMovilAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        CierreActividadAction(driver, LOGGER, "ACTIVA SERVICIOS MOVIL X ALTA", path, otMovilRd, plantillaAltaMovilRd, estadoSISTEMAS, linkSISTEMAS, nombreActividadSISTEMAS);
    }

    public void ForzarCierreActividadAutomaticaAction(WebDriver driver, Logger LOGGER, String glosa, String path, WebElement servicio, WebElement plantilla, WebElement estadoArea, WebElement linkArea, WebElement nombreActividad) throws InterruptedException{
        DetalleActividadesPage detalleActividadesPage = PageFactory.initElements(driver, DetalleActividadesPage.class);
        Thread.sleep(1000);
        WindowHandTool.windowhandle(driver, LOGGER, "Home");
        driver.switchTo().frame(frameMain);
        LOGGER.log(Level.INFO,"Cerrando Actividad {0}",glosa);
        String est = "";
        servicio.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);

        try {
            plantilla.sendKeys(Keys.SPACE);
            WaitTool.waitToLoad(driver, LOGGER);
            est = estadoArea.getText();
            LOGGER.log(Level.INFO,"Estado de la actividad: "+est);
        } catch (Exception e) {
            LOGGER.log(Level.INFO,e.getMessage());
        }
        LOGGER.log(Level.INFO,"Cerrando actividad {0}",nombreActividad.getText());
        boolean tri = false;
        do{
            try {
                linkArea.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
                detalleActividadesPage.cerrarActividadAction(driver, LOGGER, path, "CERRADA", "OK", nombreActividad.getText());
                tri = true;
            } catch (Exception e) {
                LOGGER.log(Level.INFO,e.getMessage());
            }
        }while(!tri);

    }
}
