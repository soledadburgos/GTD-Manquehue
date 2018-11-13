package com.grupogtd.test.pruebasdeaceptacion.steps;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 14-12-2017.
 */
public class AltaCUStepsDefinition {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("AltaCU", LOGGER);
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
    static AgregarNuevoProductoInstanciaPage agregarNuevoProductoInstanciaPage;
    static ContratoPage contratoPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static InstalacionesPage instalacionesPage;
    static DetalleActividadesPage detalleActividadesPage;

    @Given("^el usuario abre el navegador y vamos al sitio Web de SICRET$")
    public void el_usuario_abre_el_navegador_y_vamos_al_sitio_Web_de_SICRET() throws Throwable {
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("Alta CU", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^el usuario ingrese sus datos, userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void elUsuarioIngreseSusDatosUserNameYElPassWord(String user, String password) throws Throwable {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(user, password, LOGGER, driver);
    }

    @When("^el usuario ingrese a GESCOM desde el menu de SICRET$")
    public void el_usuario_ingrese_a_GESCOM_desde_el_menu_de_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^el usuario ingrese a Resumen Cliente desde GESCOM$")
    public void el_usuario_ingrese_a_Resumen_Cliente_desde_GESCOM() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
    }

    @And("^el usuario crea un Alta Cobre ingresando el rut \"([^\"]*)\" y seleccionando la cuenta de facturacion \"([^\"]*)\"$")
    public void elUsuarioCreaUnAltaCobreIngresandoElRutYSeleccionandoLaCuentaDeFacturacion(String rut, String ctaFacturacion) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.crearAltaAction(driver, LOGGER, rut, ctaFacturacion);
    }

    /*@When("^el usuario crea un Alta Cobre ingresando el rut \"([^\"]*)\"$")
    public void el_usuario_crea_un_Alta_Cobre_ingresando_el_rut(String rut, String ctaFacturacion) throws Throwable {
        resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.crearAltaAction(driver, LOGGER, rut, ctaFacturacion);
    }*/

    @When("^el usuario selecciona crear modificar cliente desde el menu de crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cliente_desde_el_menu_de_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.ingresoCrearClienteAction(driver, LOGGER);
    }

    @When("^el usuario presiona el boton modificar cliente en la pantalla de crear cliente$")
    public void el_usuario_presiona_el_boton_modificar_cliente_en_la_pantalla_de_crear_cliente() throws Throwable {
        crearClientePage = PageFactory.initElements(driver, CrearClientePage.class);
        crearClientePage.crearClienteAction(driver, LOGGER);
    }

    @When("^el usuario selecciona crear modificar cuenta de servicio desde el menu de crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cuenta_de_servicio_desde_el_menu_de_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.buscarCuentaServicioAction(driver, LOGGER);
    }

    @When("^el usuario selecciona la cuenta de servicio \"([^\"]*)\" y presiona el boton seleccionar$")
    public void el_usuario_selecciona_la_cuenta_de_servicio_y_presiona_el_boton_seleccionar(String ctaServicioCU) throws Throwable {
        cuentaServicioPage = PageFactory.initElements(driver, CuentaServicioPage.class);
        cuentaServicioPage.selecionarCuentaServicioCUAction(driver, LOGGER, ctaServicioCU);
    }

    @When("^el usuario selecciona servicio solicitado desde el menu crear solicitud$")
    public void el_usuario_selecciona_servicio_solicitado_desde_el_menu_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);
    }

    @When("^el usuario selecciona tipo uso \"([^\"]*)\", tipo servicio \"([^\"]*)\" y velocidad \"([^\"]*)\"$")
    public void el_usuario_selecciona_tipo_uso_tipo_servicio_y_velocidad(String tipoUso, String tipoServicio, String velocidad) throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.agregarADSLAction(driver, LOGGER, tipoUso, tipoServicio, velocidad);
    }

    @When("^el usuario selecciona una vez mas para gregar TV tipo uso \"([^\"]*)\" y tipo servicio \"([^\"]*)\"$")
    public void el_usuario_selecciona_una_vez_mas_para_gregar_TV_tipo_uso_y_tipo_servicio(String tipoUso, String tipoServicio) throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.agregarTVCUAction(driver, LOGGER, tipoUso, tipoServicio);
    }

    @When("^el usuario presiona el boton guardar$")
    public void el_usuario_presiona_el_boton_guardar() throws Throwable {
        sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
        sTSSuperPage.guardarAction(driver, LOGGER);
    }

    @When("^el usuario selecciona datos de la venta desde el menu de crear solicitud$")
    public void el_usuario_selecciona_datos_de_la_venta_desde_el_menu_de_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
    }

    @When("^el usuario ingresa comentario \"([^\"]*)\" de la venta$")
    public void el_usuario_ingresa_comentario_de_la_venta(String comentario) throws Throwable {
        datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, comentario);
    }

    @When("^el usuario selecciona crear modificar cta facturacion desde el menu de crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_cta_facturacion_desde_el_menu_de_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.crearModificarCtaFactAction(driver, LOGGER);
    }

    @When("^el usuario presiona el boton modificar$")
    public void el_usuario_presiona_el_boton_modificar() throws Throwable {
        cuentaFacturacionCrearModificarPage = PageFactory.initElements(driver, CuentaFacturacionCrearModificarPage.class);
        cuentaFacturacionCrearModificarPage.CtaFactCrearModificarAction(driver, LOGGER);
    }

    @When("^el usuario selecciona crear modificar contacto cliente desde pantalla crear solicitud$")
    public void el_usuario_selecciona_crear_modificar_contacto_cliente_desde_pantalla_crear_solicitud() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        contactosDelCLientePage = PageFactory.initElements(driver, ContactosDelCLientePage.class);
        crearSolicitudPage.crearModificarContactoClienteAction(driver, LOGGER);
        contactosDelCLientePage.CrearModificarContactoClienteAction(driver, LOGGER);
    }

    @When("^el usuario finaliza la fase de crear el Alta Cobre$")
    public void el_usuario_finaliza_la_fase_de_crear_el_Alta_Cobre() throws Throwable {
        crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        id = crearSolicitudPage.finalizarFaseAltaAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @Then("^el usuario ingresa en el Gestor de Solicitudes$")
    public void el_usuario_ingresa_en_el_Gestor_de_Solicitudes() throws Throwable {
        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);
    }

    @Then("^el usuario busca la solicitud recien creada$")
    public void el_usuario_busca_la_solicitud_recien_creada() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @Then("^se revisa si la solicitud esta en revision comercial$")
    public void se_revisa_si_la_solicitud_esta_en_revision_comercial() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        esRevisionComercial = gestorSolicitudPage.aprobarRevisionComercialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^si esta en revision comercial, se aprueba y se continua$")
    public void si_esta_en_revision_comercial_se_aprueba_y_se_continua() throws Throwable {
        actividadCrearModificarPage = PageFactory.initElements(driver, ActividadCrearModificarPage.class);
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        ejecutarFactibilidadTecnica = PageFactory.initElements(driver, EjecutarFactibilidadTecnicaPage.class);
        if(esRevisionComercial) {
            actividadCrearModificarPage.cerrarActividadAction(driver, LOGGER, outputFile.getAbsolutePath(), "CERRADA", "OTROS MOTIVOS -5-");

            gestorSolicitudPage.ejecutarFactibilidadTecnica(driver, LOGGER, outputFile.getAbsolutePath(), id);

            ejecutarFactibilidadTecnica.ejecutarFactibilidadTecnicaAction(driver, LOGGER);
        }
    }

    @Then("^se espera que el estado de la solicitud sea factibilidad tecnica OK$")
    public void se_espera_que_el_estado_de_la_solicitud_sea_factibilidad_tecnica_OK() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "FACTIBILIDAD TECNICA OK (6)", id, outputFile.getAbsolutePath());
    }

    @Then("^se selecciona agregar productos a instancia y se presiona el boton ejecutar$")
    public void se_selecciona_agregar_productos_a_instancia_y_se_presiona_el_boton_ejecutar() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.AgregarProductosCUAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }//"<productoCU>", "<contratoVoz>", "<productoTVCU>" y "<equipoDecoTV>"

    @Then("^se selecciona la instancia y se agregan los productos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void se_selecciona_la_instancia_y_se_agregan_los_productos_y(String productoCU, String contratoVoz, String productoTVCU, String equipoDecoTV) throws Throwable {
        agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
        agregarProductosAInstanciaPage.agregarAltaTriPlayCUAction(driver, LOGGER, productoCU, contratoVoz, productoTVCU, equipoDecoTV);
    }

    @Then("^se presiona el boton Finalizar$")
    public void se_presiona_el_boton_Finalizar() throws Throwable {
        agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
        agregarProductosAInstanciaPage.finalizarAgregarProductos(driver, LOGGER);
    }

    @Then("^se selecciona gestionar contrato desde el gestor de solicitud y se presiona el boton ejecutar$")
    public void se_selecciona_gestionar_contrato_desde_el_gestor_de_solicitud_y_se_presiona_el_boton_ejecutar() throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se presiona el boton crear contrato$")
    public void se_presiona_el_boton_crear_contrato() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se selecciona venta presencial$")
    public void se_selecciona_venta_presencial() throws Throwable {
        validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.ventaPresencialCUAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se crea el contrato y se presiona el boton volver$")
    public void se_crea_el_contrato_y_se_presiona_el_boton_volver() throws Throwable {
        contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se adjunta archivo$")
    public void se_adjunta_archivo() throws Throwable {
        contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.cargaArchivoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
    }

    @Then("^se espera que la solicitud quede en estado (\\d+) OT creada y pendiente$")
    public void se_espera_que_la_solicitud_quede_en_estado_OT_creada_y_pendiente(int OTcreada) throws Throwable {
        gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());
    }

    @Then("^se ingresa al sistema de Instalaciones desde el menu de SICRET$")
    public void se_ingresa_al_sistema_de_Instalaciones_desde_el_menu_de_SICRET() throws Throwable {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoInstalacionesAction(driver, LOGGER);
    }

    @Then("^se busca la solicitud creada de Alta Cobre$")
    public void se_busca_la_solicitud_creada_de_Alta_Cobre() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);
    }

    @Then("^se cierran las actividades$")
    public void se_cierran_las_actividades() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.CierreAltaCUAction(driver, LOGGER, outputFile.getAbsolutePath());
    }

    @Then("^se espera que se cierre la OT$")
    public void se_espera_que_se_cierre_la_OT() throws Throwable {
        instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
        instalacionesPage.esperarEstadosAltaTriplayCUAction(driver, LOGGER, id, outputFile.getAbsolutePath());
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
