package com.grupogtd.test.pruebasdeaceptacion.steps;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.AgregarProductosAInstanciaPage;
import com.grupogtd.test.pageObjects.Gescom.CambiodeNroPage;
import com.grupogtd.test.pageObjects.Gescom.ContactosDelCLientePage;
import com.grupogtd.test.pageObjects.Gescom.ContratoPage;
import com.grupogtd.test.pageObjects.Gescom.ContratosPage;
import com.grupogtd.test.pageObjects.Gescom.CrearSolicitudPage;
import com.grupogtd.test.pageObjects.Gescom.DatosDeLaVentaPage;
import com.grupogtd.test.pageObjects.Gescom.GestionComercialPage;
import com.grupogtd.test.pageObjects.Gescom.GestorSolicitudPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import com.grupogtd.test.pageObjects.Gescom.ResumenClientePage;
import com.grupogtd.test.pageObjects.Gescom.ValidacionesDeSolicitudPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by soledad.burgos on 07-11-2018.
 */

public class CambioDeNumeroStepsDefinition {
	private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("CambiodeNumero", LOGGER);
    private static String id;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static CrearSolicitudPage crearSolicitudPage;
    static CambiodeNroPage cambiodenro;
    static DatosDeLaVentaPage datosDeLaVentaPage;
    static ContactosDelCLientePage contactosDelCLientePage;
    static GestorSolicitudPage gestorSolicitudPage;
    static AgregarProductosAInstanciaPage agregarProductosAInstanciaPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static ContratoPage contratoPage;
	

	@Given("^el usuario abre navegador e ingresamos al sitio Web de SICRET$")
	public void el_usuario_abre_navegador_e_ingresamos_al_sitio_Web_de_SICRET() throws Throwable {
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        outputFile = Configuration.fileCfg("CambiodeNumero", LOGGER);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
	}

	@When("^el usuario ingresa userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
	public void el_usuario_ingresa_userName_y_el_passWord(String user, String password) throws Throwable {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(user, password, LOGGER, driver);
	}

	@When("^el usuario ingresa a GESCOM del menu de SICRET$")
	public void el_usuario_ingresa_a_GESCOM_del_menu_de_SICRET() throws Throwable {
		homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
	}

	@When("^el usuario ingresa a Resumen Cliente del submenu GESCOM$")
	public void el_usuario_ingresa_a_Resumen_Cliente_del_submenu_GESCOM() throws Throwable {
		gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
	}

	@When("^el usuario ingresa rut \"([^\"]*)\", selecciona la cuenta \"([^\"]*)\", intancia y selecciona cambio de numero$")
	public void el_usuario_ingresa_rut_selecciona_la_cuenta_intancia_y_selecciona_cambio_de_numero(String rut, String ctaServicio) throws Throwable {
		resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.cambiodenumeroAction(driver, LOGGER, rut, ctaServicio);
	}

	@When("^el usuario selecciona opcion uno crea modifica cambio de numero fase I$")
	public void el_usuario_selecciona_opcion_uno_crea_modifica_cambio_de_numero_fase_I() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.creamodificacambiodenumeroAction(driver, LOGGER);
	}

	@When("^el usuario selecciona Activo con estado disponible sicret$")
	public void el_usuario_selecciona_Activo_con_estado_disponible_sicret() throws Throwable {
		cambiodenro = PageFactory.initElements(driver, CambiodeNroPage.class);
		cambiodenro.cambionumeroAction(driver, LOGGER);
	}

	@When("^el usuario guarda el cambio de numero$")
	public void el_usuario_guarda_el_cambio_de_numero() throws Throwable {
		cambiodenro = PageFactory.initElements(driver, CambiodeNroPage.class);
		cambiodenro.guardarcambiodenumeroAction(driver, LOGGER);
	}

	@When("^el usuario selecciona opcion dos con los datos de la venta fase I$")
	public void el_usuario_selecciona_opcion_dos_con_los_datos_de_la_venta_fase_I() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
	}

	@When("^el usuario ingresa los datos del vendedor y guarda$")
	public void el_usuario_ingresa_los_datos_del_vendedor_y_guarda() throws Throwable {
		datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Prueba Automatizada Cambio de Numero");
	}

	@When("^el usuario presiona finalizar fase I$")
	public void el_usuario_presiona_finalizar_fase_I() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase1Action(driver, LOGGER, outputFile.getAbsolutePath());
	}

	@When("^el usuario selecciona opcion uno crea modifica contacto cliente fase II y seleccionar contacto$")
	public void el_usuario_selecciona_opcion_uno_crea_modifica_contacto_cliente_fase_II_y_seleccionar_contacto() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.crearModificarContactoClienteMovilAction(driver, LOGGER);
        contactosDelCLientePage = PageFactory.initElements(driver, ContactosDelCLientePage.class);
        contactosDelCLientePage.CrearModificarContactoClienteAction(driver, LOGGER);
        
	}

	@When("^el usuario presiona finalizar fase II y presiona ver gestor de solicitudes$")
	public void el_usuario_presiona_finalizar_fase_II_y_presiona_ver_gestor_de_solicitudes() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase2Action(driver, LOGGER, outputFile.getAbsolutePath());
	}
	
	@When("^el usuario busca la solicitud para Agregar productos a instancia$")
	public void el_usuario_busca_la_solicitud_para_Agregar_productos_a_instancia() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitud2Action(driver, LOGGER, id);
	}

	@When("^el usuario selecciona la solicitud y ejecuta la operacion Agregar producto a instancia$")
	public void el_usuario_selecciona_la_solicitud_y_ejecuta_la_operacion_Agregar_producto_a_instancia() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.AgregarProductoAction(driver, LOGGER, id, outputFile.getAbsolutePath());
	}

	@When("^el usuario selecciona la instancia con tipo de linea linea SIP$")
	public void el_usuario_selecciona_la_instancia_con_tipo_de_linea_linea_SIP() throws Throwable {
		agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
		agregarProductosAInstanciaPage.seleccionarinstanciacambionumeroAction(driver, LOGGER);
	}

	@When("^el usuario selecciona el boton Finalizar en Agregar producto a instancia$")
	public void el_usuario_selecciona_el_boton_Finalizar_en_Agregar_producto_a_instancia() throws Throwable {
		agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
		agregarProductosAInstanciaPage.AgregarnuevoProductos(driver, LOGGER);
	}

	@When("^el usuario selecciona la solicitud y ejecuta la operacion Gestionar Contrato$")
	public void el_usuario_selecciona_la_solicitud_y_ejecuta_la_operacion_Gestionar_Contrato() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, id, outputFile.getAbsolutePath());
	}

	@When("^el usuario presiona el boton crear contrato en la interfaz Gestion de contrato$")
	public void el_usuario_presiona_el_boton_crear_contrato_en_la_interfaz_Gestion_de_contrato() throws Throwable {
	    contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^el usuario selecciona los datos del tipo de venta y finaliza los datos de la venta$")
	public void el_usuario_selecciona_los_datos_del_tipo_de_venta_y_finaliza_los_datos_de_la_venta() throws Throwable {
		validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.ventaPresencialFTTHAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^el usuario presiona crear para un nuevo contrato y se presiona el boton volver en pantalla contrato$")
	public void el_usuario_presiona_crear_para_un_nuevo_contrato_y_se_presiona_el_boton_volver_en_pantalla_contrato() throws Throwable {
		contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^el usuario presiona el boton finalizar y cerrar el contrato$")
	public void el_usuario_presiona_el_boton_finalizar_y_cerrar_el_contrato() throws Throwable {
		contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^el usuario espera que la solicitud quede en estado OT creada y pendiente\\((\\d+)\\)$")
	public void el_usuario_espera_que_la_solicitud_quede_en_estado_OT_creada_y_pendiente(int arg1) throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud3(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());
	}

	@When("^el usuario cierra la ventana y el navegador$")
	public void el_usuario_cierra_la_ventana_y_el_navegador() throws Throwable {
		driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
	}
	
}
