package com.grupogtd.test.pageObjects.Gescom;

import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.utility.WaitTool;
import com.grupogtd.test.utility.WindowHandTool;

import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

/** 
 * created by soledad.burgos on 28-06-2018.
 * @author sburgos
 */

public class ResponderEncuestaPage {
	
	@FindBy(how = How.ID, using = "ui-id-1")
	public WebElement encuesta;
	
	@FindBy (how = How.XPATH, using = "//*[@id='P1']/div/label[3]/input")
	public WebElement respuesta1;
	
	@FindBy (how = How.XPATH, using = "//*[@id='contenedorFiltroBusquedaEquipo']/div[2]/button[3]")
	public WebElement siguiente1;
	
	
	//@FindBy(how = How.XPATH, using = "//*[@id='P1']/div/label[3]/input")
	//public WebElement opcion1;
	
	//@FindBy(how = How.XPATH, using = "//*[@id='contenedorFiltroBusquedaEquipo']/div[2]/button[3]")
	//public WebElement siguiente1;
	 
	
	public void siguiente1(WebDriver driver, Logger LOGGER, String opcion1) throws InterruptedException{
		WindowHandTool.windowhandleByElement(driver, LOGGER, encuesta);    
//		WaitTool.waitToLoad(driver, LOGGER);
		respuesta1.click();		
		System.out.println("Radio Button respuesta1 Selected");
		siguiente1.click();
  //      WaitTool.waitToLoad(driver, LOGGER); 

	    }
 
		
		public void siguiente2(WebDriver driver, Logger LOGGER) throws InterruptedException{
		       // opcion1.click();
		       // siguiente1.click();
		       // WaitTool.waitToLoad(driver, LOGGER);
				
				// Detenermos la ejecución de este código por 3000 ms
				Thread.sleep(3000);
								
				// Seleccionamos la opcion 1
				WebElement opcion2 = driver.findElement(By.xpath("//*[@id='P1']/div/label[3]"));
				opcion2.click();                                                     
								
				// Detenermos la ejecución de este código por 3000 ms
				Thread.sleep(3000);
				
				// Seleccionamos siguiente
				WebElement siguiente2 = driver.findElement(By.xpath("//*[@id='contenedorFiltroBusquedaEquipo']/div[2]/button[3]"));
				siguiente2.click(); 
	
    }

		public void siguiente3(WebDriver driver, Logger LOGGER) throws InterruptedException{
		       // opcion1.click();
		       // siguiente1.click();
		       // WaitTool.waitToLoad(driver, LOGGER);
				
				// Detenermos la ejecución de este código por 3000 ms
				Thread.sleep(3000);
								
				// Seleccionamos la opcion 1
				WebElement opcion3 = driver.findElement(By.xpath("//*[@id='P1']/div/label[3]"));
				opcion3.click();                                                     
								
				// Detenermos la ejecución de este código por 3000 ms
				Thread.sleep(3000);
				
				// Seleccionamos siguiente
				WebElement siguiente3 = driver.findElement(By.xpath("//*[@id='contenedorFiltroBusquedaEquipo']/div[2]/button[3]"));
				siguiente3.click(); 
	
 }		
		

}
