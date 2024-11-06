package com.saucedemo.StepDefinition;

import com.saucedemo.utils.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.OverviewPage;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class CommonSD {

    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private OverviewPage overviewPage = new OverviewPage();  // Create an instance of OverviewPage
    private final WebDriver driver = WebDriverFactory.getDriver();

    public CommonSD() throws IOException {
    }

    @Given("I visit the login page")
    public void visitLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }


    @When("I enter invalid credentials")
    public void enterInvalidCredentials() {
        loginPage.login("invalid_user", "wrong_password");
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("I enter valid credentials with username {string} and password {string}")
    public void enterValidCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the products page")
    public void verifyProductsPage() {
        assertTrue(productsPage.isProductsPageDisplayed());
    }

    @When("I add the most expensive two products to the cart")
    public void addTwoMostExpensiveProductsToCart() {
        productsPage.addMostExpensiveProductsToCart();
    }

    @When("I click on the cart button")
    public void clickOnCartButton() {
        productsPage.clickOnCart();
    }

    @Then("I should be redirected to the cart page")
    public void verifyCartPage() {
        assertTrue(cartPage.isCartPageDisplayed());
    }

    @Then("I should see the two selected products in the cart")
    public void verifyProductsInCart() {
        assertTrue(cartPage.verifyProductsInCart());
    }

    @When("I click on the Checkout button")
    public void clickOnCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Then("I should be redirected to the checkout page")
    public void verifyCheckoutPage() {
        assertTrue(checkoutPage.isCheckoutPageDisplayed());
    }

    @When("I fill the checkout form with valid details")
    public void fillCheckoutForm() {
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
    }

    @When("I click on the Continue button")
    public void clickOnContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("I should be redirected to the Overview page")
    public void verifyOverviewPage() {
        assertTrue(overviewPage.isOverviewPageDisplayed());
    }

    @Then("I should see the correct items total before taxes")
    public void verifyItemsTotalBeforeTaxes() {
        assertTrue(overviewPage.verifyItemsTotalBeforeTaxes());
    }

    @Then("the URL should be {string}")
    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @When("I click on the Finish button")
    public void clickFinishButton() {
        overviewPage.clickFinishButton();
    }

    @Then("I should see a {string} message")
    public void verifyThankYouMessage(String expectedMessage) {
        assertTrue(checkoutPage.isThankYouMessageDisplayed(expectedMessage));
    }

    @Then("I should see an {string} message")
    public void verifyOrderDispatchedMessage(String expectedMessage) {
        assertTrue(checkoutPage.isOrderDispatchedMessageDisplayed(expectedMessage));
    }
}
