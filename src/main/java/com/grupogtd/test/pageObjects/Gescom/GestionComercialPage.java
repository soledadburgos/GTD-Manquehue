package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;
import org.openqa.selenium.By;

/**
 * Created by ramiro.urbina on 29-11-2017.
 * Modified by soledad.burgos on 24-09-2018.
 */
public class GestionComercialPage {
    
	@FindBy(how = How.ID, using = "hierarchy")
    public WebElement lnkMenu;

    @FindBy(how = How.LINK_TEXT, using = "Ventas y Mantención de Clientes")
    public WebElement ventasYMantencionDeClientes;

    @FindBy(how = How.LINK_TEXT, using = "Gestor de solicitud")
    public WebElement gestorDeSolicitud;

    @FindBy(how = How.LINK_TEXT, using = "Resumen de cliente")
    public WebElement resumenCliente;
    
    @FindBy(how = How.LINK_TEXT, using = "Consultas")
    public WebElement Consulta;
    
    @FindBy(how = How.LINK_TEXT, using = "Consulta Perfil Cliente")
    public WebElement ConsultaPerfilCliente;
    

    public void ingresoResumenClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        do{
            try {
                WindowHandTool.windowhandle(driver, LOGGER, "SICRET");
                Actions action = new Actions(driver);
                lnkMenu.sendKeys(Keys.ENTER);
                WaitTool.waitToLoad(driver, LOGGER);
                action.moveToElement(ventasYMantencionDeClientes).perform();
                WaitTool.waitForElement(driver, resumenCliente);
                resumenCliente.sendKeys(Keys.ENTER);
                WindowHandTool.windowhandle(driver, LOGGER, "Resumen Cliente");
            } catch (Exception e) {
            }
        }while(!driver.getTitle().equalsIgnoreCase("Resumen Cliente"));

    }

    public void ingresoGestorSolicitud(WebDriver driver, Logger LOGGER) throws InterruptedException{
        do{
            try {
                WindowHandTool.windowhandle(driver, LOGGER, "Resumen Cliente");
                Actions action = new Actions(driver);
                lnkMenu.sendKeys(Keys.ENTER);
                action.moveToElement(ventasYMantencionDeClientes).perform();
                WaitTool.waitForElement(driver, resumenCliente);
                gestorDeSolicitud.sendKeys(Keys.ENTER);
                WindowHandTool.windowhandle(driver, LOGGER, "Gestor de Solicitud");
            } catch (Exception e) {
            }
        }while(!driver.getTitle().equalsIgnoreCase("Gestor de Solicitud"));
    }
    
    public void ingresoConsultaPerfilClienteAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "SICRET");
        Actions action = new Actions(driver);
        lnkMenu.sendKeys(Keys.ENTER);
        action.moveToElement(Consulta).perform();
        WaitTool.waitForElement(driver, ConsultaPerfilCliente);
        ConsultaPerfilCliente.sendKeys(Keys.ENTER);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WaitTool.waitToLoad(driver, LOGGER);
    }
}
