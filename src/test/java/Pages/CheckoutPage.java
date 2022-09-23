package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    By checkout = By.xpath("//button[@name='checkout']");
    By FirstName = By.xpath("//input[@name='firstName']");
    By LastName = By.xpath("//input[@name='lastName']");
    By Zip = By.xpath("//input[@name='postalCode']");
    By Continue = By.xpath("//input[@name='continue']");
    By Product = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    By Price = By.xpath("//div[@class='inventory_item_price']");
    By Finish = By.xpath("//button[@name='finish']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CheckoutDetails(){
        driver.findElement(checkout).click();
        driver.findElement(FirstName).sendKeys("qwerty");
        driver.findElement(LastName).sendKeys("Singh");
        driver.findElement(Zip).sendKeys("231456");
        driver.findElement(Continue).click();
        String actual = driver.findElement(Product).getText();
        Assert.isTrue(actual.equals("Sauce Labs Backpack"), "Expected result does not match with actual result");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Price));
        String actual1 = driver.findElement(Price).getText();
        Assert.isTrue(actual1.equals("$29.99"), "Expected result does not match with actual result");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Finish));
        driver.findElement(Finish).click();
    }
}
