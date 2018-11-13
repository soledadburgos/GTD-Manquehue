package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.utility.WaitTool;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class ResumenClientePage {
   
	@FindBy(how = How.ID, using =  "rut")
    public WebElement txtRut;

    @FindBy(how = How.ID, using =  "botonBuscar")
    public WebElement btnBuscar;
    
  
    //selecciona el radiobutton a través del numero de cuenta
//    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion2']/tbody/tr/td[contains(.,'3118633')]/../td[1]/input")
//    public WebElement rdCtaFacturacion;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'TELEVISION FTTH')]/../td[1]/input")
    public WebElement rdInstanciaFTTH;
    
    
    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'LINEA SIP')]/../td[1]/input")
    public WebElement numlineasip;
    

    @FindBy(how = How.XPATH, using =  "//*[@id='resultadosRC']/table[4]/tbody/tr/td[2]/a")
    public WebElement enlaceRecreaPassword;

//    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion2']/tbody/tr/td[contains(.,'3264638')]/../td[1]/input")
//    public WebElement rdCtaServicio;
//    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion2']/tbody/tr/td[contains(.,'3119099')]/../td[1]/input")
//    public WebElement rdCtaServicioCU;

    @FindBy(how = How.ID, using =  "listaTipoSolicitudesId")
    public WebElement cbbTipoSolicitud;

    @FindBy(how = How.ID, using =  "botonCrear")
    public WebElement btnCrear;


    @FindBy(how = How.ID, using =  "btnMetrogasCerrar")
    public WebElement btnCerrarMetrogas;


    @FindBy(how= How.XPATH, using = "//*[@id='SegmentoTextoPrincipal']/div[1]/b")
    public WebElement mensajeMetrogas;
    
    //@FindBy(how= How.ID, using = "descripcionEncuesta")
   // private WebElement mensajeEncuesta;
    
   // @FindBy(how= How.XPATH, using = "/html/body/div[5]/div[1]/button")
  //  private WebElement btnCerrarEncuesta;


    public WebElement rdCuenta(WebDriver driver, String cta){
        return driver.findElement(By.xpath("//*[@id='tablaInformacion2']/tbody/tr/td[contains(.,'"+cta+"')]/../td[1]/input"));
    
    
    }

    public void crearAltaAction(WebDriver driver, Logger LOGGER, String rut, String ctaFacturacion) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        boolean existCtaFacturacion;
        do{
            WaitTool.waitToLoad(driver, LOGGER);
            try{
                WebElement rdCtaFacturacion = rdCuenta(driver, ctaFacturacion);
                rdCtaFacturacion.sendKeys(Keys.SPACE);
                existCtaFacturacion = true;
            }catch(InvalidSelectorException e){
                System.out.println("no encuentra cuenta facturación: "+ctaFacturacion+" error:"+e);
                existCtaFacturacion = false;
            }
        }while(!existCtaFacturacion);

        new Select(cbbTipoSolicitud).selectByVisibleText("ALTA");
        btnCrear.sendKeys(Keys.ENTER);
    }

    public void crearAltaMovilAction(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaFacturacion = rdCuenta(driver,Datos.ctaFacturacion);
        rdCtaFacturacion.sendKeys(Keys.SPACE);
        new Select(cbbTipoSolicitud).selectByVisibleText("ALTA GTD MOVIL");
        btnCrear.sendKeys(Keys.ENTER);
    }

    public void crearBajaAction(WebDriver driver, Logger LOGGER, String rut, String ctaServicio) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        boolean existCtaServicio;
        do{
            try{
                WaitTool.waitToLoad(driver, LOGGER);
                WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
                rdCtaServicio.sendKeys(Keys.SPACE);
                existCtaServicio = true;
            }catch(InvalidSelectorException e){
                System.out.println("No se encuentra ctaServicio: "+ctaServicio+" error: "+e);
                existCtaServicio = false;
            }
        }while(!existCtaServicio);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
        rdCtaServicio.sendKeys(Keys.SPACE);
        new Select(cbbTipoSolicitud).selectByVisibleText("BAJA");
        btnCrear.sendKeys(Keys.ENTER);
    }

    /**
     * Created by soledad.burgos on 04-10-2018.
     */
    public void agregarModificarProductosAction(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaServicio = rdCuenta(driver,Datos.ctaServicioFTTH);
        rdCtaServicio.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        rdInstanciaFTTH.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbTipoSolicitud).selectByVisibleText("AGREGAR/MODIFICAR PRODUCTOS");
        btnCrear.sendKeys(Keys.ENTER);
    }

    public void TrasladoAction(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaServicioCU = rdCuenta(driver, Datos.ctaServicioCU);
        rdCtaServicioCU.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbTipoSolicitud).selectByVisibleText("TRASLADO");
        btnCrear.sendKeys(Keys.ENTER);
    }

    public void seleccionarCtaFact(WebDriver driver, Logger LOGGER, String rut, String ctaFacturacion) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaFacturacion = rdCuenta(driver, ctaFacturacion);
        rdCtaFacturacion.sendKeys(Keys.SPACE);

    }

    public void seleccionaUrlRecrearPass(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WaitTool.waitToLoad(driver, LOGGER);
        enlaceRecreaPassword.sendKeys(Keys.ENTER);

        WaitTool.waitToLoad(driver, LOGGER);

    }

    public void buscaCliente(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void evaluarMensaje(WebDriver driver, Logger LOGGER, String mensaje) throws InterruptedException{
        String est= "--";
        mensaje = "¿Metrogas Combo S - 10% los 3 primeros meses para un cilindros de 15 Kg?";
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WaitTool.waitToLoad(driver, LOGGER);
        boolean foundElement;
        do{
            try{
                est = mensajeMetrogas.getText();
                foundElement = true;
            }catch(NoSuchElementException e){
                foundElement = false;
                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                }
                WaitTool.waitToLoad(driver, LOGGER);
            }
        }while(!foundElement);

        Asserts.check(mensaje.equals(est),"Mensaje correcto");
        btnCerrarMetrogas.click();
        WaitTool.waitToLoad(driver, LOGGER);
    }
    
    
    /**
     * Created by soledad.burgos on 07-11-2018.
     */
    public void cambiodenumeroAction(WebDriver driver, Logger LOGGER, String rut, String ctaServicio) throws InterruptedException{
    	txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        boolean existCtaServicio;
        do{
            try{
                WaitTool.waitToLoad(driver, LOGGER);
                WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
                rdCtaServicio.sendKeys(Keys.SPACE);
                existCtaServicio = true;
            }catch(InvalidSelectorException e){
                System.out.println("No se encuentra ctaServicio: "+ctaServicio+" error: "+e);
                existCtaServicio = false;
            }
        }while(!existCtaServicio);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
        rdCtaServicio.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        numlineasip.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbTipoSolicitud).selectByVisibleText("CAMBIO DE N�");
        btnCrear.sendKeys(Keys.ENTER);
  
    }
    
    
    /**
     * Created by soledad.burgos on 12-11-2018.
     */
    public void trasladoInternetFTTHAction(WebDriver driver, Logger LOGGER, String rut, String ctaServicio) throws InterruptedException{
    	txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        boolean existCtaServicio;
        do{
            try{
                WaitTool.waitToLoad(driver, LOGGER);
                WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
                rdCtaServicio.sendKeys(Keys.SPACE);
                existCtaServicio = true;
            }catch(InvalidSelectorException e){
                System.out.println("No se encuentra ctaServicio: "+ctaServicio+" error: "+e);
                existCtaServicio = false;
            }
        }while(!existCtaServicio);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement rdCtaServicio = rdCuenta(driver, ctaServicio);
        rdCtaServicio.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbTipoSolicitud).selectByVisibleText("TRASLADO");
        btnCrear.sendKeys(Keys.ENTER);
  
    }
    
}
