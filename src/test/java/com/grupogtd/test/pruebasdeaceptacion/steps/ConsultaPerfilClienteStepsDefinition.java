package com.grupogtd.test.pruebasdeaceptacion.steps;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Ateclie.GestorReclamosPage;
import com.grupogtd.test.pageObjects.Gescom.GestionComercialPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
import com.grupogtd.test.pageObjects.Gescom.ResumenClientePage;
import com.grupogtd.test.pageObjects.PerfilCliente.PerfilClientePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by soledad.burgos on 24-09-2018.
 */

public class ConsultaPerfilClienteStepsDefinition {
	private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static PerfilClientePage perfilClientePage;
    
    @Given("^El usuario abre navegador y entra al sitio Web SICRET$")
    public void el_usuario_abre_navegador_y_entra_al_sitio_Web_SICRET() throws Throwable {
    	Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
        Thread.sleep(2000);
        driver = Configuration.initDriver();
        driver.get(Datos.url);
    }

    @When("^El usuario ingresa un userName \"([^\"]*)\" y el passWord \"([^\"]*)\"$")
    public void el_usuario_ingresa_un_userName_y_el_passWord(String usuario, String password) throws Throwable {
    	loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginSinDomAction(usuario, password, LOGGER, driver);
    }

    @When("^El usuario ingresa a GESCOM desde Menu SICRET$")
    public void el_usuario_ingresa_a_GESCOM_desde_Menu_SICRET() throws Throwable {
    	homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.ingresoGescomAction(driver, LOGGER);
    }

    @When("^El usuario ingresa a Perfil Clientes desde menu SICRET$")
    public void el_usuario_ingresa_a_Perfil_Clientes_desde_menu_SICRET() throws Throwable {
    	gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
    	gestionComercialPage.ingresoConsultaPerfilClienteAction(driver, LOGGER);
    }
    
    @When("^El usuario busca cliente ingresando el rut \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
    public void el_usuario_busca_cliente_ingresando_el_rut_e(String txtRut, String txtinstancia, String txtcotizacion) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente2(driver, LOGGER, txtRut, txtinstancia, txtcotizacion);
    }
    
    @When("^El usuario ingresa filtros de busqueda \"([^\"]*)\" e \"([^\"]*)\"$")
    public void el_usuario_ingresa_filtros_de_busqueda_e(String txtRut, String txtinstancia) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente3(driver, LOGGER, txtRut, txtinstancia);
    }

    @When("^El usuario ingresa filtros de \"([^\"]*)\" e \"([^\"]*)\"$")
    public void el_usuario_ingresa_filtros_de_e(String txtRut, String txtcotizacion) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente4(driver, LOGGER, txtRut, txtcotizacion);
    }
    
    @When("^El usuario ingresa solo rut \"([^\"]*)\"$")
    public void el_usuario_ingresa_solo_rut(String txtRut) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente5(driver, LOGGER, txtRut);
    }
    
    @When("^Se Valida que existan datos que mostrar$")
    public void se_Valida_que_existan_datos_que_mostrar() throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
    	perfilClientePage.validarlabusqueda(driver, LOGGER);
    }
    
    @When("^El usuario ingresa solo instancia \"([^\"]*)\"$")
    public void el_usuario_ingresa_solo_instancia(String txtinstancia) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente6(driver, LOGGER, txtinstancia);
    }
    
    @When("^El usuario ingresa solo cotizacion \"([^\"]*)\"$")
    public void el_usuario_ingresa_solo_cotizacion(String txtcotizacion) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaCliente7(driver, LOGGER, txtcotizacion);
    }
    
    @When("^El usuario ingresa solo nro ficha \"([^\"]*)\"$")
    public void el_usuario_ingresa_solo_nro_ficha(String txtficha) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscaficha(driver, LOGGER, txtficha);
    }
    
    @When("^El usuario ingresa solo condominio \"([^\"]*)\"$")
    public void el_usuario_ingresa_solo_condominio(String txtcondominio) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscacondominio(driver, LOGGER, txtcondominio);
    }
    
    @When("^El usuario ingresa filtros de direccion \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void el_usuario_ingresa_filtros_de_direccion(String centro, String comun, String call, String sufij, String numer, String dept, String pis) throws Throwable {
    	perfilClientePage = PageFactory.initElements(driver, PerfilClientePage.class);
        perfilClientePage.buscadireccion(driver, LOGGER, centro, comun, call, sufij, numer, dept, pis);
    }
    
    
    @When("^El usuario cierra la ventana y navegador$")
    public void el_usuario_cierra_la_ventana_y_el_navegador() throws InterruptedException{
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }
}
