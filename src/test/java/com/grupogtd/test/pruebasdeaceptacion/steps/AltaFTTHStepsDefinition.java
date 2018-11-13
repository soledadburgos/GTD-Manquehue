package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 11-01-2018.
 */
public class AltaFTTHStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("AltaFTTH", LOGGER);
    private static String id;
    private static boolean esRevisionComercial;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static CrearSolicitudPage crearSolicitudPage;
    static CrearClientePage crearClientePage;
    static CuentaServicioPage cuentaServicioPage;
    static STSSuperPage sTSSuperPage;
    static DatosDeLaVentaPage datosDeLaVentaPage;
    static CuentaFacturacionCrearModificarPage cuentaFacturacionCrearModificarPage;
    static ContactosDelCLientePage contactosDelCLientePage;
    static GestorSolicitudPage gestorSolicitudPage;
    static ActividadCrearModificarPage actividadCrearModificarPage;
    static EjecutarFactibilidadTecnicaPage ejecutarFactibilidadTecnica;
    static AgregarProductosAInstanciaPage agregarProductosAInstanciaPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static ContratoPage contratoPage;
    static InstalacionesPage instalacionesPage;

    @Given("^El usuario abre el navegador y vamos al sitio Web de SICRET$")
    public void el_usuario_abre_el_navegador_y_vamos_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Alta FTTH", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^el usuario ingresa sus datos, usuario \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingresa_sus_datos_usuario_y_el_passWord(String usuario, String contrasena) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, contrasena, LOGGER, driver);
    }

    @When("^el usuario ingresa a GESCOM desde el menu SICRET$")
    public void el_usuario_ingresa_a_GESCOM_desde_el_menu_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^el usuario ingresa a Resumen Cliente desde el menu de GESCOM$")
    public void el_usuario_ingresa_a_Resumen_Cliente_desde_el_menu_de_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @When("^el usuario crea un Alta FTTH ingresando el rut \"([^\"]*)\" y seleccionando la cuenta de facturacion \"([^\"]*)\"$")
    public void el_usuario_crea_un_Alta_FTTH_ingresando_el_rut_y_seleccionando_la_cuenta_de_facturacion(String rut, String ctaFacturacion) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.crearAltaAction(driver, LOGGER, rut, ctaFacturacion);
    }

    @When("^el usuario selecciona crear modificar cliente desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cliente_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.ingresoCrearClienteAction(driver, LOGGER);
    }

    @When("^el usuario presiona el boton modificar cliente en la pantalla crear modificar cliente$")
    public void el_usuario_presiona_el_boton_modificar_cliente_en_la_pantalla_crear_modificar_cliente() throws Throwable {
        crearClientePage = PageFactory.initElements(driver, CrearClientePage.class);
        crearClientePage.crearClienteAction(driver, LOGGER);
    }

    @When("^el usuario selecciona crear modificar cuenta de servicio desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cuenta_de_servicio_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.buscarCuentaServicioAction(driver, LOGGER);
    }

    @When("^el usuario busca la cuenta de servicio \"([^\"]*)\" y presiona el boton seleccionar$")
    public void el_usuario_busca_la_cuenta_de_servicio_y_presiona_el_boton_seleccionar(String ctaServicioFTTH) throws Throwable {
        cuentaServicioPage = PageFactory.initElements(driver, CuentaServicioPage.class);
        cuentaServicioPage.selecionarCuentaServicioCUAction(driver, LOGGER, ctaServicioFTTH);
    }

    @When("^el usuario selecciona servicio solicitado desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_servicio_solicitado_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);
    }

    @When("^el usuario selecciona tipo uso \"([^\"]*)\" y tipo servicio \"([^\"]*)\"$")
    public void el_usuario_selecciona_tipo_uso_y_tipo_servicio(String tipoUso, String tipoServicio) throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.agregarTVFTTHAction(driver, LOGGER, tipoUso, tipoServicio);
    }

    @When("^el usuario selecciona tipo uso \"([^\"]*)\", tipo servicio \"([^\"]*)\" y velocidad del servicio \"([^\"]*)\"$")
    public void el_usuario_selecciona_tipo_uso_tipo_servicio_y_velocidad_del_servicio(String tipoUso, String tipoServicio, String velocidadServicio) throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.agregarINTFTTHAction(driver, LOGGER, tipoUso, tipoServicio, velocidadServicio);
    }

    @When("^el usuario selecciona tipo uso \"([^\"]*)\", tipo servicio \"([^\"]*)\"$")
    public void el_usuario_selecciona_tipo_uso_tipo_servicio(String tipoUso, String tipoServicio) throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.agregarVOZFTTHAction(driver, LOGGER, tipoUso, tipoServicio);
    }

    @When("^el usuario presiona el boton guardar en la pantalla de servicio solicitado$")
    public void el_usuario_presiona_el_boton_guardar_en_la_pantalla_de_servicio_solicitado() throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.guardarAction(driver, LOGGER);
    }

    @When("^el usuario selecciona datos de la venta desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_datos_de_la_venta_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario ingresa un comentario \"([^\"]*)\" de la venta$")
    public void el_usuario_ingresa_un_comentario_de_la_venta(String comentario) throws Throwable {
        datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, comentario);
    }

    @When("^el usuario selecciona crear modificar cta facturacion desde la pantalla crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cta_facturacion_desde_la_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.crearModificarCtaFactAction(driver, LOGGER);
    }

    @When("^el usuario presiona el boton modificar en la pantalla crear modificar cta facturacion$")
    public void el_usuario_presiona_el_boton_modificar_en_la_pantalla_crear_modificar_cta_facturacion() throws Throwable {
        cuentaFacturacionCrearModificarPage = PageFactory.initElements(driver, CuentaFacturacionCrearModificarPage.class);
        cuentaFacturacionCrearModificarPage.CtaFactCrearModificarAction(driver, LOGGER);
    }

    @When("^el usuario selecciona crear contacto cliente desde pantalla crear solicitud$")
    public void el_usuario_selecciona_crear_contacto_cliente_desde_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.crearModificarContactoClienteAction(driver, LOGGER);
        contactosDelCLientePage = PageFactory.initElements(driver, ContactosDelCLientePage.class);
        contactosDelCLientePage.CrearModificarContactoClienteAction(driver, LOGGER);
    }

    @When("^el usuario finaliza la fase de crear el Alta FTTH$")
    public void el_usuario_finaliza_la_fase_de_crear_el_Alta_FTTH() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        id = crearSolicitudPage.finalizarFaseAltaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @Then("^el usuario ingresa al Gestor de Solicitudes$")
    public void el_usuario_ingresa_al_Gestor_de_Solicitudes() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);
    }

    @Then("^el usuario busca la solicitud en el gestor de solicitudes$")
    public void el_usuario_busca_la_solicitud_en_el_gestor_de_solicitudes() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @Then("^se revisa si la solicitud esta en estado revision comercial$")
    public void se_revisa_si_la_solicitud_esta_en_estado_revision_comercial() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        esRevisionComercial = gestorSolicitudPage.aprobarRevisionComercialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^si esta en estado revision comercial, se aprueba y se continua$")
    public void si_esta_en_estado_revision_comercial_se_aprueba_y_se_continua() throws Throwable {
        actividadCrearModificarPage = PageFactory.initElements(driver, ActividadCrearModificarPage.class);
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        ejecutarFactibilidadTecnica = PageFactory.initElements(driver, EjecutarFactibilidadTecnicaPage.class);
        if(esRevisionComercial) {
            actividadCrearModificarPage.cerrarActividadAction(driver, LOGGER, outputFile.getAbsolutePath(), "CERRADA", "OTROS MOTIVOS -5-");

            gestorSolicitudPage.ejecutarFactibilidadTecnica(driver, LOGGER, outputFile.getAbsolutePath(), id);

            ejecutarFactibilidadTecnica.ejecutarFactibilidadTecnicaAction(driver, LOGGER);
        }
    }

    @Then("^se revisa que el estado de la solicitud sea factibilidad tecnica OK$")
    public void se_revisa_que_el_estado_de_la_solicitud_sea_factibilidad_tecnica_OK() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "FACTIBILIDAD TECNICA OK (6)", id, outputFile.getAbsolutePath());
    }

    @Then("^se selecciona agregar productos a instancia y se presiona ejecutar$")
    public void se_selecciona_agregar_productos_a_instancia_y_se_presiona_ejecutar() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.AgregarProductosAInstanciaAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se_selecciona_cada_instancia_y_se_aprovisiona \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void se_selecciona_cada_instancia_y_se_aprovisiona_y(String planVoz, String planInternet, String planTV, String equipoTV) throws Throwable {
        agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
        agregarProductosAInstanciaPage.agregarAltaTriPlayAction(driver, LOGGER, planVoz, planInternet, planTV, equipoTV);
    }

    @Then("^se presiona el boton Finalizar en pantalla agregar productos a instancia$")
    public void se_presiona_el_boton_Finalizar_en_pantalla_agregar_productos_a_instancia() throws Throwable {
        agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
        agregarProductosAInstanciaPage.finalizarAgregarProductos(driver, LOGGER);
    }

    @Then("^se selecciona gestionar contrato desde el gestor de solicitud y se presiona boton ejecutar$")
    public void se_selecciona_gestionar_contrato_desde_el_gestor_de_solicitud_y_se_presiona_boton_ejecutar() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se presiona el boton crear contrato en la pantalla gestion de contrato$")
    public void se_presiona_el_boton_crear_contrato_en_la_pantalla_gestion_de_contrato() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se selecciona venta presencial en la pantalla de contrato$")
    public void se_selecciona_venta_presencial_en_la_pantalla_de_contrato() throws Throwable {
        validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.ventaPresencialFTTHAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se crea el contrato y se presiona el boton volver en pantalla contrato$")
    public void se_crea_el_contrato_y_se_presiona_el_boton_volver_en_pantalla_contrato() throws Throwable {
        contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se adjunta documento de contrato$")
    public void se_adjunta_documento_de_contrato() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.cargaArchivoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se espera que la solicitud quede en estado OT creada y pendiente$")
    public void se_espera_que_la_solicitud_quede_en_estado_OT_creada_y_pendiente() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());
    }

    @Then("^el usuario ingresa al sistema de Instalaciones desde el menu de SICRET$")
    public void el_usuario_ingresa_al_sistema_de_Instalaciones_desde_el_menu_de_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoInstalacionesAction(driver, LOGGER);
    }

    @Then("^el usuario busca la solicitud creada de Alta FTTH$")
    public void el_usuario_busca_la_solicitud_creada_de_Alta_FTTH() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @Then("^se cierran las actividades de cada OT$")
    public void se_cierran_las_actividades_de_cada_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.CierreAltaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @Then("^se espera que se termine la solicitud y se cierre la OT$")
    public void se_espera_que_se_termine_la_solicitud_y_se_cierre_la_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.esperarEstadosAltaTriplayAction(driver, LOGGER, id, outputFile.getAbsolutePath());
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }

}
