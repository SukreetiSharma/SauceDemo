package Pagefactory;

import Pages.AddProductToCart;
import Pages.CheckoutPage;
import Pages.Verification;
import org.openqa.selenium.WebDriver;
import Pages.LoginPage ;

public class PageFactory {
    public static WebDriver driver;
    public LoginPage loginPage ;
    public AddProductToCart addToCart;
    public CheckoutPage checkoutPage;
    public Verification verify;

    public PageFactory(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getUserAbleToLogin(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AddProductToCart getaddProduct(){
        if(addToCart == null){
            addToCart = new AddProductToCart(driver);
        }
        return addToCart;
    }

    public CheckoutPage getCheckoutDetails(){
        if(checkoutPage == null){
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

    public Verification getOrderVerification(){
        if(verify == null){
            verify = new Verification(driver);
        }
        return verify;
    }
}
