package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class CuentaFacturacionBuscarEliminarPage {
	
	private WaitTool waitTool;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset/table/tbody/tr[2]/td/input[1]")
    public WebElement btnBuscar;

    //    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'3272513')]/../td[1]/input")
//    public WebElement rdCtaFact;
//
    @FindBy(how = How.ID, using =  "botonFormularioModificar")
    public WebElement btnModificar;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[2]/table[2]/tbody/tr/td[1]/input")
    public WebElement btnSeleccionar;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/fieldset[2]/table[2]/tbody/tr[2]/td/input[@value='MODIFICAR']")
    public WebElement btnModificar2;
 
   
    public WebElement rdCuentafac(WebDriver driver, String ctafacturacion){
        return driver.findElement(By.xpath("//*/td[contains(.,'"+ctafacturacion+"')]/../td[1]/input"));
    } 
        
    public WebElement rdCuenta(WebDriver driver, String cta){
        return driver.findElement(By.xpath("//*/td[contains(.,'"+cta+"')]/../td[1]/input"));
    }

    public void seleccionarCtaFactAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        String crearSolicitudWindow = driver.getWindowHandle();
        WindowHandTool.windowhandle(driver, LOGGER, "Cuenta facturacion buscar eliminar");
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdCuenta(driver, Datos.ctaFacturacion).sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSeleccionar.sendKeys(Keys.SPACE);
        WindowHandTool.windowhandleByElement(driver, LOGGER, btnModificar2);
        driver.close();
        driver.switchTo().window(crearSolicitudWindow);
    }
    
    public void seleccionarCtaFacturacionAction(WebDriver driver, Logger LOGGER, String ctafacturacion) throws InterruptedException{
    	WindowHandTool.windowhandle(driver, LOGGER, "Cuenta facturacion a buscar");
    	waitTool = new WaitTool(driver);
    	waitTool.buscarctafacturacion(By.xpath("/html/body/form/fieldset/table/tbody/tr[2]/td/input[1]")); 
		boolean existCtafacturacion;
        do{
            try{
                WaitTool.waitToLoad(driver, LOGGER);
                WebElement Cuentafac = rdCuentafac(driver, ctafacturacion);
				Cuentafac.sendKeys(Keys.SPACE);
                existCtafacturacion = true;
            }catch(InvalidSelectorException e){
                System.out.println("No se encuentra cuenta de facturacion: "+ctafacturacion+" error: "+e);
                existCtafacturacion = false;
            }
        }while(!existCtafacturacion);
        WaitTool.waitToLoad(driver, LOGGER);
        WebElement Cuentafac = rdCuentafac(driver, ctafacturacion);
        Cuentafac.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
		
        btnSeleccionar.sendKeys(Keys.SPACE);
        WindowHandTool.windowhandleByElement(driver, LOGGER, btnModificar2);
        driver.close();
       
	}
    	
    	
    	
}
