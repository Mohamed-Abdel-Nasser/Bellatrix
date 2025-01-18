package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LOGGER.LogManager;

import java.time.Duration;

public class P01_HomePage {
    private static final By ADD_TO_CART = By.xpath("(//a)[text()='Add to cart']");
    private static final By ITEM_DETAILS = By.xpath("(//a)[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']");
    private static final By CART_PAGE = By.xpath("(//a)[text()='Cart']");
    private final WebDriverWait wait;
    private final WebDriver driver;
    private final LogManager LOGGER = LogManager.getInstance();

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        LOGGER.info("P01_HomePage initialized with WebDriver.");
    }

    public void clickAddToCart() {
        try {
            LOGGER.info("Waiting for 'Add to Cart' button to be clickable.");
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART));
            addToCartButton.click();
            String successMessage = "'Add to Cart' button clicked successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to click 'Add to Cart' button: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public void enterItemDetails() {
        try {
            LOGGER.info("Waiting for item details elements to be present.");
            WebElement item = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ITEM_DETAILS)).get(1);
            item.click();
            String successMessage = "Item details viewed successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to view item details: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public void openCartPage() {
        try {
            LOGGER.info("Waiting for 'Cart' page link to be clickable.");
            WebElement cartPageLink = wait.until(ExpectedConditions.elementToBeClickable(CART_PAGE));
            cartPageLink.click();
            String successMessage = "Navigated to the 'Cart' page successfully.";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Failed to navigate to the 'Cart' page: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

}
