import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

// scenario : User login with an username and password valid
public class Logout {
    @Test //tag untuk running script bawah ini
    public void login_success() throws InterruptedException {
        WebDriver driver; //set driver
        String baseUrl = "https://www.saucedemo.com"; //set url

        WebDriverManager.chromedriver().setup(); //set chrome driver

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // max windows
        driver.get(baseUrl); // akses base url

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(text,"Swag Labs");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        String text_login = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(text_login,"Swag Labs");

        driver.quit();
    }
}
