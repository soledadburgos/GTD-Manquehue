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
public class BajaTest {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestionComercialPage gestionComercialPage;
    static ResumenClientePage resumenClientePage;
    static CrearSolicitudPage crearSolicitudPage;
    static STSSuperPage sTSSuperPage;
    static DatosDeLaVentaPage datosDeLaVentaPage;
    static GestorSolicitudPage gestorSolicitudPage;
    static ContratoPage contratoPage;
    static ContratosPage contratosPage;
    static ValidacionesDeSolicitudPage validacionesDeSolicitudPage;
    static InstalacionesPage instalacionesPage;
    static AgregarProductosAInstanciaPage agregarProductosAInstanciaPage;

    public BajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException{
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(5000);
            outputFile = Configuration.fileCfg("Baja", LOGGER);
            driver = Configuration.initDriver();
            // This is to Instantiate Home Page and LogIn Page class
            loginPage = PageFactory.initElements(driver, LoginPage.class);
            homePage = PageFactory.initElements(driver, HomePage.class);
            gestionComercialPage = PageFactory.initElements(driver, GestionComercialPage.class);
            resumenClientePage = PageFactory.initElements(driver, ResumenClientePage.class);
            crearSolicitudPage = PageFactory.initElements(driver, CrearSolicitudPage.class);
            sTSSuperPage = PageFactory.initElements(driver, STSSuperPage.class);
            datosDeLaVentaPage = PageFactory.initElements(driver, DatosDeLaVentaPage.class);
            gestorSolicitudPage = PageFactory.initElements(driver, GestorSolicitudPage.class);
            contratosPage = PageFactory.initElements(driver, ContratosPage.class);
            contratoPage = PageFactory.initElements(driver, ContratoPage.class);
            validacionesDeSolicitudPage = PageFactory.initElements(driver, ValidacionesDeSolicitudPage.class);
            instalacionesPage = PageFactory.initElements(driver, InstalacionesPage.class);
            agregarProductosAInstanciaPage = PageFactory.initElements(driver, AgregarProductosAInstanciaPage.class);
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
    public void BajaGescom() throws InterruptedException{
        driver.get(Datos.url);

        loginPage.loginSinDomAction(Datos.user, Datos.password, LOGGER, driver);

        homePage.ingresoGescomAction(driver, LOGGER);

        gestionComercialPage.ingresoResumenClienteAction(driver, LOGGER);

        resumenClientePage.crearBajaAction(driver, LOGGER, Datos.rut, Datos.ctaServicioFTTH);

        crearSolicitudPage.servicioSolicitadoAction(driver, LOGGER);

        sTSSuperPage.desconectarBajaTriplayAction(driver, LOGGER);

        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);

        String id = crearSolicitudPage.finalizarFase1BajaAction(driver, LOGGER, outputFile.getAbsolutePath());

        crearSolicitudPage.datosDeLaVentaAction(driver, LOGGER);

        datosDeLaVentaPage.datosDeLaVentaAction(driver, LOGGER, "Prueba Automatizada Baja Triplay");

        crearSolicitudPage.finalizarFase2BajaAction(driver, LOGGER, outputFile.getAbsolutePath());

        gestionComercialPage.ingresoGestorSolicitud(driver, LOGGER);

        gestorSolicitudPage.buscarSolicitudAction(driver, LOGGER, id);

        gestorSolicitudPage.GestionarContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        validacionesDeSolicitudPage.bajaPresencialAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratoPage.crearContratoAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        contratosPage.finalizarAction(driver, LOGGER, outputFile.getAbsolutePath(), id);

        gestorSolicitudPage.esperarEstadoSolicitud(driver, LOGGER, "OT CREADA Y PENDIENTE (10)", id, outputFile.getAbsolutePath());

        homePage.ingresoInstalacionesAction(driver, LOGGER);

        instalacionesPage.buscarSolicitudAction(driver, LOGGER, id);

        instalacionesPage.cierreBajaAction(driver, LOGGER, outputFile.getAbsolutePath());

        instalacionesPage.esperarEstadosBajaTriplayAction(driver, LOGGER, id, outputFile.getAbsolutePath());

    }
}
