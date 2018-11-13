package com.grupogtd.test.pageObjects.Gescom;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by soledad.burgos on 04-10-2018.
 */

public class DesactivarequiposPage {
	
	private WebDriver driverdesactivarequipospage;
	
	
	
	private WaitTool waitTool;
	
	
		
	@FindBy(how = How.XPATH, using =  "//*[@id='tablaDestacada']/tbody/tr/td[contains(.,'TELEVISION FTTH')]/../td[2]/a")
    public WebElement instancia;
      	
	//@FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'PENDIENTE')]/../td[1]")
    //public WebElement estado;		
	
	//@FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'PENDIENTE')]/../td[1]")
    public WebElement estad;
	
		
	@FindBy(how = How.NAME, using =  "accionProductoSelec")
    public WebElement desconectar;
	
	@FindBy(how = How.NAME, using =  "estadoProductoSelec")
    public WebElement anular;

	@FindBy(how = How.ID, using = "botonFinalizarProd")
    public WebElement btnFinalizar;
	
	@FindBy(how = How.ID, using = "botonAgregarProducto")
	public WebElement btnagregar;

	
	
	
	public void desconectarProductoAction2(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		WaitTool.waitToLoad(driver, LOGGER);
		instancia.sendKeys(Keys.ENTER);        
		//WaitTool.waitToLoad(driver, LOGGER);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//equipo.click();
//		
	}	
	
	public void desconectarProductoAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		WaitTool.waitToLoad(driver, LOGGER);
		instancia.sendKeys(Keys.ENTER); 
		waitTool = new WaitTool(driver);
		waitTool.buscarequiponinguno(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'EQUIPO')]/../td[1]"));
		Thread.sleep(5000);
	}
		
	public void desconectarAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        
		try{
            //WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Desconectando equipo");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(desconectar).selectByVisibleText("DESCONECTAR");
        	WaitTool.waitToLoad(driver, LOGGER);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al desconectar producto", e.getMessage());
        }
    }
	
	
	public void finalizarProductos(WebDriver driver, Logger LOGGER) throws InterruptedException{
		try{
			WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
			btnFinalizar.sendKeys(Keys.ENTER);
			WaitTool.waitForAlert(driver, LOGGER);
			Thread.sleep(2000);
    
		}catch(Exception e){
			LOGGER.log(Level.SEVERE, "Los equipos actuales no son compatibles con la tecnología de TV, debe desconectar y agregar nuevos equipos", e.getMessage());
		}

	}
	public void seleccionarinstanciaAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		Object equip = null;
		LOGGER.log(Level.INFO, "Agregar equipo seleccionando de nuevo la instancia", equip);
		instancia.sendKeys(Keys.ENTER); 
		WaitTool.waitToLoad(driver, LOGGER);         
		btnagregar.click(); 
		WaitTool.waitToLoad(driver, LOGGER); 
		}

	public void finalizarpartedosProductos(WebDriver driver, Logger LOGGER) throws InterruptedException{
			WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
			btnFinalizar.sendKeys(Keys.ENTER);
			WaitTool.waitForAlert(driver, LOGGER);
			driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
			WaitTool.waitForAlert(driver, LOGGER);	
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			
	}
	
	public void ActivarProductoAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		WaitTool.waitToLoad(driver, LOGGER);
		instancia.sendKeys(Keys.ENTER); 
		waitTool = new WaitTool(driver);
		waitTool.buscarequiposdesconectados(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'DESCONECTAR')]/../td[1]"));
		Thread.sleep(5000);
	}

	public void ningunaAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        
		try{
            //WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Activar equipo");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(desconectar).selectByVisibleText("NINGUNA");
        	WaitTool.waitToLoad(driver, LOGGER);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al desconectar producto", e.getMessage());
        }
  	}
	
	
	public void seleccionardecoAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		waitTool = new WaitTool(driver);
		waitTool.buscarequipospendientes(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'PENDIENTE')]/../td[1]"));
		Thread.sleep(5000);
	}
	
	public void seleccionardecodosAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
		WaitTool.waitToLoad(driver, LOGGER);
		instancia.sendKeys(Keys.ENTER); 
		waitTool = new WaitTool(driver);
		waitTool.buscarequipospendientes(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'PENDIENTE')]/../td[1]"));
		Thread.sleep(5000);
	}
	
	
	public void anularAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        
		try{
            //WindowHandTool.windowhandle(driver, LOGGER, "Agregar productos a instancia");
            LOGGER.log(Level.INFO, "Anular equipo");
            WaitTool.waitToLoad(driver, LOGGER);
            new Select(anular).selectByVisibleText("ANULADA");
        	WaitTool.waitToLoad(driver, LOGGER);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error al desconectar producto", e.getMessage());
        }
  	}
	
	
}
	