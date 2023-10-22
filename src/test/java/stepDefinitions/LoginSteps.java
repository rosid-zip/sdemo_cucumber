package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    private WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        String text_login = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(text_login,"Swag Labs");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be redirected to the products page")
    public void user_should_be_redirected_to_the_products_page() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
        driver.quit();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
        driver.quit();
    }

    @Then("User Logout")
    public void userLogout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @And("User on dashboard")
    public void userOnDashboard() {
        String text = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(text,"Swag Labs");
    }

    @Then("User success logout")
    public void userSuccessLogout() {
        String text_login = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(text_login,"Swag Labs");
        driver.quit();
    }
}
