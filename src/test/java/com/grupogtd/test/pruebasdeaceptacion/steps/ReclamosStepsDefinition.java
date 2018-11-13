package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Ateclie.AtencionClientesPage;
import com.grupogtd.test.pageObjects.Ateclie.CrearReclamoPage;
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
 * Created by ramiro.urbina on 13-12-2017.
 */
public class ReclamosStepsDefinition {
    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;
    private static String id;

    @Given("^abrimos el navegador y vamos al sitio Web de SICRET$")
    public void abrimos_el_navegador_y_vamos_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Reclamos", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^el usuario ingrese el userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingrese_el_userName_y_el_passWord(String user, String password) throws Throwable {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(user, password, LOGGER, driver);
    }

    @When("^el usuario ingrese a Atencion Clientes desde el menu de SICRET$")
    public void el_usuario_ingrese_a_Atencion_Clientes_desde_el_menu_de_SICRET() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoAteClieAction(driver, LOGGER);
    }

    @When("^el usuario ingrese al gestor de reclamos$")
    public void el_usuario_ingrese_al_gestor_de_reclamos() throws Throwable {
        AtencionClientesPage atencionClientesPage = PageFactory.initElements(driver, AtencionClientesPage.class);
        atencionClientesPage.ingresoGestorReclamosAction(driver, LOGGER);
    }

    @When("^el usuario presione el boton crear modificar reclamos$")
    public void el_usuario_presione_el_boton_crear_modificar_reclamos() throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.verCrearModificarReclamoAction(driver, LOGGER);
    }

    @When("^se crea reclamo con rut \"([^\"]*)\" y familia de reclamos \"([^\"]*)\" y tipo de reclamo \"([^\"]*)\" y sintoma \"([^\"]*)\"$")
    public void se_crea_reclamo_con_rut_y_familia_de_reclamos_y_tipo_de_reclamo_y_sintoma(String rut, String familia, String tipo, String sintoma) throws Throwable {
        CrearReclamoPage crearReclamoPage = PageFactory.initElements(driver, CrearReclamoPage.class);
        id = crearReclamoPage.crearReclamoAction(driver, LOGGER, rut, familia, tipo, sintoma, outputFile.getAbsolutePath());
    }

    @When("^se busca reclamo creado para cerrarlo$")
    public void se_busca_reclamo_creado_para_cerrarlo() throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.buscarReclamoAction(driver, LOGGER, id, outputFile.getAbsolutePath());
    }

    @When("^se cierra reclamo con rut \"([^\"]*)\", familia \"([^\"]*)\" y solucion \"([^\"]*)\"$")
    public void se_cierra_reclamo_con_rut_familia_y_solucion(String rut, String familia, String solucion) throws Throwable {
        CrearReclamoPage crearReclamoPage = PageFactory.initElements(driver, CrearReclamoPage.class);
        if(!("PREGUNTA".equals(familia))){
            crearReclamoPage.cerrarReclamoAction(driver, LOGGER, rut, familia, solucion, outputFile.getAbsolutePath(), id);
        }
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }

}
