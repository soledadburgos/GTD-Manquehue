package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import com.grupogtd.test.pageObjects.PerfilCliente.PerfilClientePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 05-01-2018.
 */
public class MetrogasStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("Metrogas", LOGGER);
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static GestorSolicitudPage gestorSolicitudPage;
    static PerfilClientePage perfilClientePage;

    @Given("^El usuario abre el navegador y entra al sitio Web SICRET$")
    public void el_usuario_abre_el_navegador_y_entra_al_sitio_Web_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Metrogas", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^El usuario ingresa userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingresa_userName_y_el_passWord(String usuario, String password) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, password, LOGGER, driver);
    }

    @When("^El usuario ingresa a GESCOM desde el Menu SICRET$")
    public void el_usuario_ingresa_a_GESCOM_desde_el_Menu_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^El usuario ingresa a Resumen Cliente desde GESCOM$")
    public void el_usuario_ingresa_a_Resumen_Cliente_desde_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @When("^El usuario busca un cliente ingresando el rut \"([^\"]*)\"$")
    public void el_usuario_busca_un_cliente_ingresando_el_rut(String rutCliente) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.buscaCliente(driver, LOGGER, rutCliente);
    }

    @When("^Se valida que se abra el mensaje de metrogas y se evalua el \"([^\"]*)\"$")
    public void se_valida_que_se_abra_el_mensaje_de_metrogas_y_se_evalua_el(String Mensaje) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.evaluarMensaje(driver, LOGGER, Mensaje);
    }

    @When("^El usuario se dirije a Gestor de Solicitudes$")
    public void el_usuario_se_dirije_a_Gestor_de_Solicitudes() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);
    }

    @When("^El usuario busca al cliente ingresando el rut \"([^\"]*)\"$")
    public void el_usuario_busca_al_cliente_ingresando_el_rut(String rutCliente) throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarRutAction(driver, LOGGER, rutCliente);
    }

    @When("^El usuario ingresa a Perfil Clientes desde el menu SICRET$")
    public void el_usuario_ingresa_a_Perfil_Clientes_desde_el_menu_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoPerfilClienteAction(driver, LOGGER);
    }

    @When("^El usuario busca el mismo cliente ingresando el rut \"([^\"]*)\"$")
    public void el_usuario_busca_el_mismo_cliente_ingresando_el_rut(String rutCliente) throws Throwable {
        perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente(driver, LOGGER, rutCliente);
    }

    @When("^El usuario cierra la ventana y el navegador$")
    public void el_usuario_cierra_la_ventana_y_el_navegador() throws InterruptedException{
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
