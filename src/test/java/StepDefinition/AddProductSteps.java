package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import BaseClass.BaseClass;

import java.io.IOException;

public class AddProductSteps extends BaseClass{

    @Given("user is able to login")
    public void user_is_able_to_login() {
        setup();
        obj.getUserAbleToLogin().loginPage();
    }

    @When("user is able to add product")
    public void user_is_able_to_add_product() {
        obj.getaddProduct().addProduct();
    }

    @When("user is able to checkout")
    public void user_is_able_to_checkout() throws IOException {
        obj.getCheckoutDetails().CheckoutDetails();
    }

    @Then("User is able to Buy product Successfully and Logout")
    public void user_is_able_to_buy_product_successfully_and_logout() {
        obj.getOrderVerification().VerifyProductOrder();
        close();
    }

}
