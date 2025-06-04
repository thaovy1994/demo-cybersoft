package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validRegistration(String name, String email, String pwd, String repwd, String phone, String dob){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='passwordConfirm']")).sendKeys(repwd);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys(dob);
        driver.findElement(By.xpath("//input[@type='radio' and @value='false']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify redirection to the Login Page is successful
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/login")) {
            System.out.println("Successfully navigated to the login page.");
        } else {
            System.out.println("Did not navigate to the correct login page.");
        }

        //Check Toastify
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'Toastify')]//div[contains(text(),'Email đã tồn tại !')]")
        ));
        System.out.println("Popup Toastify is displayed 'You have successfully registered");
    }

    public void registerWithEmptyFields(){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Actions actions = new Actions(driver);

        //Click on fields then click outside -> display error message
        //Name
        driver.findElement(By.xpath("//input[@id='name']")).click();
        actions.moveByOffset(0, 0).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), ' Name không được bỏ trống ')]")
        ));
        System.out.println("Name must not be empty");

        //Email
        driver.findElement(By.xpath("//input[@id='email']")).click();
        actions.moveByOffset(0, 0).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), '  Email không được bỏ trống ')]")
        ));
        System.out.println("Email must not be empty");

        //Password
        driver.findElement(By.xpath("//input[@id='password']")).click();
        actions.moveByOffset(0, 0).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), '  Password không được bỏ trống ')]")
        ));
        System.out.println("Password must not be empty");

        //Password confirm
        driver.findElement(By.xpath("//input[@id='passwordConfirm']")).click();
        actions.moveByOffset(0, 0).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), '  PasswordConfirm không được bỏ trống ')]")
        ));
        System.out.println("PasswordConfirm must not be empty");

        //Phone
        driver.findElement(By.xpath("//input[@id='phone']")).click();
        actions.moveByOffset(0, 0).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), ' Phone không được bỏ trống ')]")
        ));
        System.out.println("Phone must not be empty");

        //Birthday
        driver.findElement(By.xpath("//input[@id='birthday']")).click();
        actions.moveByOffset(0, 0).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), 'Birthday không được bỏ trống')]")
        ));
        System.out.println("Birthday must not be empty");
    }
    public void invalidNameFormat(String invalidName) {
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(invalidName);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), ' Name Không đúng định dạng ')]")
        ));
        System.out.println("Name is invalid");
    }

    public void invalidEmailFormat(String invalidEmail) {
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmail);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), ' Email không đúng định dạng ')]")
        ));
        System.out.println("Email is invalid");
    }

    public void invalidPassword(String invalidPassword){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(invalidPassword);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), ' Password từ 6 - 32 ký tự ')]")
        ));
        System.out.println(" Password from 6 - 32 characters");
    }

    public void invalidPhone(String phone){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='text-danger' and contains(text(), '  Phone phải từ 03 05 07 08 09 và có 10 số ')]")
        ));
        System.out.println("Phone must from 03 05 07 08 09 and include 10 numbers");
    }

    public void uncheckBox(String name, String email, String pwd, String repwd, String phone, String dob){
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='passwordConfirm']")).sendKeys(repwd);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys(dob);
        driver.findElement(By.xpath("//input[@type='radio' and @value='false']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void checkExistingEmail(String name, String email, String pwd, String repwd, String phone, String dob){
        try{
            driver.findElement(By.xpath("//a[@href='/register']")).click();
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
            driver.findElement(By.xpath("//input[@id='passwordConfirm']")).sendKeys(repwd);
            driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
            driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys(dob);
            driver.findElement(By.xpath("//input[@type='radio' and @value='false']")).click();
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);

            // Tìm tất cả thông báo chứa nội dung "Email đã tồn tại"
            List<WebElement> errorMessages = driver.findElements(
                    By.xpath("//div[contains(@class,'Toastify')]//div[contains(text(),'Email đã tồn tại !')]")
            );

            if (!errorMessages.isEmpty()) {
                System.out.println("Email already exists !");
            } else {
                System.out.println("Account registration successful !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            driver.quit();
        }
    }
}