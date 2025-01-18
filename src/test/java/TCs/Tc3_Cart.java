package TCs;

import TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_CartPage;

public class Tc3_Cart extends TestBase {

    private P01_HomePage homePage;
    private P03_CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        homePage = new P01_HomePage(driver);
        cartPage = new P03_CartPage(driver);
    }

    @Test(priority = 5)
    public void updateCart() {
        homePage.openCartPage();
        cartPage.updateItemQuantity("5");
        cartPage.updateCart();
        cartPage.proceedToCheckout();
    }
}
