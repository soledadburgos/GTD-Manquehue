package com.grupogtd.test.pruebasdeaceptacion.steps;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.GestionComercialPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import com.grupogtd.test.pageObjects.Gescom.ResponderEncuestaPage;
import com.grupogtd.test.pageObjects.Gescom.ResumenClientePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/** 
 * created by soledad.burgos on 28-06-2018.
 * @author sburgos
 */

public class EncuestaResidencialStepsDefinition {
	private static WebDriver driver;
	private static final Logger LOGGER = Logger.getLogger("ATMlog");
	private static File outputFile;
	static LoginPage loginPage;
	static HomePage homePage;
	static GestionComercialPage gestionComercialPage;
	static ResumenClientePage resumenClientePage;
	static ResponderEncuestaPage responderEncuestaPage;
	
	@Given("^El usuario abre navegador y entra al Web SICRET$")
	public void el_usuario_abre_navegador_y_entra_al_Web_SICRET() throws Throwable {
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
		Thread.sleep(2000);
		outputFile = Configuration.fileCfg("Encuesta Residencial", LOGGER);
		driver = Configuration.initDriver();
		driver.get(Datos.url);
	}

	@When("^En encuestas el usuario ingresa userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
	public void en_encuestas_el_usuario_ingresa_userName_y_el_passWord(String usuario, String password) throws Throwable {
	    loginPage = PageFactory.initElements(driver, LoginPage.class);
	    loginPage.loginSinDomAction(usuario, password, LOGGER, driver);
	}

	@When("^En encuestas el usuario ingresa a GESCOM desde el Menu SICRET$")
	public void en_encuestas_el_usuario_ingresa_a_GESCOM_desde_el_Menu_SICRET() throws Throwable {
	    homePage = PageFactory.initElements(driver, HomePage.class);
	    homePage.ingresoGescomAction(driver, LOGGER);
	}

	@When("^En encuestas el usuario ingresa a Resumen Cliente desde GESCOM$")
	public void en_encuestas_el_usuario_ingresa_a_Resumen_Cliente_desde_GESCOM() throws Throwable {
	    gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
	    gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
	}

	@When("^En encuestas el usuario busca un cliente ingresando el rut \"([^\"]*)\"$")
	public void en_encuestas_el_usuario_busca_un_cliente_ingresando_el_rut(String rutCliente) throws Throwable {
		resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.buscaCliente(driver, LOGGER, rutCliente);
	}


	@When("^Se responde la encuesta Pregunta uno \"([^\"]*)\"$")
	public void se_responde_la_encuesta_Pregunta_uno(String respuesta1) throws Throwable {
		responderEncuestaPage = PageFactory.initElements(driver, ResponderEncuestaPage.class);
	    responderEncuestaPage.siguiente1(driver, LOGGER, respuesta1);
		
	}

	@When("^En encuestas el usuario cierra la ventana y el navegador$")
	public void en_encuestas_el_usuario_cierra_la_ventana_y_el_navegador() throws Throwable {
		driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
	}

}