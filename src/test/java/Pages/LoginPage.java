package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public static Properties prop;
    By Username = By.xpath("//input[@name='user-name']");
    By Password = By.xpath("//input[@name='password']");
    By Login = By.xpath("//input[@name='login-button']");
    By Verify =By.xpath("//span[@class='title']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void loginPage(){
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//TestData//Data.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElement(Username).sendKeys(prop.getProperty("UserName"));
        driver.findElement(Password).sendKeys(prop.getProperty("PassWord"));
        driver.findElement(Login).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Verify));
        String Actual = driver.findElement(Verify).getText();
        Assert.assertEquals("PRODUCTS",Actual);
    }
}
