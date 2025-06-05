package scripts;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import pages.RegisterPage;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class RegistrationTest extends BaseTest{
    @Test
    public void verifyValidRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.validRegistration("mina","mina5@gmail.com","abc123","abc123","0790512345","12-25-2000");
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
    public void VerifyDOB(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterDOB("05-10-2025");
    }

    @Test
    public void verifyCheckbox (){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.uncheckBox("mina","mina@gmail.com","abc123","abc123","0790512345","12-25-2000");
    }

    @Test
    public void verifyExistingEmail(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.checkExistingEmail("mina","mina@gmail.com","abc123","abc123","0790512345","12-25-2000");
    }
}
