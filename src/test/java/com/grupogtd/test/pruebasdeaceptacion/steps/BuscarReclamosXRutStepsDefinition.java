package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Ateclie.AtencionClientesPage;
import com.grupogtd.test.pageObjects.Ateclie.GestorReclamosPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 28-12-2017.
 */
public class BuscarReclamosXRutStepsDefinition {
    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;

    @Given("^El usuario abre el navegador y entra al sitio Web de SICRET$")
    public void el_usuario_abre_el_navegador_y_entra_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Busca Reclamos por rut", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^El usuario ingresa el userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingresa_el_userName_y_el_passWord(String usuario, String contrasena) throws Throwable {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, contrasena, LOGGER, driver);
    }

    @When("^El usuario ingresa a Atencion Clientes desde el menu de SICRET$")
    public void el_usuario_ingresa_a_Atencion_Clientes_desde_el_menu_de_SICRET() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoAteClieAction(driver, LOGGER);
    }

    @When("^El usuario ingresa al gestor de reclamos$")
    public void el_usuario_ingresa_al_gestor_de_reclamos() throws Throwable {
        AtencionClientesPage atencionClientesPage = PageFactory.initElements(driver, AtencionClientesPage.class);
        atencionClientesPage.ingresoGestorReclamosAction(driver, LOGGER);
    }

    @When("^El usuario selecciona Fecha desde y selecciona (\\d+) mes antes de la fecha actual$")
    public void el_usuario_selecciona_Fecha_desde_y_selecciona_mes_antes_de_la_fecha_actual(int arg1) throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.seleccionFechaDesde(driver, LOGGER);
    }

    @When("^El usuario ingresa rut \"([^\"]*)\"$")
    public void el_usuario_ingresa_rut(String rut) throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.ingresaRut(driver, LOGGER, rut);
        gestorReclamosPage.presionarBotonBuscar(driver,LOGGER);
    }

    @When("^Se Valida que existan registros que mostrar$")
    public void se_Valida_que_existan_registros_que_mostrar() throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.validaQueExistenReclamos(driver, LOGGER);
    }

    @When("^El usuario cierra el navegador$")
    public void el_usuario_cierra_el_navegador() throws Throwable {
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
