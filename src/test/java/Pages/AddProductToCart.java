package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductToCart {
    WebDriver driver;
    By AddToCart = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    By ShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public AddProductToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct() {
        driver.findElement(AddToCart).click();
        driver.findElement(ShoppingCart).click();

    }
}
