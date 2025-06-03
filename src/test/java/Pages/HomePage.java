package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFileSlotFromPanel(){
        //Cuộn lên
        Actions actions = new Actions(driver);
        WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        actions.scrollToElement(homeTool);

        //Hover film
        WebElement findFilm = driver.findElement(By.xpath("(//div[contains(@style, 'background-image')])[1]"));
        actions.moveToElement(findFilm).perform();

        //Click button 'Mua vé'
        WebElement selectFilm = driver.findElement(By.xpath("//a[@href='/detail/11585' and text()='MUA VÉ']"));
        selectFilm.click();

        //Chọn time theo rạp
        WebElement selectTime = driver.findElement(By.xpath("//a[@href='/purchase/46703']"));
        selectTime.click();
    }
}
