package com.grupogtd.test.pageObjects.PerfilCliente;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 05-01-2018.
 * Modified by soledad.burgos on 24-09-2018
 */
public class PerfilClientePage {

	@FindBy(how = How.ID, using =  "rut")
    public WebElement txtRut;
    
    @FindBy(how = How.ID, using = "instancia")
    public WebElement txtinstancia;
    
    @FindBy(how = How.ID, using = "idTxtCotizacion")
    public WebElement txtcotizacion;
    
    @FindBy(how = How.ID, using = "ficha")
    public WebElement txtficha;
    
    @FindBy(how = How.ID, using = "condominio")
    public WebElement txtcondominio;

    @FindBy(how = How.ID, using =  "btnBuscar")
    public WebElement btnBuscar;

    @FindBy(how = How.ID, using = "limpiar")
    public WebElement btnlimpiar;
    
    @FindBy(how = How.ID, using = "cUrbano")
    public WebElement centro;
    
    @FindBy(how = How.ID, using = "comuna")
    public WebElement comun;
    
    @FindBy(how = How.ID, using = "calle")
    public WebElement call;
    
    @FindBy(how = How.ID, using = "sufijo")
    public WebElement sufij;
    
    @FindBy(how = How.ID, using = "numero")
    public WebElement numer;
    
    @FindBy(how = How.ID, using = "depto")
    public WebElement dept;
    
    @FindBy(how = How.ID, using = "piso")
    public WebElement pis;
    
    @FindBy(how = How.XPATH, using = "//*[@id='contentDatosClientes']")
    public WebElement mensaje;
    
    public void buscaCliente(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtRut);
        WaitTool.waitToLoad(driver, LOGGER);
        txtRut.sendKeys(rut);
        btnBuscar.click();
        WaitTool.waitToLoad(driver, LOGGER); 
        Thread.sleep(2000);
    }
    
    
    public void buscaCliente2(WebDriver driver, Logger LOGGER, String rut, String instancias, String idcotizacion) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtRut);
        WaitTool.waitToLoad(driver, LOGGER);
        txtRut.sendKeys(rut);
        txtinstancia.sendKeys(instancias);
        txtcotizacion.sendKeys(idcotizacion);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();    
    }     
    
    public void buscaCliente3(WebDriver driver, Logger LOGGER, String rut, String instancias) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtRut);
        WaitTool.waitToLoad(driver, LOGGER);
        txtRut.sendKeys(rut);
        txtinstancia.sendKeys(instancias);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();  
    }
    
    
    public void buscaCliente4(WebDriver driver, Logger LOGGER, String rut, String idcotizacion) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtRut);
        WaitTool.waitToLoad(driver, LOGGER);
        txtRut.sendKeys(rut);
        txtcotizacion.sendKeys(idcotizacion);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
    public void buscaCliente5(WebDriver driver, Logger LOGGER, String rut) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtRut);
        WaitTool.waitToLoad(driver, LOGGER);
        txtRut.sendKeys(rut);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
    public void validarlabusqueda(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WaitTool.waitToLoad(driver, LOGGER);
        String est= "--";
        est = mensaje.getText();
        Asserts.check(!("El Cliente no ha sido encontrado, favor volver a buscar".equals(est)),"mensaje correcto");
    }
    
    public void buscaCliente6(WebDriver driver, Logger LOGGER, String instancias) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtinstancia);
        WaitTool.waitToLoad(driver, LOGGER);
        txtinstancia.sendKeys(instancias);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
    public void buscaCliente7(WebDriver driver, Logger LOGGER, String idcotizacion) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtcotizacion);
        WaitTool.waitToLoad(driver, LOGGER);
        txtcotizacion.sendKeys(idcotizacion);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
    public void buscaficha(WebDriver driver, Logger LOGGER, String fichas) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtficha);
        WaitTool.waitToLoad(driver, LOGGER);
        txtficha.sendKeys(fichas);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
    public void buscacondominio(WebDriver driver, Logger LOGGER, String condominios) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtcondominio);
        WaitTool.waitToLoad(driver, LOGGER);
        txtcondominio.sendKeys(condominios);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER);
        btnlimpiar.click();   
    }
    
     public void buscadireccion(WebDriver driver, Logger LOGGER, String centrourbano, String comunas, String calles, String sufijos, String numeros, String deptos, String pisos) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, centro);
        WaitTool.waitToLoad(driver, LOGGER);
        centro.sendKeys(centrourbano); 
        comun.sendKeys(comunas);
        call.sendKeys(calles);
        sufij.sendKeys(sufijos);
        numer.sendKeys(numeros);
        dept.sendKeys(deptos);
        pis.sendKeys(pisos);
        btnBuscar.click();
        Thread.sleep(2000);
        WaitTool.waitToLoad(driver, LOGGER); 
    }
     
}
