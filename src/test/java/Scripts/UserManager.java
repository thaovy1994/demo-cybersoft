package Scripts;

import Pages.RegisterPage;
import org.testng.annotations.Test;

public class UserManager extends BaseTest{
//    @Test
//    public void verifyLogin(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("0706169114","Cba321#@!");
//    }

    @Test
    public void verifyValidRegistration(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.validRegistration("mina","vy2@gmail.com","abc123","abc123","0790512345");
    }
}
