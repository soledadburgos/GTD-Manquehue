package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class CuentaServicioPage {
    @FindBy(how = How.ID, using =  "Buscar")
    public WebElement btnBuscar;

    //Selecciona radiobutton de ctaServicio a través del secuencial de cuenta
//    @FindBy(how = How.XPATH, using =  "//*/td[contains(.,'3264638')]/../td[1]/input")
//    public WebElement rdCtaServicio;

//    @FindBy(how = How.XPATH, using =  "//*/td[contains(.,'3119099')]/../td[1]/input")
//    public WebElement rdCtaServicioCU;

    @FindBy(how = How.NAME, using = "Seleccionar")
    public WebElement btnSeleccionar;

    public WebElement rdCuenta(WebDriver driver, String cta){
        return driver.findElement(By.xpath("//*/td[contains(.,'"+cta+"')]/../td[1]/input"));
    }

    public void selecionarCuentaServicioAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Cuenta Servicio");
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WaitTool.waitForElement(driver, rdCuenta(driver,Datos.ctaServicioFTTH));
        do{
            rdCuenta(driver,Datos.ctaServicioFTTH).sendKeys(Keys.SPACE);
        }while (!rdCuenta(driver,Datos.ctaServicioFTTH).isSelected());
        btnSeleccionar.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO,"Cuenta Servicio OK");
    }

    public void selecionarCuentaServicioCUAction(WebDriver driver, Logger LOGGER, String ctaServicio) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Cuenta Servicio");
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WaitTool.waitForElement(driver, rdCuenta(driver,ctaServicio));
        do{
            rdCuenta(driver, ctaServicio).sendKeys(Keys.SPACE);
        }while (!rdCuenta(driver,ctaServicio).isSelected());
        btnSeleccionar.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO,"Cuenta Servicio OK");
    }

    public void selecionarCuentaServicioMovilAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Cuenta Servicio");
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        WaitTool.waitForElement(driver, rdCuenta(driver,Datos.ctaServicioMovil));
        do{
            rdCuenta(driver, Datos.ctaServicioMovil).sendKeys(Keys.SPACE);
        }while (!rdCuenta(driver,Datos.ctaServicioMovil).isSelected());
        btnSeleccionar.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO,"Cuenta Servicio OK");
    }
}
