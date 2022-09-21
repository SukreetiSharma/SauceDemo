package StepDefinition;

import Pagefactory.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import BaseClass.BaseClass;

public class AddProductSteps extends BaseClass{
    WebDriver driver;

    @Given("user is able to login")
    public void login_page(){
        pageFactory.getUserAbleToLogin().loginPage();
    }

    @When("user is able to add product")
    public void addProduct(){

    }

    @And("user is able to checkout")
    public void Checkout(){

    }

    @Then("User is able to Buy product Successfully")
    public void Verify(){

    }

}
