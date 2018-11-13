package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class SolucionesFamiliaPage {
    @FindBy(how = How.XPATH, using = "//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'CAMBIO DE ONT CON PROBLEMA')]/../td[1]/input")
    public WebElement chkFamiliaCausa;

    @FindBy(how = How.ID, using = "botonSeleccionar")
    public WebElement btnSeleccionar;

    @FindBy(how = How.ID, using = "botonCancelar")
    public WebElement btnCancelar;


    public void seleccionaFamiliaSolucionAction(WebDriver driver, Logger LOGGER, String solucion) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Soluciones Familia");
        driver.findElement(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'"+solucion+"')]/../td[1]/input")).sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSeleccionar.sendKeys(Keys.ENTER);
    }
}
