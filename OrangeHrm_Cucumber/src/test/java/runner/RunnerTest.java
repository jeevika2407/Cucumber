package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin={"pretty","html:target/cucumber-reports/Cucumber.html"},features="src\\test\\resources\\orange\\features\\OrangehrmLogin.feature",glue="stepDefinition")
public class RunnerTest extends AbstractTestNGCucumberTests{
	
}