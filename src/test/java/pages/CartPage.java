package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

public class CartPage {

    private WebDriver driver = WebDriverFactory.getDriver();

    // Elements
    private By cartProducts = By.cssSelector(".cart_item");
    private By checkoutButton = By.id("checkout");

    // Actions
    // Verifies that the cart page is displayed
    public boolean isCartPageDisplayed() {
        return driver.getTitle().contains("Your Cart");
    }

    // Verifies that the correct products are in the cart
    public boolean verifyProductsInCart() {
        List<WebElement> productsInCart = driver.findElements(cartProducts);
        return productsInCart.size() == 2; // Adjust according to the number of products you expect
    }

    // Click the checkout button
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}

