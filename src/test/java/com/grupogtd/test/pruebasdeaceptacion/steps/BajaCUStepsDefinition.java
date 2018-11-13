package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 09-01-2018.
 */
public class BajaCUStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("BajaCU", LOGGER);
    private static String id;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static CrearSolicitudPage crearSolicitudPage;
    static STSSuperPage sTSSuperPage;
    static DatosDeLaVentaPage datosDeLaVentaPage;
    static GestorSolicitudPage gestorSolicitudPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static ContratoPage contratoPage;
    static InstalacionesPage instalacionesPage;

    @Given("^El usuario abre el navegador e ingresa al sitio Web de SICRET$")
    public void el_usuario_abre_el_navegador_e_ingresa_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Baja CU", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^el usuario ingresa sus datos, userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingresa_sus_datos_userName_y_el_passWord(String usuario, String password) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, password, LOGGER, driver);
    }

    @When("^el usuario ingresa a GESCOM desde el menu de SICRET$")
    public void el_usuario_ingresa_a_GESCOM_desde_el_menu_de_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^el usuario ingresa a Resumen Cliente desde GESCOM$")
    public void el_usuario_ingresa_a_Resumen_Cliente_desde_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @When("^el usuario crea una Baja Cobre ingresando el rut \"([^\"]*)\" y seleccionando la cuenta de Servicio \"([^\"]*)\"$")
    public void el_usuario_crea_una_Baja_Cobre_ingresando_el_rut_y_seleccionando_la_cuenta_de_Servicio(String rut, String ctaServicio) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.crearBajaAction(driver, LOGGER, rut, ctaServicio);
    }

    @When("^el usuario selecciona el enlace servicio solicitado desde el menu crear solicitud$")
    public void el_usuario_selecciona_el_enlace_servicio_solicitado_desde_el_menu_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);
    }

    @When("^el usuario selecciona los servicios ADSL y los desconecta$")
    public void el_usuario_selecciona_los_servicios_ADSL_y_los_desconecta() throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.desconectarBajaTriplayCUAction(driver, LOGGER);
    }

    @When("^el usuario finaliza la primera fase$")
    public void el_usuario_finaliza_la_primera_fase() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario selecciona el boton crear solicitud en la pantalla crear solicitud$")
    public void el_usuario_selecciona_el_boton_crear_solicitud_en_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        id = crearSolicitudPage.finalizarFase1BajaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario selecciona Datos de la venta del menu$")
    public void el_usuario_selecciona_Datos_de_la_venta_del_menu() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario ingresa los datos de la venta$")
    public void el_usuario_ingresa_los_datos_de_la_venta() throws Throwable {
        datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Prueba Automatizada Baja Triplay");
    }

    @When("^el usuario finaliza la fase de baja del servicio cobre$")
    public void el_usuario_finaliza_la_fase_de_baja_del_servicio_cobre() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase2BajaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario ingresa a gestor de solicitudes desde el menu de GESCOM$")
    public void el_usuario_ingresa_a_gestor_de_solicitudes_desde_el_menu_de_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);
    }

    @When("^el usuario busca la solicitud de baja en el gestor de solicitudes$")
    public void el_usuario_busca_la_solicitud_de_baja_en_el_gestor_de_solicitudes() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @When("^el usuario espera que la solicitud este en estado provision productos OK$")
    public void el_usuario_espera_que_la_solicitud_este_en_estado_provision_productos_OK() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "PROVISION PRODUCTOS OK (8)", id, outputFile.getAbsolutePath());
    }

    @When("^el usuario selecciona gestionar contrato$")
    public void el_usuario_selecciona_gestionar_contrato() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se crea el contrato y se comienza con las validaciones$")
    public void se_crea_el_contrato_y_se_comienza_con_las_validaciones() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se selecciona baja presencial y se finaliza la validacion$")
    public void se_selecciona_baja_presencial_y_se_finaliza_la_validacion() throws Throwable {
        validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.bajaPresencialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se selecciona crear contrato y se presiona el boton volver$")
    public void se_selecciona_crear_contrato_y_se_presiona_el_boton_volver() throws Throwable {
        contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se finaliza etapa de gestion de contrato$")
    public void se_finaliza_etapa_de_gestion_de_contrato() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^el usuario espera que la solicitud quede en estado OT creada y pendiente$")
    public void el_usuario_espera_que_la_solicitud_quede_en_estado_OT_creada_y_pendiente() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());
    }

    @When("^el usuario ingresa al sistema de instalaciones desde el menu de sicret$")
    public void el_usuario_ingresa_al_sistema_de_instalaciones_desde_el_menu_de_sicret() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoInstalacionesAction(driver, LOGGER);
    }

    @When("^el usuario busca la solicitud en el gestor de OT$")
    public void el_usuario_busca_la_solicitud_en_el_gestor_de_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @When("^el usuario cierra las actividades de baja de cobre$")
    public void el_usuario_cierra_las_actividades_de_baja_de_cobre() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.cierreBajaCUAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario espera que el cierre de OT$")
    public void el_usuario_espera_que_el_cierre_de_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.esperarEstadosAltaTriplayCUAction(driver, LOGGER, id, outputFile.getAbsolutePath());
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
