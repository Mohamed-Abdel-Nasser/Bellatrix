package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverHolder() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverHolder.driver.set(driver);
    }

    public static void removeDriver() {
        driver.remove();
    }
}
