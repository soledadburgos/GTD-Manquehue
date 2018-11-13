package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class DatosDeLaVentaPage {
    @FindBy(how = How.XPATH, using =  "//*[@id='tablaBusqueda']/tbody/tr[5]/td[1]/input")
    public WebElement btnGuardar;

    @FindBy(how = How.XPATH, using =  "//*[@id='tablaBusqueda']/tbody/tr[1]/td[2]/select")
    public WebElement cbbVendedor;

    @FindBy(how = How.ID, using =  "perfil_area")
    public WebElement cbbAreaVenta;

    @FindBy(how = How.ID, using =  "perfil_subarea")
    public WebElement cbbSubAreaVenta;

    @FindBy(how = How.NAME, using =  "comentario")
    public WebElement txtComentario;

    public void datosDeLaVentaAction(WebDriver driver, Logger LOGGER, String comment) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Datos de la venta");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbAreaVenta).selectByVisibleText("FIDELIZACION");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbSubAreaVenta).selectByVisibleText("FIDELIZACION");
        WaitTool.waitToLoad(driver, LOGGER);
        new Select(cbbVendedor).selectByVisibleText("FIDELIZACION FIDELIZACION FIDELIZACION FIDELIZACION");
        WaitTool.waitToLoad(driver, LOGGER);
        txtComentario.sendKeys(comment);
        btnGuardar.sendKeys(Keys.ENTER);
    }
}
