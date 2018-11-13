package com.grupogtd.test.pageObjects.AdminEquipos;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 01-12-2017.
 */
public class AdministradorEquiposPage {
    @FindBy(how = How.XPATH, using = "//*[@id='tableEquiposAprovisionados']/tbody/tr[2]/td[1]/input[@name='operarEquipoAprovisionado']")
    public WebElement rdEquipoAprov;

    @FindBy(how = How.XPATH, using = "//*[@id='tableEquiposCliente']/tbody/tr[2]/td[1]/input[@name='operarEquipoAprovisionado']")
    public WebElement rdEquipoMovil;

    @FindBy(how = How.XPATH, using =  "//*[@id='contenedorOperacion']/table/tbody/tr[1]/td[2]/select")
    public WebElement cbbEquipo;

    @FindBy(how = How.ID, using = "idBotonEjecutar")
    public WebElement btnEjecutar;

    @FindBy(how = How.NAME, using =  "idSerieEquipo")
    public WebElement serieEquipoTxt;

    @FindBy(how = How.NAME, using =  "idImsi")
    public WebElement imsiTxt;

    @FindBy(how = How.NAME, using =  "idModelo")
    public WebElement modeloTxt;

    @FindBy(how = How.ID, using = "btnGuardarDetalle")
    public WebElement btnGuardarDetalle;

    @FindBy(how = How.XPATH, using = "//*/iframe")
    public WebElement frame;

    public void buscarEquipoAction(WebDriver driver, Logger LOGGER, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Interfaz Inicial");
        WaitTool.waitToLoad(driver, LOGGER);
        rdEquipoAprov.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbEquipo).selectByVisibleText("AGREGAR DETALLE EQUIPO");
        WaitTool.waitToLoad(driver, LOGGER);
        WindowHandTool.windowhandle(driver, LOGGER, "Interfaz Inicial");
        WaitTool.waitToLoad(driver, LOGGER);
        btnEjecutar.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
    }

    public void agregarDetalleEquipoAction(WebDriver driver, Logger LOGGER, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Interfaz Inicial");
        WaitTool.waitToLoad(driver, LOGGER);
        driver.switchTo().frame(frame);
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(2000);
        rdEquipoMovil.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        serieEquipoTxt.sendKeys("8956073100000620307");
        WaitTool.waitToLoad(driver, LOGGER);
        imsiTxt.sendKeys("12232");
        WaitTool.waitToLoad(driver, LOGGER);
        modeloTxt.sendKeys("SUSIM-4G");
        WindowHandTool.windowhandle(driver, LOGGER, "Interfaz Inicial");
        WaitTool.waitToLoad(driver, LOGGER);
        btnGuardarDetalle.sendKeys(Keys.ENTER);
    }
}
