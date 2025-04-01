package stepDefinition;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginStepDefinition{
	WebDriver driver;
	@Given("I am in the Orange HRM Login Page")
	public void i_am_in_the_orange_hrm_login_page(){
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@When("User provides the valid User name")
	public void user_provides_the_valid_user_name() {
		 WebElement ip=driver.findElement(By.xpath("//input[@name=\"username\"]"));
		 ip.sendKeys("Admin");
	}
	@When("User provides the valid password")
	public void user_provides_the_valid_password() {
	    WebElement pw=driver.findElement(By.xpath("//input[@name=\"password\"]"));
	    pw.sendKeys("admin123");
	}
	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
	    WebElement button=driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]"));
	    button.click();
	}
	@Then("I should see a dashboard")
	public void i_should_see_a_dashboard() {
	   WebElement tit=driver.findElement(By.xpath("//h6"));
	   String ex=tit.getText();
	   String ac="Dashboard";
	   Assert.assertEquals(ex,ac);
	}
}