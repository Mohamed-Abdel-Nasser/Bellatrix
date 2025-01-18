package TCs;

import TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P04_CheckoutPage;

public class Tc4_checkout extends TestBase {
    private Faker faker = new Faker();
    private String comment = "Need it quickly";
    private P04_CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new P04_CheckoutPage(driver);
    }

    @Test(priority = 6)
    public void submitOrder() {
        checkoutPage.enterFirstName(faker.name().firstName())
                    .enterLastName(faker.name().lastName())
                    .enterCompanyName(faker.company().name())
                    .selectCountry()
                    .enterFirstAddress(faker.address().streetAddress())
                    .enterSecondAddress(faker.address().buildingNumber())
                    .enterCityText(faker.address().city())
                    .selectState()
                    .enterPostalCode(faker.address().zipCode())
                    .enterPhoneNumber(faker.phoneNumber().phoneNumber())
                    .enterEmailAddress(faker.internet().emailAddress())
                    .selectCreateAccount()
                    .addComment(comment)
                    .placeOrder();
    }
}
