package com.grupogtd.test.utility;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class ScreenShotTool {
    public static void screenshot(String path, String fileName, WebDriver driver, Logger LOGGER){
        LOGGER.log(Level.INFO,"---Screenshot---");
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scr, new File(path+"/"+FileTool.fileCountByExt(path, "png", LOGGER)+fileName+".png"));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE,ex.getMessage());
        }
    }
}
