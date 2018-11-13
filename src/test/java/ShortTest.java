import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ramiro.urbina on 28-12-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/features/Traslado/traslado.feature",
        name= {""},
        glue = { "com.grupogtd.test.pruebasdeaceptacion.steps" },
        plugin = { "html:reportes/cucumber-html-report" })
public class ShortTest {
}