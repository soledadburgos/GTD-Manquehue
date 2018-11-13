package com.grupogtd.test.utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class WindowHandTool {
    /**
     * Toma el control y maximiza la última ventana
     * @param driver
     * @param LOGGER
     * @throws InterruptedException
     */
    public static void windowhandle(WebDriver driver, Logger LOGGER) throws InterruptedException {
        LOGGER.log(Level.INFO, "Tomando control de nueva ventana");
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            LOGGER.log(Level.INFO, driver.getTitle());
        }
        driver.manage().window().maximize();
        WaitTool.waitToLoad(driver, LOGGER);
    }
    /**
     * Toma el control y maximiza la ventana que tenga el titulo indicado
     * @param driver
     * @param LOGGER
     * @param title
     * @throws InterruptedException
     */
    public static void windowhandle(WebDriver driver, Logger LOGGER, String title) throws InterruptedException {
        Thread.sleep(1000);
        LOGGER.log(Level.INFO, "Tomando control de ventana {0}", title);
        boolean tri = false;
        int count = 0;
        boolean intentoHandlerWindow = true;
        do {
            for (String winHandle : driver.getWindowHandles()) {
                Thread.sleep(3000);
                do{
                    try{
                        driver.switchTo().window(winHandle);
                        intentoHandlerWindow = true;
                    }catch(TimeoutException e){
                        intentoHandlerWindow = false;
                    }
                }while(!intentoHandlerWindow);

                if (driver.getTitle().equalsIgnoreCase(title)) {
                    LOGGER.log(Level.INFO, "{0} encontrada", title);
                    break;
                }
            }
            if (!driver.getTitle().equalsIgnoreCase(title)) {
                LOGGER.log(Level.INFO, "Window not found, trying again...");
                count++;
            }
            if(driver.getTitle().equalsIgnoreCase(title) || count > 3){
                tri = true;
            }
        } while (!tri);
        driver.manage().window().maximize();
        WaitTool.waitToLoad(driver, LOGGER);
    }
    /**
     * workarround para la ventana de STSSuper (que no siempre carga, de forma aleatoria queda en blanco)
     * @param driver
     * @param LOGGER
     * @return
     */
    public static boolean windowhandleStsSuper(WebDriver driver, Logger LOGGER) {
        boolean handleok = false;
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
                LOGGER.log(Level.INFO, driver.getTitle());
                if (driver.getTitle().equals("Selecciona Tipo Servicio")) {
                    driver.manage().window().maximize();
                    handleok = true;
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return handleok;
    }
    /**
     * workarround para la ventana de STSSuper (que no siempre carga, de forma aleatoria queda en blanco)
     * @param driver
     * @param LOGGER
     */
    public static void bugWindowRepair(WebDriver driver, Logger LOGGER) {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (driver.getTitle().equals("")) {
                LOGGER.log(Level.INFO, "Cerrando ventana bug");
                driver.close();
            }
        }
    }
    /**
     * Toma el control y maximiza la ventana que contenga el WebElement indicado
     * @param driver
     * @param LOGGER
     * @param element
     * @throws InterruptedException
     */
    public static void windowhandleByElement(WebDriver driver, Logger LOGGER, WebElement element) throws InterruptedException {
        LOGGER.log(Level.INFO, "Tomando control de ventana ");
        boolean aux = false;
        do {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
                try {
                    if (element.isDisplayed()) {
                        LOGGER.log(Level.INFO, "Retornando {0}",driver.getTitle());
                        aux = true;
                        break;
                    }
                } catch (NoSuchElementException e) {
                    LOGGER.log(Level.SEVERE, "Window not found, trying again...");
                }
            }
            if (!aux) {
                LOGGER.log(Level.SEVERE, "Window not found, trying again...");
            }
        } while (!aux);
        driver.manage().window().maximize();
        WaitTool.waitToLoad(driver, LOGGER);
    }
    /**
     * Cierra la ventana indicada
     * @param driver
     * @param LOGGER
     * @param title
     * @throws InterruptedException
     */
    public static void closeWindow(WebDriver driver, Logger LOGGER, String title) throws InterruptedException {
        Thread.sleep(2000);
        LOGGER.log(Level.INFO, "Buscando y cerrando ventana {0}",title);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (driver.getTitle().equalsIgnoreCase(title)) {
                LOGGER.log(Level.INFO, "cerrando {0}",title);
                driver.close();
                break;
            }
        }
    }
}
