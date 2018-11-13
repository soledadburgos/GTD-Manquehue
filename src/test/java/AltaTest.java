import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Gescom.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class AltaTest {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;
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

    public AltaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(2000);
            outputFile = Configuration.fileCfg("Alta", LOGGER);
            driver = Configuration.initDriver();
            loginPage = PageFactory.initElements(driver, LoginPage.class);
            homePage = PageFactory.initElements(driver, HomePage.class);
            gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
            resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
            crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
            crearClientePage = PageFactory.initElements(driver, CrearClientePage.class);
            cuentaServicioPage = PageFactory.initElements(driver, CuentaServicioPage.class);
            sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
            datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
            cuentaFacturacionCrearModificarPage = PageFactory.initElements(driver, CuentaFacturacionCrearModificarPage.class);
            contactosDelCLientePage = PageFactory.initElements(driver, ContactosDelCLientePage.class);
            gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
            actividadCrearModificarPage = PageFactory.initElements(driver, ActividadCrearModificarPage.class);
            ejecutarFactibilidadTecnica = PageFactory.initElements(driver, EjecutarFactibilidadTecnicaPage.class);
            agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
            agregarNuevoProductoInstanciaPage = PageFactory.initElements(driver, AgregarNuevoProductoInstanciaPage.class);
            contratosPage = PageFactory.initElements(driver, ContratosPage.class);
            contratoPage = PageFactory.initElements(driver, ContratoPage.class);
            validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
            instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
            detalleActividadesPage = PageFactory.initElements(driver, DetalleActividadesPage.class);
        } catch (IOException ex) {
            Logger.getLogger(AltaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        driver.quit();
        LogManager.getLogManager().reset();
        Thread.sleep(5000);
    }

    @Test
    public void AltaGescom() throws InterruptedException{
        driver.get(Datos.url);

        loginPage.loginSinDomAction(Datos.user, Datos.password, LOGGER, driver);

        homePage.ingresoGescomAction(driver, LOGGER);

        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);

        resumenClientePage.crearAltaAction(driver, LOGGER, Datos.rut, Datos.ctaFacturacion);

        crearSolicitudPage.ingresoCrearClienteAction(driver, LOGGER);

        crearClientePage.crearClienteAction(driver, LOGGER);

        crearSolicitudPage.buscarCuentaServicioAction(driver, LOGGER);

        cuentaServicioPage.selecionarCuentaServicioAction(driver, LOGGER);

        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);

        sTSSuperPage.agregarTVFTTHAction(driver, LOGGER, "COMERCIAL", "TV FTTH");

        sTSSuperPage.agregarINTFTTHAction(driver, LOGGER, "COMERCIAL", "INT FTTH", "2000/1500");

        sTSSuperPage.agregarVOZFTTHAction(driver, LOGGER, "COMERCIAL", "VOZ FTTH");

        sTSSuperPage.guardarAction(driver, LOGGER);

        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);

        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Test Automatizado Tri play FTTH");

        crearSolicitudPage.crearModificarCtaFactAction(driver, LOGGER);

        cuentaFacturacionCrearModificarPage.CtaFactCrearModificarAction(driver, LOGGER);

        crearSolicitudPage.crearModificarContactoClienteAction(driver, LOGGER);

        contactosDelCLientePage.CrearModificarContactoClienteAction(driver, LOGGER);

        String id = crearSolicitudPage.finalizarFaseAltaAction(driver, LOGGER, outputFile.getAbsolutePath());

        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);

        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);

        boolean esRevisionComercial = gestorSolicitudPage.aprobarRevisionComercialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        if(esRevisionComercial) {
            actividadCrearModificarPage.cerrarActividadAction(driver, LOGGER, outputFile.getAbsolutePath(), "CERRADA", "OTROS MOTIVOS -5-");

            gestorSolicitudPage.ejecutarFactibilidadTecnica(driver, LOGGER, outputFile.getAbsolutePath(), id);

            ejecutarFactibilidadTecnica.ejecutarFactibilidadTecnicaAction(driver, LOGGER);
        }

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "FACTIBILIDAD TECNICA OK (6)", id, outputFile.getAbsolutePath());

        gestorSolicitudPage.AgregarProductosAInstanciaAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        agregarProductosAInstanciaPage.agregarAltaTriPlayAction(driver, LOGGER, "PLAN VOZ 500 MINUTOS", "PLAN INTERNET HOGAR 10 Mbps", "PLAN TV INTERACTIVA - INICIAL (60-977)", "ARRIENDO DECO");

        agregarProductosAInstanciaPage.finalizarAgregarProductos(driver, LOGGER);

        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        validacionesDeSolicitudPage.ventaPresencialFTTHAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.cargaArchivoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());

        homePage.ingresoInstalacionesAction(driver, LOGGER);

        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);

        instalacionesPage.CierreAltaAction(driver, LOGGER, outputFile.getAbsolutePath());

        instalacionesPage.esperarEstadosAltaTriplayAction(driver, LOGGER, id, outputFile.getAbsolutePath());

    }
}
