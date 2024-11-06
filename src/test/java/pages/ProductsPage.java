package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class ProductsPage {

    private WebDriver driver = WebDriverFactory.getDriver();

    // Elements
    private By mostExpensiveProduct1 = By.xpath("//div[@class='inventory_item'][1]"); // Example XPath
    private By mostExpensiveProduct2 = By.xpath("//div[@class='inventory_item'][2]"); // Example XPath
    private By cartButton = By.className("shopping_cart_link");

    // Actions
    public void addMostExpensiveProductsToCart() {
        driver.findElement(mostExpensiveProduct1).click();
        driver.findElement(mostExpensiveProduct2).click();
    }

    public void clickOnCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isProductsPageDisplayed() {
        return driver.getTitle().contains("Products");
    }
}

