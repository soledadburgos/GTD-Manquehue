package com.grupogtd.test.pruebasdeaceptacion.steps;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.CrearSolicitudPage;
import com.grupogtd.test.pageObjects.Gescom.CuentaFacturacionBuscarEliminarPage;
import com.grupogtd.test.pageObjects.Gescom.GestionComercialPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import com.grupogtd.test.pageObjects.Gescom.ResumenClientePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by soledad.burgos on 12-11-2018.
 */

public class TrasladoStepsDefinition {	
	private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("Traslado", LOGGER);
    private static String id;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static GestionComercialPage gestionComercialPage;
    private static ResumenClientePage resumenClientePage;
    private static CrearSolicitudPage crearSolicitudPage;
    private static CuentaFacturacionBuscarEliminarPage cuentaFacturacionBuscarEliminarPage;
    

    @Given("^el usuario debe abrir el navegador e ingresamos al sitio Web de SICRET$")
    public void el_usuario_debe_abrir_el_navegador_e_ingresamos_al_sitio_Web_de_SICRET() throws Throwable {
    	Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("CambiodeNumero", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }
    
	@When("^el usuario ingresa el userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
	public void el_usuario_ingresa_el_userName_y_el_passWord(String user, String password) throws Throwable {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(user, password, LOGGER, driver);
	}

	@When("^el usuario ingresa a GESCOM en el menu de SICRET$")
	public void el_usuario_ingresa_a_GESCOM_en_el_menu_de_SICRET() throws Throwable {
		homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
	}

	@When("^el usuario ingresa a Resumen Cliente en el submenu GESCOM$")
	public void el_usuario_ingresa_a_Resumen_Cliente_en_el_submenu_GESCOM() throws Throwable {
		gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
	}

	@When("^el usuario ingresa el rut \"([^\"]*)\", selecciona la cuenta \"([^\"]*)\" y selecciona Traslado$")
	public void el_usuario_ingresa_el_rut_selecciona_la_cuenta_y_selecciona_Traslado(String rut, String ctaServicio) throws Throwable {
		resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.trasladoInternetFTTHAction(driver, LOGGER, rut, ctaServicio);
	}

	@When("^el usuario selecciona opcion uno Buscar Cta Facturacion fase I$")
	public void el_usuario_selecciona_opcion_uno_Buscar_Cta_Facturacion_fase_I() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.buscarCtaFactAction(driver, LOGGER);
	}

	@When("^el usuario busca la cuenta de facturacion \"([^\"]*)\"> y la modifica$")
	public void el_usuario_busca_la_cuenta_de_facturacion_y_la_modifica(String ctafacturacion) throws Throwable {
		cuentaFacturacionBuscarEliminarPage = PageFactory.initElements(driver, CuentaFacturacionBuscarEliminarPage.class);
		cuentaFacturacionBuscarEliminarPage.seleccionarCtaFacturacionAction(driver, LOGGER, ctafacturacion);
	}
}