package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.utility.WaitTool;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 28-12-2017.
 */
public class RecrearContrasenaPage {
    @FindBy(how = How.XPATH, using = "/html/body/form/fieldset/b")
    public WebElement mensaje;

    public void recreaContrasena(WebDriver driver, Logger LOGGER) throws InterruptedException{
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WaitTool.waitToLoad(driver, LOGGER);
        boolean foundElement;
        do{
            try{
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/input[@value='Recrear']")).sendKeys(Keys.SPACE);
                foundElement = true;
            }catch(NoSuchElementException e){
                foundElement = false;
                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                }
                WaitTool.waitToLoad(driver, LOGGER);
            }
        }while(!foundElement);

        WaitTool.waitToLoad(driver, LOGGER);
        String est= "--";
        est = mensaje.getText();
        Asserts.check("La contraseña ha sido recreada.".equals(est),"mensaje correcto");

        driver.close();
    }
}
