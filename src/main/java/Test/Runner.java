package Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumberHTML-report",
        "json:target/cucumber.json"},
        features = "src/main/resources/TestFeatures/TestMyApplication",
        glue = "StepDefinitions",
        tags = "@Database",
        dryRun = false
)
public class Runner {
}
