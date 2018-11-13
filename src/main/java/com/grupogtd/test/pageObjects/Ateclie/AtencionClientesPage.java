package com.grupogtd.test.pageObjects.Ateclie;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class AtencionClientesPage {
    @FindBy(how = How.ID, using = "hierarchy")
    public WebElement menuLink;

    @FindBy(how = How.LINK_TEXT, using = "Gestionar reclamos")
    public WebElement gestionarReclamos;

    @FindBy(how = How.LINK_TEXT, using = "Gestor de reclamos")
    public WebElement gestorDeReclamos;

    public void ingresoGestorReclamosAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
        do{
            try {
                WindowHandTool.windowhandle(driver, LOGGER, "SICRET");
                Actions action = new Actions(driver);
                menuLink.sendKeys(Keys.ENTER);
                WaitTool.waitToLoad(driver, LOGGER);
                action.moveToElement(gestionarReclamos).perform();
                WaitTool.waitForElement(driver, gestorDeReclamos);
                gestorDeReclamos.sendKeys(Keys.ENTER);
                WindowHandTool.windowhandle(driver, LOGGER, "Gestor Reclamos");
            } catch (Exception e) {
            }
        }while(!driver.getTitle().equalsIgnoreCase("Gestor Reclamos"));

    }
}
