package com.grupogtd.test.cfg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

/**
 * Created by ramiro.urbina on 28-11-2017.
 */
public class Configuration {
    public Configuration() {
    }

    /**
     * @param  test  Nombre del test en ejecución
     * @param  LOGGER objeto Logger a utilizar
     * @return outputFile ruta completa del archivo para el screenshot
     **/
    public static File fileCfg(String test, Logger LOGGER){
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        File outputFile = new File("C:/ATM_TEST/"+timestamp+"_"+test);
        outputFile.mkdir();
        try{
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.FINER);
            Logger.getAnonymousLogger().addHandler(consoleHandler);
            FileHandler fileHandler = new FileHandler(outputFile+"/ATMlog.log", false);
            fileHandler.setLevel(Level.FINER);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            LOGGER.addHandler(fileHandler);
        }catch(IOException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return outputFile;
    }

    /**
     * @return Driver configurado para Iexplorer 32bit
     **/
    public static WebDriver initDriver(){
        System.setProperty("webdriver.ie.driver", "/Repositorio/pruebas-automatizadas-environment/IEDriverServer32.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        System.setProperty("java.util.logging.SimpleFormatter.format","%1$S - [%4$S]: %5$S - %6$S");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 4.0);
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver;
    }
}
