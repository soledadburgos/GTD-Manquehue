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
 * Created by ramiro.urbina on 15-01-2018.
 */
public class BajaFTTHStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("BajaFTTH", LOGGER);
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

    @Given("^El usuario abre el navegador e ingresa al sistema SICRET$")
    public void el_usuario_abre_el_navegador_e_ingresa_al_sistema_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Baja FTTH", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^el usuario ingresa sus datos, usuario \"([^\"]*)\" y la contrasena \"([^\"]*)\"$")
    public void el_usuario_ingresa_sus_datos_usuario_y_la_contrasena(String usuario, String password) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, password, LOGGER, driver);
    }

    @When("^el usuario ingresa a GESCOM desde el menu ingreso datos de SICRET$")
    public void el_usuario_ingresa_a_GESCOM_desde_el_menu_ingreso_datos_de_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^el usuario ingresa a Resumen Cliente desde el menu GESCOM$")
    public void el_usuario_ingresa_a_Resumen_Cliente_desde_el_menu_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @When("^el usuario crea una Baja FTTH ingresando el rut \"([^\"]*)\" y seleccionando la cuenta de Servicio \"([^\"]*)\"$")
    public void el_usuario_crea_una_Baja_FTTH_ingresando_el_rut_y_seleccionando_la_cuenta_de_Servicio(String rut, String ctaServicio) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.crearBajaAction(driver, LOGGER, rut, ctaServicio);
    }

    @When("^el usuario selecciona el enlace servicio solicitado desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_el_enlace_servicio_solicitado_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);
    }

    @When("^el usuario selecciona los servicios FTTH y los desconecta$")
    public void el_usuario_selecciona_los_servicios_FTTH_y_los_desconecta() throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.desconectarBajaTriplayAction(driver, LOGGER);
    }

    @When("^el usuario finaliza la primera fase de solicitud$")
    public void el_usuario_finaliza_la_primera_fase_de_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario selecciona el boton crear solicitud$")
    public void el_usuario_selecciona_el_boton_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        id = crearSolicitudPage.finalizarFase1BajaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario selecciona Datos de la venta en la pantalla crear solicitud$")
    public void el_usuario_selecciona_Datos_de_la_venta_en_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario ingresa todos los datos de la venta$")
    public void el_usuario_ingresa_todos_los_datos_de_la_venta() throws Throwable {
        datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Prueba Automatizada Baja Triplay FTTH");
    }

    @When("^el usuario finaliza la fase de baja del servicio FTTH$")
    public void el_usuario_finaliza_la_fase_de_baja_del_servicio_FTTH() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase2BajaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario ingresa a gestor de solicitudes desde GESCOM$")
    public void el_usuario_ingresa_a_gestor_de_solicitudes_desde_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);
    }

    @When("^el usuario busca la solicitud de baja FTTH en el gestor de solicitudes$")
    public void el_usuario_busca_la_solicitud_de_baja_FTTH_en_el_gestor_de_solicitudes() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @When("^el usuario espera a que la solicitud este en estado \"([^\"]*)\"$")
    public void el_usuario_espera_a_que_la_solicitud_este_en_estado(String estadoSolicitud) throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, estadoSolicitud, id, outputFile.getAbsolutePath());
    }

    @When("^el usuario selecciona gestionar contrato de la lista de operaciones$")
    public void el_usuario_selecciona_gestionar_contrato_de_la_lista_de_operaciones() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se comienza con las validaciones$")
    public void se_comienza_con_las_validaciones() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se selecciona baja presencial y se presiona finalizar$")
    public void se_selecciona_baja_presencial_y_se_presiona_finalizar() throws Throwable {
        validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.bajaPresencialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se presiona el boton crear contrato y luego se presiona el boton volver$")
    public void se_presiona_el_boton_crear_contrato_y_luego_se_presiona_el_boton_volver() throws Throwable {
        contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^se finaliza la etapa de gestion de contrato$")
    public void se_finaliza_la_etapa_de_gestion_de_contrato() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @When("^el usuario espera a que la solicitud quede en estado \"([^\"]*)\"$")
    public void el_usuario_espera_a_que_la_solicitud_quede_en_estado(String estadoSolicitud) throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, estadoSolicitud, id, outputFile.getAbsolutePath());
    }

    @When("^el usuario ingresa al sistema INSTALACIONES desde el menu de sicret$")
    public void el_usuario_ingresa_al_sistema_INSTALACIONES_desde_el_menu_de_sicret() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoInstalacionesAction(driver, LOGGER);
    }

    @When("^el usuario busca la solicitud en el gestor de OT de instalaciones$")
    public void el_usuario_busca_la_solicitud_en_el_gestor_de_OT_de_instalaciones() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @When("^el usuario cierra las actividades de baja de FTTH$")
    public void el_usuario_cierra_las_actividades_de_baja_de_FTTH() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.cierreBajaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @When("^el usuario espera a que se cierre la OT$")
    public void el_usuario_espera_a_que_se_cierre_la_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.esperarEstadosBajaTriplayAction(driver, LOGGER, id, outputFile.getAbsolutePath());
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
