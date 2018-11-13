package com.grupogtd.test.pageObjects.Ateclie;

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
public class ModificaSintomasReclamoPage {
    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'CORTE CABLE EXTERIOR')]/../td[1]/input")
    public WebElement chkCorteCableExterior;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'FALLA / CORTE INSTALACIÓN INTERIOR')]/../td[1]/input")
    public WebElement chkFallaCorteInstInterior;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'FALLA REPOSICION')]/../td[1]/input")
    public WebElement chkFallaReposicion;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'ONT CON ALARMAS')]/../td[1]/input")
    public WebElement chkOntConAlarmas;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'PROBLEMAS DE POTENCIA ONT / OLT')]/../td[1]/input")
    public WebElement chkProblemasDePotencia;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'SERVICIOS INTERMITENTES')]/../td[1]/input")
    public WebElement chkServiciosIntermitentes;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'SIN PRUEBAS-POSIBLE COSTO')]/../td[1]/input")
    public WebElement chkSinPruebasPosibleCosto;

    @FindBy(how = How.XPATH, using = "//*/td[contains(.,'SIN SERVICIOS')]/../td[1]/input")
    public WebElement chkSinServicios;

    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset[2]/table/tbody/tr/td/input")
    public WebElement btnAgregarAlReclamo;

    @FindBy(how = How.XPATH, using = "/html/body/form/div[3]/table/tbody/tr/td[1]/input")
    public WebElement btnGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id='tablaResultados']/tbody/tr/td[contains(.,'ONT CON ALARMAS')]")
    public WebElement ontConAlarmasAdded;


    public void modificarSintomasAction(WebDriver driver, Logger LOGGER, String sintoma) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Modifica Sintomas Reclamo");
        WaitTool.waitToLoad(driver, LOGGER);
        boolean tri = false;
        do {
            LOGGER.log(Level.INFO, "Seleccionando sintoma {0}", sintoma);
            driver.findElement(By.xpath("//*/td[contains(.,'"+sintoma+"')]/../td[1]/input")).sendKeys(Keys.SPACE);
            btnAgregarAlReclamo.sendKeys(Keys.ENTER);
            WaitTool.waitToLoad(driver, LOGGER);
            tri = driver.findElement(By.xpath("//*[@id='tablaResultados']/tbody/tr/td[contains(.,'"+sintoma+"')]")).isDisplayed();
        } while (!tri);
        btnGuardar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }
}
