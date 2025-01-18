package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class PageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class); // Logger instance
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        LOGGER.info("PageBase initialized with WebDriver.");
    }

    public static WebElement selectRandomElement(List<WebElement> elements) {
        try {
            if (elements == null || elements.isEmpty()) {
                LOGGER.warn("The provided list of elements is null or empty.");
                throw new IllegalArgumentException("Element list cannot be null or empty.");
            }

            Random random = new Random();
            int index = random.nextInt(elements.size());
            LOGGER.info("Selected random element at index: {} out of {} elements.", index, elements.size());
            return elements.get(index);
        } catch (Exception e) {
            LOGGER.error("Error selecting a random element: {}", e.getMessage(), e);
            throw e;
        }
    }
}
