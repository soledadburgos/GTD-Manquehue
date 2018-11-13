package com.grupogtd.test.pruebasdeaceptacion.steps;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.AgregarNuevoProductoInstanciaPage;
import com.grupogtd.test.pageObjects.Gescom.ContratoPage;
import com.grupogtd.test.pageObjects.Gescom.ContratosPage;
import com.grupogtd.test.pageObjects.Gescom.CrearSolicitudPage;
import com.grupogtd.test.pageObjects.Gescom.DatosDeLaVentaPage;
import com.grupogtd.test.pageObjects.Gescom.DesactivarequiposPage;
import com.grupogtd.test.pageObjects.Gescom.GestionComercialPage;
import com.grupogtd.test.pageObjects.Gescom.GestorSolicitudPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import com.grupogtd.test.pageObjects.Gescom.ResumenClientePage;
import com.grupogtd.test.pageObjects.Gescom.ValidacionesDeSolicitudPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


/**
 * Created by soledad.burgos on 04-10-2018.
 */

public class AgregarModificarProductoStepsDefinition {
	private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile = Configuration.fileCfg("Agregarmodificarproductos", LOGGER);
    private static String id;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static CrearSolicitudPage crearSolicitudPage;
    static DatosDeLaVentaPage datosDeLaVentaPage;
    static DesactivarequiposPage desactivarequipospage;
    static AgregarNuevoProductoInstanciaPage agregarnuevoproductoinstanciaPage;
    static GestorSolicitudPage gestorSolicitudPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static ContratoPage contratoPage;
    
    
	
	@Given("^el usuario abre navegador y vamos al sitio Web de SICRET$")
	public void el_usuario_abre_navegador_y_vamos_al_sitio_Web_de_SICRET() throws Throwable {
	        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
	        Thread.sleep(2000);
	        outputFile = Configuration.fileCfg("Agregarmodificarproductos", LOGGER);
	        driver = Configuration.initDriver();
	        driver.get(Datos.url);
	    }

	@When("^el usuario ingresa los datos, userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
	public void el_usuario_ingresa_los_datos_userName_y_el_passWord(String user, String password) throws Throwable {
	        loginPage = PageFactory.initElements(driver, LoginPage.class);
	        loginPage.loginSinDomAction(user, password, LOGGER, driver);
	    }

	@When("^el usuario ingrese a GESCOM desde menu de SICRET$")
	public void el_usuario_ingrese_a_GESCOM_desde_menu_de_SICRET() throws Throwable {
	        homePage = PageFactory.initElements(driver, HomePage.class);
	        homePage.ingresoGescomAction(driver, LOGGER);
	    }

	@When("^el usuario ingrese a Resumen Cliente desde submenu GESCOM$")
	public void el_usuario_ingrese_a_Resumen_Cliente_desde_submenu_GESCOM() throws Throwable {
	        gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
	        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);
	    }

	@When("^el usuario ingresa el rut \"([^\"]*)\", seleccionando la cuenta de servicio, intancia y agregar modficar productos$")
	public void el_usuario_ingresa_el_rut_seleccionando_la_cuenta_de_servicio_intancia_y_agregar_modficar_productos(String rut) throws Throwable {
		resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
        resumenClientePage.agregarModificarProductosAction(driver, LOGGER, rut);
	}

	@When("^el usuario selecciono los Datos de la venta del menu$")
	public void el_usuario_selecciono_los_Datos_de_la_venta_del_menu() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);
	}
	
	@When("^el usuario ingreso los datos de la venta$")
	public void el_usuario_ingreso_los_datos_de_la_venta() throws Throwable {
		datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Prueba Automatizada Agregar Modificar Productos");
	}
	
	@When("^el usuario finalizo la primera fase$")
	public void el_usuario_finalizo_la_primera_fase() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase1Action(driver, LOGGER, outputFile.getAbsolutePath());
	}
	
	@When("^el usuario selecciono agregar productos a instancia$")
	public void el_usuario_selecciono_agregar_productos_a_instancia() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.agregarProductosAInstanciasAction(driver, LOGGER);
	}
	
	@When("^el_usuario_selecciona_la_instancia_y_se_desconectan_los_equipos$")
	public void el_usuario_selecciona_la_instancia_y_se_desconectan_los_equipos() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.desconectarProductoAction(driver, LOGGER);
	}
	
	@When("^el_usuario_presionar_desconectar_un_equipo$")
	public void el_usuario_presionar_desconectar_un_equipo() throws Throwable{
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.desconectarAction(driver, LOGGER);
	}
	
	@When("^el usuario presiona el boton finalizar$")
	public void el_usuario_presiona_el_boton_finalizar() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.finalizarProductos(driver, LOGGER);
	}
	
	@When("^el usuario selecciona nuevamente la instancia y presiona el boton agregar nuevo$")
	public void el_usuario_selecciona_nuevamente_la_instancia_y_presiona_el_boton_agregar_nuevo() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.seleccionarinstanciaAction(driver, LOGGER);
	}
	
	@When("^el usuario selecciona equipo, contrata mas equipos del que trae \"([^\"]*)\" y guarda productos$")
	public void el_usuario_selecciona_equipo_contrata_mas_equipos_del_que_trae_y_guarda_productos(String rdEquipo) throws Throwable {
		agregarnuevoproductoinstanciaPage= PageFactory.initElements(driver, AgregarNuevoProductoInstanciaPage.class);
		agregarnuevoproductoinstanciaPage.agregarequipoAction(driver, LOGGER, rdEquipo);
	}
	
	@When("^el usuario presiona el boton finalizar para agregar los equipos$")
	public void el_usuario_presiona_el_boton_finalizar_para_agregar_los_equipos() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.finalizarpartedosProductos(driver, LOGGER);
	}
	
	@When("^el usuario finalizo la segunda fase y presionar gestor de solicitud$")
	public void el_usuario_finalizo_la_segunda_fase_y_presionar_gestor_de_solicitud() throws Throwable {
		crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
        crearSolicitudPage.finalizarFase2Action(driver, LOGGER, outputFile.getAbsolutePath());
	}

	//@When("^el usuario ingresa gestor de solicitudes desde el menu de GESCOM$")
	//public void el_usuario_ingresa_gestor_de_solicitudes_desde_el_menu_de_GESCOM() throws Throwable {
		//crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
		//crearSolicitudPage.GestorSolicitudAction(driver, LOGGER);
    //}

	@When("^el usuario busca la solicitud agregar modificar productos en el gestor de solicitudes$")
	public void el_usuario_busca_la_solicitud_agregar_modificar_productos_en_el_gestor_de_solicitudes() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitud2Action(driver, LOGGER, id);
	}
	

	@When("^el usuario modifica los productos nuevamente$")
	public void el_usuario_modifica_los_productos_nuevamente() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.ModificarProductoAction(driver, LOGGER, id, outputFile.getAbsolutePath());
	}
	
	
	@When("^el usuario selecciona el equipo desactivado$")
	public void el_usuario_selecciona_el_equipo_desactivado() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.ActivarProductoAction(driver, LOGGER);
	}

	@When("^el usuario presiona activar equipo desactivado$")
	public void el_usuario_presiona_activar_equipo_desactivado() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.ningunaAction(driver, LOGGER);
	}
	
	@When("^el usuario selecciona el primer deco agregado$")
	public void el_usuario_selecciona_el_primer_deco_agregado() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.seleccionardecoAction(driver, LOGGER);
	}

	@When("^el usuario presiona estado anulada$")
	public void el_usuario_presiona_estado_anulada() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.anularAction(driver, LOGGER);
	}

	@When("^el usuario selecciona el segundo deco agregado$")
	public void el_usuario_selecciona_el_segundo_deco_agregado() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.seleccionardecodosAction(driver, LOGGER);
	}

	@When("^el usuario presiona estado anulado$")
	public void el_usuario_presiona_estado_anulado() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.anularAction(driver, LOGGER);
	}

	@When("^el usuario finaliza las modificaciones$")
	public void el_usuario_finaliza_las_modificaciones() throws Throwable {
		desactivarequipospage = PageFactory.initElements(driver, DesactivarequiposPage.class);
		desactivarequipospage.finalizarpartedosProductos(driver, LOGGER);
	}

	@When("^el usuario busca la solicitud en el gestor de solicitud$")
	public void el_usuario_busca_la_solicitud_en_el_gestor_de_solicitud() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.buscarSolicitud2Action(driver, LOGGER, id);
	}
	
	//Cambiar a anular la solcitud ya que no existe workflow para este flujo
	@When("^se selecciona gestionar contrato desde el gestor de solicitud y presionar boton ejecutar$")
	public void se_selecciona_gestionar_contrato_desde_el_gestor_de_solicitud_y_presionar_boton_ejecutar() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, id, outputFile.getAbsolutePath());
	}

	@When("^se presiona el boton crear contrato en pantalla gestion de contrato$")
	public void se_presiona_el_boton_crear_contrato_en_pantalla_gestion_de_contrato() throws Throwable {
		contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^se selecciona venta presencial en pantalla de contrato$")
	public void se_selecciona_venta_presencial_en_pantalla_de_contrato() throws Throwable {
		validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
        validacionesDeSolicitudPage.ventaPresencialFTTHAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^se crea contrato y se presiona el boton volver en pantalla contrato$")
	public void se_crea_contrato_y_se_presiona_el_boton_volver_en_pantalla_contrato() throws Throwable {
		contratoPage = PageFactory.initElements(driver, ContratoPage.class);
        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^se adjunta el documento de contrato$")
	public void se_adjunta_el_documento_de_contrato() throws Throwable {
		contratosPage = PageFactory.initElements(driver, ContratosPage.class);
        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);
	}

	@When("^se espera que la solicitud quede en estado OT creada$")
	public void se_espera_que_la_solicitud_quede_en_estado_OT_creada() throws Throwable {
		gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
        gestorSolicitudPage.esperarEstadoSolicitud3(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());
	}

		
	@When("^El usuario cierra la ventana y del navegador$")
	public void el_usuario_cierra_la_ventana_y_del_navegador() throws Throwable {
		driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
	}

}           

