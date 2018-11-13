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
public class ValidacionesDeSolicitudPage {
    @FindBy(how = How.XPATH, using =  "//*[@id='pasoTipoVenta']/table/tbody/tr[3]/td[2]/input[@value='PRESENCIAL']")
    public WebElement rdVentaPresencial;

    @FindBy(how = How.XPATH, using =  "//*[@id='pasoTipoBaja']/table/tbody/tr[3]/td[2]/input[@value='PRESENCIAL']")
    public WebElement rdBajaPresencial;

    @FindBy(how = How.XPATH, using =  "//*[@id='formularioGeneral']/div[3]/div/button[2]")
    public WebElement btnSiguiente;

    @FindBy(how = How.XPATH, using =  "//*[@id='formularioGeneral']/div[3]/div/button[contains(.,'Finalizar')]")
    public WebElement btnFinalizar;

    @FindBy(how = How.XPATH, using =  "//*[@id='formularioGeneral']/div[3]/div/button[contains(.,'Siguiente')]")
    public WebElement btnSiguiente2;

    public void ventaPresencialAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Validaciones de Solicitud");
        Thread.sleep(2000);
        rdVentaPresencial.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }

    public void ventaPresencialAdendumAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Validaciones de Solicitud");
        Thread.sleep(2000);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdVentaPresencial.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSiguiente2.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }

    public void ventaPresencialCUAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Validaciones de Solicitud");
        Thread.sleep(2000);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdVentaPresencial.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }

    public void ventaPresencialFTTHAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Validaciones de Solicitud");
        Thread.sleep(2000);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        rdVentaPresencial.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
    }


    public void bajaPresencialAction(WebDriver driver, Logger LOGGER, String path, String id) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Validaciones de Solicitud");
        rdBajaPresencial.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnSiguiente.sendKeys(Keys.ENTER);
        WaitTool.waitToLoad(driver, LOGGER);
        btnFinalizar.sendKeys(Keys.ENTER);
        WaitTool.waitForAlert(driver, LOGGER);
        Thread.sleep(1000);
    }
}
