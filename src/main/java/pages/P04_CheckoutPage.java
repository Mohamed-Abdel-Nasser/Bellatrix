package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LOGGER.LogManager;

import java.time.Duration;
import java.util.List;

import static common.PageBase.selectRandomElement;

public class P04_CheckoutPage {

    private static final By FIRST_NAME_TEXTBOX = By.id("billing_first_name");
    private static final By LAST_NAME_TEXTBOX = By.id("billing_last_name");
    private static final By COMPANY_NAME_TEXTBOX = By.id("billing_company");
    private static final By COUNTRY_SELECT_DROPDOWN = By.id("select2-billing_country-container");
    private static final By COUNTRY_SELECTION_OPTION = By.xpath("(//span)[@class='select2-results']/ul/li");
    private static final By ADDRESS1_TEXTBOX = By.id("billing_address_1");
    private static final By ADDRESS2_TEXTBOX = By.id("billing_address_2");
    private static final By CITY_TEXTBOX = By.id("billing_city");
    private static final By STATE_SELECT_DROPDOWN = By.id("select2-billing_state-container");
    private static final By STATE_SELECTION_OPTION = By.xpath("(//span)[@class='select2-results']/ul/li");
    private static final By POSTAL_CODE_TEXTBOX = By.id("billing_postcode");
    private static final By PHONE_TEXTBOX = By.id("billing_phone");
    private static final By EMAIL_TEXTBOX = By.id("billing_email");
    private static final By CREATE_ACCOUNT_CHECKBOX = By.id("createaccount");
    private static final By SUBMIT_ORDER_BUTTON = By.id("place_order");
    private static final By ORDER_COMMENTS_TEXTAREA = By.id("order_comments");

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final LogManager LOGGER = LogManager.getInstance();

    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    public P04_CheckoutPage enterFirstName(String firstName) {
        try {
            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_TEXTBOX));
            firstNameField.sendKeys(firstName);
            LOGGER.info("First name entered: " + firstName);
        } catch (Exception e) {
            String errorMessage = "Failed to enter first name: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterLastName(String lastName) {
        try {
            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_TEXTBOX));
            lastNameField.sendKeys(lastName);
            LOGGER.info("Last name entered: " + lastName);
        } catch (Exception e) {
            String errorMessage = "Failed to enter last name: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterCompanyName(String companyName) {
        try {
            WebElement companyNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(COMPANY_NAME_TEXTBOX));
            companyNameField.sendKeys(companyName);
            LOGGER.info("Company name entered: " + companyName);
        } catch (Exception e) {
            String errorMessage = "Failed to enter company name: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage selectCountry() {
        try {
            WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(COUNTRY_SELECT_DROPDOWN));
            countryDropdown.click();
            List<WebElement> countries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNTRY_SELECTION_OPTION));
            selectRandomElement(countries).click();
            LOGGER.info("Random country selected.");
        } catch (Exception e) {
            String errorMessage = "Failed to select country: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterFirstAddress(String address) {
        try {
            WebElement address1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS1_TEXTBOX));
            address1Field.sendKeys(address);
            LOGGER.info("First address entered: " + address);
        } catch (Exception e) {
            String errorMessage = "Failed to enter first address: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterSecondAddress(String address) {
        try {
            WebElement address2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS2_TEXTBOX));
            address2Field.sendKeys(address);
            LOGGER.info("Second address entered: " + address);
        } catch (Exception e) {
            String errorMessage = "Failed to enter second address: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterCityText(String city) {
        try {
            WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_TEXTBOX));
            cityField.sendKeys(city);
            LOGGER.info("City entered: " + city);
        } catch (Exception e) {
            String errorMessage = "Failed to enter city: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage selectState() {
        try {
            WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(STATE_SELECT_DROPDOWN));
            stateDropdown.click();
            List<WebElement> states = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(STATE_SELECTION_OPTION));
            selectRandomElement(states).click();
            LOGGER.info("Random state selected.");
        } catch (Exception e) {
            String errorMessage = "Failed to select state: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterPostalCode(String postalCode) {
        try {
            WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(POSTAL_CODE_TEXTBOX));
            postalCodeField.sendKeys(postalCode);
            LOGGER.info("Postal code entered: " + postalCode);
        } catch (Exception e) {
            String errorMessage = "Failed to enter postal code: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterPhoneNumber(String phone) {
        try {
            WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_TEXTBOX));
            phoneField.sendKeys(phone);
            LOGGER.info("Phone number entered: " + phone);
        } catch (Exception e) {
            String errorMessage = "Failed to enter phone number: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage enterEmailAddress(String email) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_TEXTBOX));
            emailField.sendKeys(email);
            LOGGER.info("Email address entered: " + email);
        } catch (Exception e) {
            String errorMessage = "Failed to enter email address: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage selectCreateAccount() {
        try {
            WebElement createAccountCheckbox = wait.until(ExpectedConditions.elementToBeClickable(CREATE_ACCOUNT_CHECKBOX));
            createAccountCheckbox.click();
            LOGGER.info("Create account checkbox selected.");
        } catch (Exception e) {
            String errorMessage = "Failed to select 'Create Account': " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage addComment(String comment) {
        try {
            WebElement commentField = wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_COMMENTS_TEXTAREA));
            commentField.sendKeys(comment);
            LOGGER.info("Order comment added: " + comment);
        } catch (Exception e) {
            String errorMessage = "Failed to add comment: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }

    public P04_CheckoutPage placeOrder() {
        try {
            WebElement submitOrderButton = wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_ORDER_BUTTON));
            submitOrderButton.click();
            LOGGER.info("Order placed successfully.");
        } catch (Exception e) {
            String errorMessage = "Failed to place order: " + e.getMessage();
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
        return this;
    }
}
