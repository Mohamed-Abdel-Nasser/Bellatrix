package TCs;

import TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_ItemDetailsPage;

public class Tc2_ItemDetails extends TestBase {

    private P01_HomePage homePage;
    private P02_ItemDetailsPage itemDetailsPage;

    @BeforeMethod
    public void setUp() {
        homePage = new P01_HomePage(driver);
        itemDetailsPage = new P02_ItemDetailsPage(driver);
    }

    @Test(priority = 4)
    public void addItemToCartFromItemDetails() {
        homePage.enterItemDetails();
        itemDetailsPage.setQuantity(10);
        itemDetailsPage.clickAddToCart();
    }
}
