package Scripts;

import Pages.RegisterPage;
import org.testng.annotations.Test;

public class UserManager extends BaseTest{
    @Test
    public void verifyValidRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.validRegistration("mina","mina@gmail.com","abc123","abc123","0790512345","2000-12-25");
    }

    @Test
    public void  verifyEmptyRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerWithEmptyFields();
    }

    @Test
    public void verifyInvalidNameFormat (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidNameFormat("mina!@#");
    }

    @Test
    public void verifyInvalidEmailFormat (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidEmailFormat("abc@vn");
    }

    @Test
    public void verifyInvalidPassword (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidPassword("abc");
    }

    @Test
    public void verifyInvalidPhone (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.invalidPhone("0123");
    }

    @Test
    public void verifyCheckbox (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.checkBox("mina","mina@gmail.com","abc123","abc123","0790512345","2000-12-25");
    }
}
