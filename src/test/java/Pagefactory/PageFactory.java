package Pagefactory;

import org.openqa.selenium.WebDriver;
import Pages.LoginPage ;

public class PageFactory {
    WebDriver driver;
    public LoginPage loginPage ;

    public PageFactory(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getUserAbleToLogin(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}
