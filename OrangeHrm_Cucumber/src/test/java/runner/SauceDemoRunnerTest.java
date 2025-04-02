package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    plugin = {
        "pretty",
        "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports/Cucumber.html"
    },
    features = "src/test/resources/orange/features/SauceDemo_DDT.feature",
    glue = "stepDefinition"
//    tags ="@ChromeBrowser",
//    monochrome=true,
//    dryRun=false
)
public class SauceDemoRunnerTest extends AbstractTestNGCucumberTests {
   
} 

