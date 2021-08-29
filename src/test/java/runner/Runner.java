package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","rerun:target/rerun.txt"},
        features = "src/test/resources/features", // path for feature files
        glue = "steps", // path for java class with steps
        tags = "@MB2P-117",
        dryRun = false
)
public class Runner {
}
