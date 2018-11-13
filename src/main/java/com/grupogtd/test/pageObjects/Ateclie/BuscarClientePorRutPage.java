package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class BuscarClientePorRutPage {
    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset/table[1]/tbody/tr[1]/td[2]/input[1]")
    public WebElement txtRut;

    //Debe ser un servicio FTTH
    @FindBy(how = How.ID, using = "1")
    public WebElement rdServicio;

    @FindBy(how = How.ID, using = "fliaReclamo")
    public WebElement cbbFamiliaReclamo;

    @FindBy(how = How.ID, using = "rutCliente")
    public WebElement txtRutCliente;

    @FindBy(how = How.ID, using = "botonBuscar")
    public WebElement btnBuscar;

    @FindBy(how = How.ID, using = "botonSeleccionar")
    public WebElement btnSeleccionar;

    public void seleccionarServicioAction(WebDriver driver, Logger LOGGER, String rut, String familia) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Buscar Cliente por RUT");
        txtRut.clear();
        txtRut.sendKeys(rut);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdServicio.sendKeys(Keys.SPACE);
        if(familia.equalsIgnoreCase("TECNICO")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("TECNICO");
        }if(familia.equalsIgnoreCase("COMERCIAL")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("COMERCIAL");
        }if(familia.equalsIgnoreCase("FACTURACION")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("FACTURACION");
        }if(familia.equalsIgnoreCase("FIDELIZACION")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("FIDELIZACION");
        }if(familia.equalsIgnoreCase("FIDELIZACION")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("FIDELIZACION");
        }if(familia.equalsIgnoreCase("PREGUNTA")){
            new Select(cbbFamiliaReclamo).selectByVisibleText("PREGUNTA");
        }
        btnSeleccionar.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO, "Seleccionando servicio");
    }
}
