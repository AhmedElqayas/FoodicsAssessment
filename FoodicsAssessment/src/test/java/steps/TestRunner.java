package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-html-report-html", "rerun:target/failedScenarios.txt"},
        tags = "@test"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
