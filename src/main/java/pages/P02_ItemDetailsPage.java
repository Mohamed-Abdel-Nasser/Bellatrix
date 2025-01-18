package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LOGGER.LogManager;

import java.time.Duration;

public class P02_ItemDetailsPage {
    private static final By ITEM_QUANTITY = By.name("quantity");
    private static final By ADD_TO_CART = By.name("add-to-cart");
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final LogManager LOGGER = LogManager.getInstance();

    public P02_ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        LOGGER.info("P02_ItemDetailsPage initialized with WebDriver.");
    }

    public P02_ItemDetailsPage setQuantity(int quantity) {
        try {
            WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(ITEM_QUANTITY));
            quantityField.clear();
            quantityField.sendKeys(String.valueOf(quantity));
            String successMessage = "Item quantity set to: " + quantity;
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to set item quantity: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P02_ItemDetailsPage clickAddToCart() {
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART));
            addToCartButton.click();
            String successMessage = "Item added to cart successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to add item to cart: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }
}
