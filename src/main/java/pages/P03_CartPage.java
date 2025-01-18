package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LOGGER.LogManager;

import java.time.Duration;

public class P03_CartPage {
    private static final By ITEM_QUANTITY = By.xpath("(//input)[@title='Qty']");
    private static final By UPDATE_CART = By.name("update_cart");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("(//div)[@class='wc-proceed-to-checkout']/a");
    protected final WebDriver driver;
    private final WebDriverWait wait;
    private final LogManager LOGGER = LogManager.getInstance();

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        LOGGER.info("P03_CartPage initialized with WebDriver.");
    }

    public P03_CartPage updateItemQuantity(String quantity) {
        try {
            WebElement quantityField = wait.until(ExpectedConditions.elementToBeClickable(ITEM_QUANTITY));
            quantityField.clear();
            quantityField.sendKeys(quantity);
            String successMessage = "Item quantity updated to: " + quantity;
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to update item quantity: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P03_CartPage updateCart() {
        try {
            WebElement updateCartButton = wait.until(ExpectedConditions.elementToBeClickable(UPDATE_CART));
            updateCartButton.click();
            String successMessage = "Cart updated successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to update cart: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public void proceedToCheckout() {
        try {
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_CHECKOUT));
            checkoutButton.click();
            String successMessage = "Proceeded to checkout successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to proceed to checkout: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
