package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validRegistration(String name, String email, String pwd, String repwd, String phone){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='passwordConfirm']")).sendKeys(repwd);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("2000-12-25");
        driver.findElement(By.xpath("//input[@type='radio' and @value='false']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify redirection to the Login Page is successful
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/login")) {
            System.out.println("Điều hướng đến trang đăng nhập thành công.");
        } else {
            System.out.println("Không điều hướng đúng trang login.");
        }

        //Check Toastify
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[contains(@class,'Toastify')]//div[contains(text(),'...')]")
//        ));
//        System.out.println("Popup Toastify 'Bạn đã đăng ký thành công' đã hiển thị.");
    }
}