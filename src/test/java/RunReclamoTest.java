import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ramiro.urbina on 13-12-2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/features/reclamos",
        name= {""},
        glue = { "com.grupogtd.test.pruebasdeaceptacion.steps" },
        plugin = { "html:reportes/cucumber-html-report" })
public class RunReclamoTest {
}
