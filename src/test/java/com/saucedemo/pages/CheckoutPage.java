package com.saucedemo.pages;

import com.saucedemo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver = WebDriverFactory.getDriver();

    // Elements
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By overviewPageTitle = By.className("title");
    private By itemsTotalBeforeTaxes = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");
    private By thankYouMessage = By.className("complete-header");
    private By orderDispatchedMessage = By.className("complete-text");

    // Actions
    // Verify that the checkout page is displayed
    public boolean isCheckoutPageDisplayed() {
        return driver.getTitle().contains("Checkout");
    }

    // Fill out the checkout form with first name, last name, and postal code
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    // Click the "Continue" button
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    // Verify that the Overview page is displayed
    public boolean isOverviewPageDisplayed() {
        return driver.findElement(overviewPageTitle).getText().contains("Checkout: Overview");
    }

    // Verify that the items total before taxes is correct
    public boolean verifyItemsTotalBeforeTaxes() {
        String totalLabel = driver.findElement(itemsTotalBeforeTaxes).getText();
        return totalLabel.contains("Item total:");
    }

    // Click the "Finish" button
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    // Verify the "Thank You" message is displayed after successful checkout
    public boolean isThankYouMessageDisplayed(String message) {
        return driver.findElement(thankYouMessage).getText().contains(message);
    }

    // Verify the "Order has been dispatched" message
    public boolean isOrderDispatchedMessageDisplayed(String message) {
        return driver.findElement(orderDispatchedMessage).getText().contains(message);
    }
}

