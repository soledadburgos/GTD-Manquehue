package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import com.grupogtd.test.utility.WaitTool;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 28-12-2017.
 */
public class RecrearContrasenaStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("RecrearPassword", LOGGER);
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static RecrearContrasenaPage recrearContrasenaPage;

    @Given("^El usuario abre el navegador y en el sitio Web de SICRET$")
    public void el_usuario_abre_el_navegador_y_en_el_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Recrear Contrasena", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^El usuario ingrese userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingrese_userName_y_el_passWord(String user, String pass) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(user, pass, LOGGER, driver);
    }

    @When("^El usuario ingrese a GESCOM desde el Menu SICRET$")
    public void el_usuario_ingrese_a_GESCOM_desde_el_Menu_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^El usuario ingrese a Resumen Cliente desde GESCOM$")
    public void el_usuario_ingrese_a_Resumen_Cliente_desde_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @When("^El usuario busca un cliente ingresando el rut \"([^\"]*)\" y seleccionando la cuenta de facturacion \"([^\"]*)\"$")
    public void el_usuario_busca_un_cliente_ingresando_el_rut_y_seleccionando_la_cuenta_de_facturacion(String rut, String ctaFact) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.seleccionarCtaFact(driver, LOGGER, rut, ctaFact);
    }

    @When("^El usuario selecciona Url Recrear Contrasena ActiveDirectory$")
    public void el_usuario_selecciona_Url_Recrear_Contrasena_ActiveDirectory() throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.seleccionaUrlRecrearPass(driver, LOGGER);
    }

    @When("^El usuario en la pantalla DATOS CLIENTE EN ACTIVE DIRECTORY presiona boton RECREAR$")
    public void el_usuario_en_la_pantalla_DATOS_CLIENTE_EN_ACTIVE_DIRECTORY_presiona_boton_RECREAR() throws Throwable {
        recrearContrasenaPage = PageFactory.initElements(driver, RecrearContrasenaPage.class);
        recrearContrasenaPage.recreaContrasena(driver,LOGGER);
    }

    @When("^El usuario cierra la pantalla y el navegador$")
    public void el_usuario_cierra_la_pantalla_y_el_navegador() throws Throwable {
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }

}
