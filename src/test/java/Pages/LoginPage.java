package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By Username = By.xpath("//input[@name='user-name']");
    By Password = By.xpath("//input[@name='password']");
    By Login = By.xpath("//input[@name='login-button']");
    By Verify =By.xpath("//span[@class='title']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loginPage(){
        driver.findElement(Username).sendKeys("performance_glitch_user");
        driver.findElement(Password).sendKeys("secret_sauce");
        driver.findElement(Login).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Verify));
        String Actual = driver.findElement(Verify).getText();
        Assert.assertEquals("PRODUCTS",Actual);
    }
}
