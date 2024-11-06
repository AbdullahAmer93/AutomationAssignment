package com.saucedemo.pages;

import com.saucedemo.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPage {

    private WebDriver driver = WebDriverFactory.getDriver();

    // Elements
    private By overviewTitle = By.className("title");
    private By itemsList = By.cssSelector(".cart_list .cart_item");
    private By itemsTotal = By.className("summary_subtotal_label");
    private By totalBeforeTax = By.className("summary_subtotal_label");
    private By checkoutFinishButton = By.id("finish");

    // Actions
    // Verify the Overview page is displayed
    public boolean isOverviewPageDisplayed() {
        return driver.findElement(overviewTitle).getText().contains("Checkout: Overview");
    }

    // Verify the items displayed on the Overview page
    public boolean verifyItemsInOverview() {
        // Check if the Overview page has the expected number of items (2 for this scenario)
        List<WebElement> items = driver.findElements(itemsList);
        return items.size() == 2; // Adjust this based on the number of items in the cart
    }

    // Verify the total price before taxes
    public boolean verifyItemsTotalBeforeTaxes() {
        WebElement totalElement = driver.findElement(totalBeforeTax);
        String totalLabel = totalElement.getText();
        return totalLabel.contains("Item total:");
    }

    // Get the total amount of items before tax (if needed for further validation)
    public String getItemsTotalBeforeTaxes() {
        WebElement totalElement = driver.findElement(totalBeforeTax);
        return totalElement.getText();
    }

    // Click the "Finish" button to complete the order
    public void clickFinishButton() {
        driver.findElement(checkoutFinishButton).click();
    }
}

