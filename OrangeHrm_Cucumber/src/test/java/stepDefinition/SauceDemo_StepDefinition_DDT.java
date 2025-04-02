package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo_StepDefinition_DDT {
    public WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Given("the user is in Login page")
    public void the_user_is_in_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }

    @When("the user provides username {string}")
    public void the_user_provides_username(String username) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("the user is able to see {string}")
    public void the_user_is_able_to_see(String expectedResult) {
        try {
            WebElement productHeader = driver.findElement(By.className("title"));
            String actualResult = productHeader.getText();
            Assert.assertEquals(expectedResult, actualResult);
        } catch (Exception e) {
            WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            String actualError = errorMessage.getText();
            Assert.assertTrue(actualError.contains(expectedResult));
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}