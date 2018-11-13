package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.pageObjects.Gescom.DetalleActividadesPage;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class TodasLasActividades {

    @FindBy(how = How.ID, using = "0")
    public WebElement rdActividad;

    @FindBy(how = How.XPATH, using = "//*[@id='tdBotoneraLimpiar']/input[@type = 'submit' and @value='MODIFICAR']")
    public WebElement btnModificar;


    public void cerrarActividadReclamoAction(WebDriver driver, Logger LOGGER, String path) throws InterruptedException{
        WindowHandTool.windowhandle(driver, LOGGER, "Todas las Actividades");
        WaitTool.waitToLoad(driver, LOGGER);
        LOGGER.log(Level.INFO, "Cerrando actividad");
        rdActividad.sendKeys(Keys.SPACE);
        WaitTool.waitToLoad(driver, LOGGER);
        Thread.sleep(4000);
        btnModificar.sendKeys(Keys.ENTER);
        PageFactory.initElements(driver, DetalleActividadesPage.class).cerrarActividadConUsuarioAction(driver, LOGGER, path, "CERRADA", "OK", "");
        WindowHandTool.windowhandle(driver, LOGGER, "Todas las Actividades");
        driver.close();
    }
}
