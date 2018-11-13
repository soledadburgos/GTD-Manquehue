import com.grupogtd.test.cfg.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

/**
 * Created by ramiro.urbina on 28-11-2017.
 */
public class MiPrimerTest {
    private static WebDriver webDriver;
    @BeforeClass
    public static void setUpClass() throws InterruptedException{
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer*");
            Thread.sleep(2000);
            Configuration configuration = new Configuration();
            webDriver = configuration.initDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void verificarTitulo(){

        webDriver.navigate().to("http://google.cl");
        Assert.assertTrue("El titulo debe contener Google",webDriver.getTitle().contains("Google"));

        webDriver.close();
        webDriver.quit();
    }
}
