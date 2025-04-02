package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Login_SauceDemo_stepDefinition {
	
    WebDriver driver;
    
    @Before
    public void setup() {
        System.out.println("Launching browser before scenario");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser after scenario");
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the sauce demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User provides valid credentials")
    public void user_provides_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Swag Labs page is displayed")
    public void swag_labs_page_is_displayed() {
        WebElement homepage = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        String expectedText = "Swag Labs";
        String actualText = homepage.getText();
        Assert.assertEquals(actualText, expectedText, "Login failed! Swag Labs page not displayed.");
        driver.quit();
    }

    @When("User provides username but no password")
    public void user_provides_username_but_no_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Shows error message for missing password")
    public void shows_error_message_for_missing_password() {
        WebElement errorMessage = driver.findElement(By.xpath("//h3[text()='Epic sadface: Password is required']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Expected error message not displayed!");
        driver.quit();
    }

    @When("User provides password but no username")
    public void user_provides_password_but_no_username() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Shows error message for missing username")
    public void shows_error_message_for_missing_username() {
        WebElement errorMessage = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username is required']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Expected error message not displayed!");
        driver.quit();
    }

    @When("User provides incorrect username and password")
    public void user_provides_incorrect_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Shows error message for invalid credentials")
    public void shows_error_message_for_invalid_credentials() {
        WebElement errorMessage = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Expected error message not displayed!");
        driver.quit();
    }
    
    @Then("close the application")
    public void close_the_application() {
    	driver.quit();
      
    }
}
