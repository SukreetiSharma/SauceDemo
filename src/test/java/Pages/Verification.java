package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Verification {
    WebDriver driver;
    WebDriverWait wait;
    By Verify = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");
    By BackToHomePage = By.xpath("//button[@name='back-to-products']");
    By Menu = By.xpath("//button[contains(text(),'Open Menu')]");
    By Logout = By.xpath("//a[contains(text(),'Logout')]");

    public Verification(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void VerifyProductOrder(){
        String actual = driver.findElement(Verify).getText();
        Assert.isTrue(actual.equals("THANK YOU FOR YOUR ORDER"), "Expected result does not match with actual result");
        driver.findElement(BackToHomePage).click();
        driver.findElement(Menu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Logout));
        driver.findElement(Logout).click();
    }
}