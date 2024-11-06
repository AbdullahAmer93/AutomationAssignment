package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class ProductsPage {

    private final WebDriver driver = WebDriverFactory.getDriver();

    // Elements
    private By mostExpensiveProduct1 = By.xpath("//div[4]/div[@safeclass~'\\binventory_item_description\\b']");
    private By mostExpensiveProduct2 = By.xpath("//div[1]/div[@safeclass~'\\binventory_item_description\\b']");
    private By cartButton = By.className("btn btn_primary btn_small btn_inventory ");

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

