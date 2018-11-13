package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;



/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class AgregarNuevoProductoInstanciaPage {

  
	@FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[1]/table/tbody/tr/td[2]/input")
    public WebElement rdProd;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[1]/table/tbody/tr/td[4]/input")
    public WebElement rdContrato;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[1]/table/tbody/tr/td[6]/input")
    public WebElement rdEquipo;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[2]/table/tbody/tr/td[1]/input")
    public WebElement txtFiltro;

    @FindBy(how = How.XPATH, using =  "/html/body/form/fieldset[2]/table/tbody/tr/td[3]/input")
    public WebElement btnBuscar;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr[2]/td[1]/input")
    public WebElement rdProducto;
    
    @FindBy(how = How.XPATH, using =  "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'DECODIFICADOR IPTV (PQTE')]/../td[1]")
    public WebElement Producto;

    @FindBy(how = How.XPATH, using = "/html/body/form/table[1]/tbody/tr/td[1]/input")
    public WebElement btnAgregarProducto;

    @FindBy(how = How.XPATH, using = "//input[@value='Guardar Productos']")
    public WebElement btnGuardarProductos;

//    public void AgregarDecoIPTVAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
//        WindowHandTool.windowhandle(driver, LOGGER, "Agregar Nuevo Producto Instancia");
//        LOGGER.log(Level.INFO, driver.getTitle());
//        rdEquipo.sendKeys(Keys.SPACE);
//        WaitTool.waitToLoad(driver, LOGGER);
//        txtFiltro.sendKeys("DECO");
//        btnBuscar.sendKeys(Keys.ENTER);
//        WaitTool.waitToLoad(driver, LOGGER);
//        rdProducto.sendKeys(Keys.SPACE);
//        WaitTool.waitToLoad(driver, LOGGER);
//        btnAgregarProducto.sendKeys(Keys.ENTER);
//        WaitTool.waitToLoad(driver, LOGGER);
//        btnGuardarProductos.sendKeys(Keys.ENTER);
//        Thread.sleep(2000);
//    }

    public void AgregarProductoAction(WebDriver driver, Logger LOGGER, String prod, String tipo) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Agregar Nuevo Producto Instancia");
        LOGGER.log(Level.INFO, driver.getTitle());
        if(tipo.equalsIgnoreCase("Producto")){
            rdProd.sendKeys(Keys.SPACE);
            WaitTool.waitToLoad(driver, LOGGER);
        }if(tipo.equalsIgnoreCase("Contrato")){
            rdContrato.sendKeys(Keys.SPACE);
            WaitTool.waitToLoad(driver, LOGGER);
        }if(tipo.equalsIgnoreCase("Equipo")){
            rdEquipo.sendKeys(Keys.SPACE);
            WaitTool.waitToLoad(driver, LOGGER);
        }
        txtFiltro.sendKeys(prod);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdProducto.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnAgregarProducto.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardarProductos.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

	public void agregarequipoAction(WebDriver driver, Logger LOGGER, String equipoTV) throws InterruptedException {
		WindowHandTool.windowhandle(driver, LOGGER, "Agregar Nuevo Producto Instancia");
		LOGGER.log(Level.INFO, driver.getTitle());
		rdEquipo.click();
		WaitTool.waitToLoad(driver, LOGGER);
		Producto.sendKeys(equipoTV);
		Producto.click();
		WaitTool.waitToLoad(driver, LOGGER);
		btnAgregarProducto.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnAgregarProducto.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        //btnAgregarProducto.sendKeys(Keys.ENTER);
        //WaitTool.waitToLoad(driver, LOGGER);
        btnGuardarProductos.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
      }
	
	
    
    
}
