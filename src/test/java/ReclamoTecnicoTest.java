import com.grupogtd.test.cfg.Configuration;
import com.grupogtd.test.cfg.Datos;
import com.grupogtd.test.pageObjects.Ateclie.AtencionClientesPage;
import com.grupogtd.test.pageObjects.Ateclie.CrearReclamoPage;
import com.grupogtd.test.pageObjects.Ateclie.GestorReclamosPage;
import com.grupogtd.test.pageObjects.Gescom.HomePage;
import com.grupogtd.test.pageObjects.Gescom.LoginPage;
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
public class ReclamoTecnicoTest {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger("ATMlog");
    private static File outputFile;
    static LoginPage loginPage;
    static HomePage homePage;
    static GestorReclamosPage gestorReclamosPage;
    static CrearReclamoPage crearReclamoPage;
    static AtencionClientesPage atencionClientesPage;

    public ReclamoTecnicoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(2000);
            outputFile = Configuration.fileCfg("Reclamo-Técnico", LOGGER);
            driver = Configuration.initDriver();

            loginPage = PageFactory.initElements(driver, LoginPage.class);
            homePage = PageFactory.initElements(driver, HomePage.class);
            gestorReclamosPage = PageFactory.initElements(driver, GestorReclamosPage.class);
            crearReclamoPage = PageFactory.initElements(driver, CrearReclamoPage.class);
            atencionClientesPage = PageFactory.initElements(driver, AtencionClientesPage.class);

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
    public void Reclamo() throws InterruptedException, IOException{
        driver.get(Datos.url);

        loginPage.loginSinDomAction(Datos.user, Datos.password, LOGGER, driver);

        homePage.ingresoAteClieAction(driver, LOGGER);

        atencionClientesPage.ingresoGestorReclamosAction(driver, LOGGER);

        gestorReclamosPage.verCrearModificarReclamoAction(driver, LOGGER);

        String id = crearReclamoPage.crearReclamoAction(driver, LOGGER, Datos.rut, "TECNICO", "INT CU-ON-LINE", "PROBLEMA EQUIPO CLIENTE", outputFile.getAbsolutePath());
        //String id="6134839";
        gestorReclamosPage.buscarReclamoAction(driver, LOGGER, id, outputFile.getAbsolutePath());

        crearReclamoPage.cerrarReclamoAction(driver, LOGGER, id,"EQUIPO", "EQUIPO - SE RECONFIGURA ROUTER RESETEADO POR CLIENTE", outputFile.getAbsolutePath(), id);
    }
}
