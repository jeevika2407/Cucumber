package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {
        "pretty",
        "html:target/cucumber-reports/Cucumber.html",
        "json:target/cucumber-reports/Cucumber.json"
    },
    features = "src\\test\\resources\\orange\\features\\SauceDemoLogin.feature",
    glue = "stepDefinition"
)
public class SauceDemoRunnerTest extends AbstractTestNGCucumberTests {

}
