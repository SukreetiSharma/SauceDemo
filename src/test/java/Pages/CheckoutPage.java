package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    By checkout = By.xpath("//button[@name='checkout']");
    By FirstName = By.xpath("//input[@name='firstName']");
    By LastName = By.xpath("//input[@name='lastName']");
    By zip = By.xpath("//input[@name='postalCode']");
    By Continue = By.xpath("//input[@name='continue']");
    By Product = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    By Price = By.xpath("//div[@class='inventory_item_price']");
    By Finish = By.xpath("//button[@name='finish']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CheckoutDetails() throws IOException {
        driver.findElement(checkout).click();
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//SauceDemo.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String FName = sheet.getRow(1).getCell(0).getStringCellValue();
        String LName = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(FirstName).sendKeys(FName);
        driver.findElement(LastName).sendKeys(LName);
        driver.findElement(zip).sendKeys("23456677");
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
