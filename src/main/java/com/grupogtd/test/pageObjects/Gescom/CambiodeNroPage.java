package com.grupogtd.test.pageObjects.Gescom;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;

/**
 * Created by soledad.burgos on 07-11-2018.
 */

public class CambiodeNroPage {


	public void cambionumeroAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Cambio Numeracion");
		WaitTool.waitToLoad(driver, LOGGER);
		WebElement pagina3 = driver.findElement(By.xpath("/html/body/form/fieldset/table/tbody/tr[3]/td/fieldset/table/tbody/tr[2]/td/table/tbody/tr/td/div/table[2]/tbody/tr/td[5]/a"));
		pagina3.click();
		WebElement disponible = driver.findElement(By.xpath("//*[@id='tablaInformacion']/tbody/tr/td[contains(.,'DISPONIBLE SICRET')]/../td[1]"));
		disponible.click();
		WaitTool.waitToLoad(driver, LOGGER);
		
		}
	
	public void guardarcambiodenumeroAction(WebDriver driver, Logger LOGGER) throws InterruptedException{
		WindowHandTool.windowhandle(driver, LOGGER, "Cambio Numeracion");
		WaitTool.waitToLoad(driver, LOGGER);
		WebElement btnguardar = driver.findElement(By.id("guardar"));
		btnguardar.click();
		WaitTool.waitForAlert(driver, LOGGER);
		
				
		}
	
}