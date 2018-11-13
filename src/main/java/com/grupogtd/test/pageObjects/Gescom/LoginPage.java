package com.grupogtd.test.pageObjects.Gescom;

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
public class LoginPage {
    @FindBy(how = How.NAME, using = "login")
    public WebElement txtUser;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "dominioSeleccionado")
    public WebElement cbbDom;

    @FindBy(how = How.ID, using = "idBtnIngresar")
    public WebElement btnIngresar;

    @FindBy(how = How.CSS, using = "div.ajs-message.ajs-error")
    public WebElement errorMsj;

    public void loginSinDomAction(String user, String password, Logger LOGGER, WebDriver driver) throws InterruptedException{
        txtUser.sendKeys(user);
        txtPassword.sendKeys(password);
        btnIngresar.sendKeys(Keys.ENTER);
        try {
            LOGGER.log(Level.SEVERE, errorMsj.getText());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Login OK");
        }
    }

    public void loginCondomAction(String user, String password, String dom, Logger LOGGER, WebDriver driver) throws InterruptedException{
        txtUser.sendKeys(user);
        txtPassword.sendKeys(password);
        new Select(cbbDom).selectByVisibleText(dom);
        btnIngresar.sendKeys(Keys.ENTER);
        try {
            LOGGER.log(Level.SEVERE, errorMsj.getText());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Login OK");
        }
    }
}
