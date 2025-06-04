package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String email, String pwd){
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);

        WebElement remember = driver.findElement(By.name("remember"));
        boolean isRemember = remember.isSelected();
        if(isRemember){
            remember.click();
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
