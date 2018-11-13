package com.grupogtd.test.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

import com.google.common.base.Function;


/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class WaitTool {
	private WebDriver driver;
	
	public WaitTool(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
    public static void waitToLoad(WebDriver driver, Logger LOGGER) throws InterruptedException {
        JavascriptExecutor js = null;
        String jsStatus = null;
        boolean jqStatus = false;
        js = (JavascriptExecutor) driver;
        do {
            try{
                Thread.sleep(500);
                jsStatus = (String)js.executeScript("return document.readyState");
                LOGGER.log(Level.INFO, "Página cargada: {0}", jsStatus);
            }catch(Exception e){
                LOGGER.log(Level.SEVERE, "waitToLoad document.readyState falló");
                break;
            }
        } while (!jsStatus.equalsIgnoreCase("complete"));
        do {
            try{
                if(js.executeScript("return window.jQuery")==null){
                    jqStatus = true;
                }else{
                    Thread.sleep(500);
                    jqStatus = (Boolean)js.executeScript("return jQuery.active == 0");
                    LOGGER.log(Level.INFO, "no hay jQuery en ejecución: {0}", jqStatus);
                }
            }catch(Exception e){
                LOGGER.log(Level.SEVERE, "waitToLoad jQuery.active == 0 falló");
                break;
            }
        } while (!jqStatus);
    }

    public static void waitForAlert(WebDriver driver, Logger LOGGER){
        boolean tri = false;
        do {
            try {
                driver.switchTo().alert().getText();
                tri = true;
            } catch (Exception e) {
            }
        } while (!tri);
        if(tri){
            LOGGER.log(Level.INFO,driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
    }

    public static void waitForAlertDismiss(WebDriver driver, Logger LOGGER){
        boolean tri = false;
        do {
            try {
                driver.switchTo().alert().getText();
                tri = true;
            } catch (Exception e) {
            }
        } while (!tri);
        if(tri){
            LOGGER.log(Level.INFO,driver.switchTo().alert().getText());
            driver.switchTo().alert().dismiss();
            LOGGER.info("cancela agregar tv con retorno");
        }
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        boolean asd = false;
        do {
            try {
                element.getLocation();
                asd = true;
            } catch (Exception e) {
            }
        } while (!asd);
    }


    public WebElement searchElement(final By locator) {
		WebElement myElement = null;
		try {
			this.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Wait<WebDriver> gWait = new FluentWait<WebDriver>(this.getDriver())
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofMillis(150))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);
			myElement = gWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver drivers) {
					System.out.println("Buscando elemento");
					WebElement ele = drivers.findElement(locator);
					return ele;
				}
			});
		}catch(Exception e) {
			System.out.println("FluentWait method fail");
			e.printStackTrace();
		}
		return myElement;
	}

 
  //SENDKEYS PERSONALIZADO Agregar modificar productos
    
    public void buscarequiponinguno(By ninguno) {
    	WebElement ningunequipo = this.searchElement(ninguno);
    	ningunequipo.click();
    }
    
    public void buscarequiposdesconectados(By equipos) {
    	WebElement miEquipos = this.searchElement(equipos);
    	miEquipos.click();

    
    }
    
    public void buscarequipospendientes(By estad) {
    	WebElement miEquipo = this.searchElement(estad);
    	miEquipo.click();
    
    }
    
    
  //SENDKEYS PERSONALIZADO Traslado
    
    public void buscarctafacturacion(By facturacion) {
    	WebElement mifacturacion = this.searchElement(facturacion);
    	mifacturacion.click();
    }  
}