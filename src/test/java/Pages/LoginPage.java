package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By Username = By.xpath("//input[@name='user-name']");
    By Password = By.xpath("//input[@name='password']");
    By Login = By.xpath("//input[@name='login-button']");
    By Verify =By.xpath("//span[@class='title']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void loginPage(){
        driver.findElement(Username).sendKeys("standard_user");
        driver.findElement(Password).sendKeys("secret_sauce");
        driver.findElement(Login).click();
        String Actual = driver.findElement(Verify).getText();
        Assert.assertEquals("PRODUCTS",Actual);
    }
}
