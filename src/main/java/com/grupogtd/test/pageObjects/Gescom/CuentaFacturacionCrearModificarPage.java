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
public class CuentaFacturacionCrearModificarPage {

    @FindBy(how = How.ID, using =  "checkTodo")
    public WebElement chkTodos;

    @FindBy(how = How.XPATH, using =  "//input[@value='Modificar']")
    public WebElement btnModificar;

    @FindBy(how = How.XPATH, using =  "//*[@id='nroCtaCtePAC']")
    public WebElement nCtaCorrientePAC;

    @FindBy(how = How.XPATH, using =  "//*[@id='scrolltable']/fieldset[2]/table[2]/tbody/tr[2]/td/input[@value='MODIFICAR']")
    public WebElement btnModificar2;

    public void CtaFactCrearModificarAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Cuenta facturacion Crear Modificar");
        String crearSolicitudWindow = driver.getWindowHandle();
        do{
            chkTodos.sendKeys(Keys.SPACE);
        }while(!chkTodos.isSelected());
        btnModificar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(2000);
        boolean asd = false;
        WindowHandTool.windowhandleByElement(driver, LOGGER, btnModificar2);
        driver.close();
        driver.switchTo().window(crearSolicitudWindow);
        WaitTool.waitForAlert(driver, LOGGER);
    }
}
