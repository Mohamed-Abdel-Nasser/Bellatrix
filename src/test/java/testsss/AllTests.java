package testsss;

import TestBase.TestBase;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_ItemDetailsPage;
import pages.P03_CartPage;
import pages.P04_CheckoutPage;
import util.Utility;

public class AllTests extends TestBase {

    private Utility utility;
    private P01_HomePage homePage;
    private Faker faker;
    private static final String ORDER_COMMENT = "Need it quickly";

    @BeforeMethod
    public void setUp() {
        utility = new Utility();
        homePage = new P01_HomePage(driver);
    }

    @Test(priority = 1, description = "Add item to the shopping cart")
    public void addItemToCart() {
        homePage.clickAddToCart();
    }

    @Test(priority = 2, description = "Enter item details on the product page")
    public void enterItemDetails() {
        homePage.enterItemDetails();
    }

    @Test(priority = 3, description = "Navigate to the cart page")
    public void enterCartPage() {
        homePage.openCartPage();
    }

    @Test(priority = 4, description = "Add item to cart from item details page")
    public void addItemToCartFromItemDetails() throws InterruptedException {
        homePage.enterItemDetails();
        new P02_ItemDetailsPage(driver)
                .setQuantity(10)
                .clickAddToCart();
    }

    @Test(priority = 5, description = "Update item quantity in the cart and proceed to checkout")
    public void updateCart() {
        new P03_CartPage(driver)
                .updateItemQuantity("5")
                .updateCart()
                .proceedToCheckout();
    }

    @Test(priority = 6, description = "Submit the order with user details")
    public void submitOrder() {
        faker = new Faker();

        new P04_CheckoutPage(driver)
                .enterFirstName(faker.name().firstName())
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
                .addComment(ORDER_COMMENT)
                .placeOrder();
    }
}
