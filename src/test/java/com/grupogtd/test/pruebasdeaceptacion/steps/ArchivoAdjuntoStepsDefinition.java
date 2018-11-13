package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Ateclie.ArchivoAdjuntoPage;
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
 * Created by ramiro.urbina on 29-12-2017.
 */
public class ArchivoAdjuntoStepsDefinition {
    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;
    private static String id;

    @Given("^Abrimos el navegador y vamos al sitio Web de SICRET$")
    public void abrimos_el_navegador_y_vamos_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Archivo Adjunto", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^El usuario ingrese el userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingrese_el_userName_y_el_passWord(String usuario, String contrasenia) throws Throwable {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, contrasenia, LOGGER, driver);
    }

    @When("^El usuario ingrese a Atencion Clientes desde el menu de SICRET$")
    public void el_usuario_ingrese_a_Atencion_Clientes_desde_el_menu_de_SICRET() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoAteClieAction(driver, LOGGER);
    }

    @When("^El usuario ingrese al gestor de reclamos$")
    public void el_usuario_ingrese_al_gestor_de_reclamos() throws Throwable {
        AtencionClientesPage atencionClientesPage = PageFactory.initElements(driver, AtencionClientesPage.class);
        atencionClientesPage.ingresoGestorReclamosAction(driver, LOGGER);
    }

    @When("^El usurio busca reclamo con id Reclamo \"([^\"]*)\" y presiona boton buscar$")
    public void el_usurio_busca_reclamo_con_id_Reclamo_y_presiona_boton_buscar(String idReclamo) throws Throwable {
        GestorReclamosPage gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
        gestorReclamosPage.buscarReclamoAction(driver, LOGGER, idReclamo, outputFile.getAbsolutePath());
        id = idReclamo;
    }

    @When("^El usuario presiona boton Archivo Adjunto$")
    public void el_usuario_presiona_boton_Archivo_Adjunto() throws Throwable {
        CrearReclamoPage crearReclamoPage = PageFactory.initElements(driver, CrearReclamoPage.class);
        crearReclamoPage.presionarBotonArchivoAdjunto(driver, LOGGER);
    }

    @When("^El usuario presiona boton agregar y evaluamos mensaje \"([^\"]*)\" y mensaje \"([^\"]*)\"$")
    public void el_usuario_presiona_boton_agregar_y_evaluamos_mensaje_y_mensaje(String noExisteArchivo, String debeSeleccionarArchivo) throws Throwable {
        ArchivoAdjuntoPage archivoAdjuntoPage = PageFactory.initElements(driver, ArchivoAdjuntoPage.class);
        archivoAdjuntoPage.presionarBotonAgregar(driver, LOGGER, noExisteArchivo, debeSeleccionarArchivo);
    }

    @When("^El usuario adjunta un archivo y evaluamos mensaje \"([^\"]*)\"$")
    public void el_usuario_adjunta_un_archivo_y_evaluamos_mensaje(String archivoGuardadoCorrectamente) throws Throwable {
        ArchivoAdjuntoPage archivoAdjuntoPage = PageFactory.initElements(driver, ArchivoAdjuntoPage.class);
        archivoAdjuntoPage.adjuntarArchivoEvaluaMensaje(driver,LOGGER,id,outputFile.getAbsolutePath(),archivoGuardadoCorrectamente);
    }

    @When("^El usuario selecciona archivo y presiona el boton BORRAR SELECCIONADOS$")
    public void el_usuario_selecciona_archivo_y_presiona_el_boton_BORRAR_SELECCIONADOS() throws Throwable {
        ArchivoAdjuntoPage archivoAdjuntoPage = PageFactory.initElements(driver, ArchivoAdjuntoPage.class);
        archivoAdjuntoPage.borrarReclamoAdjunto(driver,LOGGER);
    }

    @When("^Se confirma borrado del archivo y se evalua mensaje \"([^\"]*)\"$")
    public void se_confirma_borrado_del_archivo_y_se_evalua_mensaje(String borradoExitoso) throws Throwable {
        ArchivoAdjuntoPage archivoAdjuntoPage = PageFactory.initElements(driver, ArchivoAdjuntoPage.class);
        archivoAdjuntoPage.ConfirmarBorrar(driver,LOGGER, borradoExitoso);
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
