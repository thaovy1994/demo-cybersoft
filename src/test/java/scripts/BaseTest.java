package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo5.cybersoft.edu.vn/");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
