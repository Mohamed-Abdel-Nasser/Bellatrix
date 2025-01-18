package TCs;

import TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import util.Utility;

public class Tc1_home extends TestBase {

    protected Utility utility;
    private P01_HomePage homePage;

    @BeforeMethod
    public void setObject() {
        utility = new Utility();
        homePage = new P01_HomePage(driver);
    }

    @Test(priority = 1)
    public void addItemToCart() {
        homePage.clickAddToCart();
    }

    @Test(priority = 2)
    public void enterItemDetails() {
        homePage.enterItemDetails();
    }

    @Test(priority = 3)
    public void openCartPage() {
        homePage.openCartPage();
    }
}
