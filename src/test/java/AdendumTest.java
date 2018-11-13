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
public class AdendumTest {
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

    public AdendumTest() {
    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(2000);
            outputFile = Configuration.fileCfg("Adendum", LOGGER);
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
    //@Repeat(5)
    public void AdendumGescom() throws InterruptedException{
        driver.get(Datos.url);

        loginPage.loginSinDomAction(Datos.user, Datos.password, LOGGER, driver);

        homePage.ingresoGescomAction(driver, LOGGER);

        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);

        resumenClientePage.agregarModificarProductosAction(driver, LOGGER, Datos.rut);

        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);

        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Test Automatizado Agregar Modificar Productos Tri play FTTH");

        String id = crearSolicitudPage.finalizarFase1AdendumAction(driver, LOGGER, outputFile.getAbsolutePath());
        //String id = "7491031";
        crearSolicitudPage.agregarProductosAInstanciasAction(driver, LOGGER);

        agregarProductosAInstanciaPage.adendumTriPlayAction(driver, LOGGER);

        agregarProductosAInstanciaPage.finalizarAgregarProductos(driver, LOGGER);

        crearSolicitudPage.finalizarFase2AdendumAction(driver, LOGGER, outputFile.getAbsolutePath());

        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);

        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);

        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        validacionesDeSolicitudPage.ventaPresencialAdendumAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());

        homePage.ingresoInstalacionesAction(driver, LOGGER);

        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);

        instalacionesPage.cierreAdendumTriPlayAction(driver, LOGGER, outputFile.getAbsolutePath());

        instalacionesPage.esperarEstadosAdendumTriplayAction(driver, LOGGER, id, outputFile.getAbsolutePath());
    }
}
