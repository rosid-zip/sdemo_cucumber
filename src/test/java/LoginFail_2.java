import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// scenario : User login with an invalid username
public class LoginFail_2 {
    @Test //tag untuk running script bawah ini
    public void login_success(){
        WebDriver driver; //set driver
        String baseUrl = "https://www.saucedemo.com"; //set url

        WebDriverManager.chromedriver().setup(); //set chrome driver

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // max windows
        driver.get(baseUrl); // akses base url

        driver.findElement(By.id("user-name")).sendKeys("userabc");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(text,"Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }
}
