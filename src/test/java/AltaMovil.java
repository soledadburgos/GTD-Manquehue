import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.AdminEquipos.AdministradorEquiposPage;
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
public class AltaMovil {
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
    static AgregarProductosAInstanciaPage agregarProductosAInstanciaPage;
    static AgregarNuevoProductoInstanciaPage agregarNuevoProductoInstanciaPage;
    static ContratoPage contratoPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static InstalacionesPage instalacionesPage;
    static DetalleActividadesPage detalleActividadesPage;
    static ReservaNumeracionMovilPage reservaNumeracionMovilPage;
    static AdministradorEquiposPage administradorEquiposPage;

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(2000);
            outputFile = Configuration.fileCfg("AltaMovil", LOGGER);
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
            agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
            agregarNuevoProductoInstanciaPage = PageFactory.initElements(driver, AgregarNuevoProductoInstanciaPage.class);
            contratosPage = PageFactory.initElements(driver, ContratosPage.class);
            contratoPage = PageFactory.initElements(driver, ContratoPage.class);
            validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
            instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
            detalleActividadesPage = PageFactory.initElements(driver, DetalleActividadesPage.class);
            reservaNumeracionMovilPage = PageFactory.initElements(driver, ReservaNumeracionMovilPage.class);
            administradorEquiposPage = PageFactory.initElements(driver, AdministradorEquiposPage.class);
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
    //@Repeat(5)
    public void AltaMovilGescom() throws InterruptedException{
        driver.get(Datos.url);

        loginPage.loginSinDomAction(Datos.user, Datos.password, LOGGER, driver);

        homePage.ingresoGescomAction(driver, LOGGER);

        /*gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);

        resumenClientePage.crearAltaMovilAction(driver, LOGGER, Datos.rut);

        crearSolicitudPage.ingresoCrearClienteAction(driver, LOGGER);

        crearClientePage.crearClienteAction(driver, LOGGER);

        crearSolicitudPage.buscarCuentaServicioMovilAction(driver, LOGGER);

        cuentaServicioPage.selecionarCuentaServicioMovilAction(driver, LOGGER);

        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);

        sTSSuperPage.agregarMovilAction(driver, LOGGER);

        sTSSuperPage.guardarAction(driver, LOGGER);

        crearSolicitudPage.crearModificarCtaFactMovilAction(driver, LOGGER);

        cuentaFacturacionCrearModificarPage.CtaFactCrearModificarAction(driver, LOGGER);

        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);

        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Test Automatizado Movil");

        crearSolicitudPage.crearModificarContactoClienteMovilAction(driver, LOGGER);

        contactosDelCLientePage.CrearModificarContactoClienteAction(driver, LOGGER);

        String id = crearSolicitudPage.finalizarFaseAltaAction(driver, LOGGER, outputFile.getAbsolutePath());
        */String id = "7491011";

        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);

        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);

        /*boolean esRevisionComercial = gestorSolicitudPage.aprobarRevisionComercialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        if(esRevisionComercial) {
            actividadCrearModificarPage.cerrarActividadAction(driver, LOGGER, outputFile.getAbsolutePath(), "CERRADA", "OTROS MOTIVOS -5-");
        }

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "FACTIBILIDAD COMERCIAL OK (2)", id, outputFile.getAbsolutePath());

        gestorSolicitudPage.ReservaNumeracionMovilAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        String numeroMovil = reservaNumeracionMovilPage.ReservarNumeroMovilAction(driver,LOGGER);
        */ String numeroMovil = "967620321";
        /*gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "NUMERO MOVIL RESERVADO(24)", id, outputFile.getAbsolutePath());

        gestorSolicitudPage.AgregarProductosAInstanciaAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        agregarProductosAInstanciaPage.agregarProductosAltaMovilAction(driver, LOGGER, numeroMovil);

        agregarProductosAInstanciaPage.finalizarAgregarProductos(driver, LOGGER);

        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        validacionesDeSolicitudPage.ventaPresencialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.cargaArchivoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());

        */homePage.ingresoInstalacionesAction(driver, LOGGER);

        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);

        instalacionesPage.CierreAltaMovilAction(driver, LOGGER, outputFile.getAbsolutePath());

        instalacionesPage.administradorEquiposAction(driver, LOGGER, id);

        administradorEquiposPage.buscarEquipoAction(driver,LOGGER, id);

        instalacionesPage.esperarEstadosAltaTriplayCUAction(driver, LOGGER, id, outputFile.getAbsolutePath());

    }
}
