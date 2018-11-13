import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.pageObjects.Gescom.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ramiro.urbina on 29-11-2017.
 */
public class SetUpClassBaja {

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

    public void setUpClassBaja() throws InterruptedException{
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
        } catch (IOException ex) {
            Logger.getLogger(AltaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
