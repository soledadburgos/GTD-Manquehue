package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class AgregarProductosAInstanciaPage {
    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'TELEVISION')]/../td[2]/a")
    public WebElement instanciaTV;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'INTERNET FTTH')]/../td[2]/a")
    public WebElement instanciaInternet;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'LINEA VOZ')]/../td[2]/a")
    public WebElement instanciaLineaVoz;
    
    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'LINEA SIP')]/../td[2]/a")
    public WebElement instancialineasip;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'FIBRA')]/../td[2]/a")
    public WebElement instanciaFibra;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[text()='LINEA ADSL']/following-sibling::td[text()='PENDIENTE']/../td[2]/a")
    public WebElement instanciaLineaADSL;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[text()='TELEVISION']/following-sibling::td[text()='PENDIENTE']/../td[2]/a")
    public WebElement instanciaTelevision;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'instanciasCheckBox')]/../td[2]/a")
    public WebElement instanciaLineaMovilVoz;

    @FindBy(how = How.ID, using = "botonAgregarProducto")
    public WebElement btnAgregarNuevo;

    @FindBy(how = How.ID, using = "botonFinalizarProd")
    public WebElement btnFinalizar;


    public void agregarProductoAction(WebDriver driver, Logger LOGGER, WebElement instancia, String prod, String tipo) throws InterruptedException{
        try{
            WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Agregando producto {0}", prod);
            AgregarNuevoProductoInstanciaPage agregarNuevoProductoInstanciaPage = PageFactory.initElements(driver, AgregarNuevoProductoInstanciaPage.class);
            instancia.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            btnAgregarNuevo.sendKeys(Keys.ENTER);
            agregarNuevoProductoInstanciaPage.AgregarProductoAction(driver, LOGGER, prod, tipo);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al agregar producto {0}", e.getMessage());
        }
    }

    public void desconectarProductoAction(WebDriver driver, Logger LOGGER, WebElement instancia, String prod) throws InterruptedException{
        try{
            WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Desconectando producto {0}", prod);
            instancia.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            driver.findElement(By.xpath("//*/td[contains(.,'"+prod+"')]/../td[1]/input")).sendKeys(Keys.SPACE);
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(driver.findElement(By.xpath("//*/td[contains(.,'"+prod+"')]/../td[4]/select"))).selectByVisibleText("DESCONECTAR");
            WaitTool.waitToLoad(driver, LOGGER);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al desconectar producto {0}", e.getMessage());
        }
    }

    public void agregarAltaTriPlayAction(WebDriver driver, Logger LOGGER, String contratoVoz, String planInternet, String planTVFTTH, String equipoTV) throws InterruptedException{
        agregarProductoAction(driver,LOGGER,instanciaLineaVoz, contratoVoz, "Contrato");
        agregarProductoAction(driver,LOGGER,instanciaInternet, planInternet, "Producto");
        agregarProductoAction(driver,LOGGER,instanciaTV, planTVFTTH, "Producto");
        agregarProductoAction(driver,LOGGER,instanciaTV, equipoTV, "Equipo");
    }

    public void finalizarAgregarProductos(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
    }

    public void adendumTriPlayAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
        desconectarProductoAction(driver, LOGGER, instanciaInternet, "PLAN INTERNET HOGAR 30 Mbps");
        agregarProductoAction(driver, LOGGER, instanciaInternet, "PLAN INTERNET HOGAR 10 Mbps", "Producto");
    }

    public void agregarAltaTriPlayCUAction(WebDriver driver, Logger LOGGER, String productoCU, String contratoVoz, String productoTVCU, String equipoDecoTV) throws InterruptedException{
        agregarProductoAction(driver,LOGGER,instanciaLineaADSL, productoCU, "Producto");
        agregarProductoAction(driver,LOGGER,instanciaLineaADSL, contratoVoz, "Contrato");
        agregarProductoAction(driver,LOGGER,instanciaTelevision, productoTVCU, "Producto");
        agregarProductoAction(driver,LOGGER,instanciaTelevision, equipoDecoTV, "Equipo");
    }

    public void agregarProductosAltaMovilAction(WebDriver driver, Logger LOGGER, String numeroMovil) throws InterruptedException{
        agregarProductoMovilAction(driver,LOGGER,numeroMovil, "PLAN VOZ CON CONTROL 500", "Producto");
        agregarProductoMovilAction(driver,LOGGER,numeroMovil, "SIMCARD USIM - 4G (PQTE)", "Equipo");
    }

    public void agregarProductoMovilAction(WebDriver driver, Logger LOGGER, String numeroMovil, String prod, String tipo) throws InterruptedException{
        try{
            WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Agregando producto {0}", prod);
            AgregarNuevoProductoInstanciaPage agregarNuevoProductoInstanciaPage = PageFactory.initElements(driver, AgregarNuevoProductoInstanciaPage.class);
            driver.findElement(By.xpath("//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'"+numeroMovil+"')]/../td[2]/a")).sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            btnAgregarNuevo.sendKeys(Keys.ENTER);
            agregarNuevoProductoInstanciaPage.AgregarProductoAction(driver, LOGGER, prod, tipo);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al agregar producto {0}", e.getMessage());
        }
    }


    public void seleccionarinstanciacambionumeroAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
    	WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		WaitTool.waitToLoad(driver, LOGGER);
		instancialineasip.sendKeys(Keys.ENTER); 
		WaitTool.waitToLoad(driver, LOGGER);         
		
	}
    
    
    public void AgregarnuevoProductos(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
    }
}
