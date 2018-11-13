package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class HomePage {
    @FindBy(how = How.LINK_TEXT, using = "Ingreso Datos")
    public WebElement lnkIngresoDatos;

    @FindBy(how = How.LINK_TEXT, using = "Consultas")
    public WebElement lnkConsultas;

    @FindBy(how = How.LINK_TEXT, using = "Sistema Gestión Comercial")
    public WebElement lnkSistemaGestionComercial;

    @FindBy(how = How.LINK_TEXT, using = "Sistema Atención Clientes")
    public WebElement lnkSistemaAteClie;

    @FindBy(how = How.LINK_TEXT, using = "Sistema Instalaciones")
    public WebElement lnkSistemaInstalaciones;

    @FindBy(how = How.LINK_TEXT, using = "Perfil de Clientes")
    public WebElement lnkPerfilClientes;

    public void ingresoGescomAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, lnkIngresoDatos);
        lnkIngresoDatos.sendKeys(Keys.ENTER);
        lnkSistemaGestionComercial.sendKeys(Keys.ENTER);
        WindowHandTool.windowhandle(driver, LOGGER, "SICRET");
    }

    public void ingresoInstalacionesAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, lnkIngresoDatos);
        lnkIngresoDatos.sendKeys(Keys.ENTER);
        lnkSistemaInstalaciones.sendKeys(Keys.ENTER);
    }

    public void ingresoAteClieAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, lnkIngresoDatos);
        lnkIngresoDatos.sendKeys(Keys.ENTER);
        lnkSistemaAteClie.sendKeys(Keys.ENTER);
    }

    public void ingresoPerfilClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "SICRET");
        WindowHandTool.windowhandleByElement(driver, LOGGER, lnkConsultas);
        lnkConsultas.sendKeys(Keys.ENTER);
        lnkPerfilClientes.sendKeys(Keys.ENTER);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WaitTool.waitToLoad(driver, LOGGER);
    }
}
