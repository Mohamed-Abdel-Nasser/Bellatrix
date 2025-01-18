package TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.LOGGER.LogManager; // Assuming LogManager is your custom logger class

import java.time.Duration;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {
    public static WebDriver driver; // Use `protected` for better extensibility in subclasses.
    private static final LogManager LOGGER = LogManager.getInstance(); // Initialize the logger.

    @BeforeTest
    public void setupWebDriver() {
        try {
            // Initialize WebDriver and set it in DriverHolder.
            setDriver(getNewInstance(""));
            driver = getDriver();

            // Configure WebDriver settings.
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            // Open the target URL.
            driver.get("https://demos.bellatrix.solutions/");

            // Log success message
            String successMessage = "WebDriver initialized and navigated to https://demos.bellatrix.solutions/";
            LOGGER.info(successMessage);
        } catch (Exception e) {
            String errorMessage = "Error during WebDriver setup: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                LOGGER.info("WebDriver closed successfully.");
            }
        } catch (Exception e) {
            String errorMessage = "Error during WebDriver teardown: " + e.getMessage();
            LOGGER.error(errorMessage);
        }
    }
}
