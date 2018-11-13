package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class IngresaCausaSolucionPage {
    @FindBy(how = How.ID, using = "idFliaReclamo")
    public WebElement cbbFamiliaCausa;

    @FindBy(how = How.ID, using = "botonBuscar")
    public WebElement btnBuscar;

    @FindBy(how = How.ID, using = "botonGuardar")
    public WebElement btnGuardar;

    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset/table/tbody/tr[2]/td[2]/fieldset/table/tbody/tr[2]/td[2]/label/input")
    public WebElement rdResponsableGtd;

    @FindBy(how = How.XPATH, using = "//*[@id=\"btnVolver\"]/table/tbody/tr/td/input")
    public WebElement btnVolver;


    public void ingresaCausaSolucionAction(WebDriver driver, Logger LOGGER, String familia, String solucion) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Ingresar Causa Solucion");
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(2000);
        rdResponsableGtd.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Ingresar Causa Solucion");
        new Select(cbbFamiliaCausa).selectByVisibleText(familia);
        WaitTool.waitToLoad(driver, LOGGER);
        btnBuscar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        PageFactory.initElements(driver, SolucionesFamiliaPage.class).seleccionaFamiliaSolucionAction(driver, LOGGER, solucion);
        WindowHandTool.windowhandle(driver, LOGGER, "Ingresar Causa Solucion");
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Ingresar Causa Solucion");
        WaitTool.waitToLoad(driver, LOGGER);
        btnVolver.sendKeys(Keys.ENTER);
    }
}
