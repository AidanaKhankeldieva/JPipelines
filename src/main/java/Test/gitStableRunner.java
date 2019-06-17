package Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/TestFeatures",
        glue = "StepDefinitions",
        tags = {"@smokeTest", "@ui"},
        dryRun = false
)
public class gitStableRunner {
}
