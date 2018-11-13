import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ramiro.urbina on 05-01-2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/features/Metrogas",
        name= {""},
        glue = { "com.grupogtd.test.pruebasdeaceptacion.steps" },
        plugin = { "html:reportes/cucumber-html-report" })
public class MetrogasTest {
}
