package com.grupogtd.test.pageObjects.Ateclie;

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
public class BitacoraReclamoPage {
    @FindBy(how = How.ID, using = "comentario")
    public WebElement txtComentario;

    @FindBy(how = How.ID, using = "TipoComentario")
    public WebElement cbbTipoComentario;

    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset/fieldset/fieldset[1]/table/tbody/tr[3]/td[3]/input")
    public WebElement btnAgregar;

    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset/table/tbody/tr/td[1]/input")
    public WebElement btnGuardar;

    @FindBy(how = How.ID, using = "indiceQuitarComentario")
    public WebElement chkComentario;


    public void ingresaBitacoraAction(WebDriver driver, Logger LOGGER, String comentario) throws InterruptedException{
        WindowHandTool.windowhandleByElement(driver, LOGGER, txtComentario);
        LOGGER.log(Level.INFO, "Ingresando comentario a bitacora");
        txtComentario.sendKeys(comentario);
        new Select(cbbTipoComentario).selectByVisibleText("NOTA CLIENTE");
        btnAgregar.sendKeys(Keys.ENTER);
        chkComentario.sendKeys(Keys.SPACE);
        btnGuardar.sendKeys(Keys.ENTER);
        LOGGER.log(Level.INFO, "Comentario agregado correctamente");
    }
}
