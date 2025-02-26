package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private DriverFactory() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getNewInstance(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome-headless":
                return createChromeDriver(true);

            case "firefox":
                return new FirefoxDriver();

            case "firefox-headless":
                return createFirefoxDriver(true);

            case "edge":
                return new EdgeDriver();

            default:
                return createChromeDriver(false);
        }
    }

    private static WebDriver createChromeDriver(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-debugging-port=9222");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);

        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        if (headless) {
            firefoxBinary.addCommandLineOptions("--headless");
        }
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-dev-shm-usage");

        return new FirefoxDriver(firefoxOptions);
    }
}
