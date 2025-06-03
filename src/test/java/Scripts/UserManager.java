package Scripts;

import Pages.RegisterPage;
import org.testng.annotations.Test;

public class UserManager extends BaseTest{
    @Test
    public void verifyValidRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.validRegistration("mina","mina@gmail.com","abc123","abc123","0790512345");
    }

    @Test
    public void  verifyEmptyRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerWithEmptyFields();
    }
}
