package test;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.ProductPage;

public class OpenPromoTest extends BaseTest {

    @Test
    public void openPromoCategoryAndAddProductTest() {

        HomePage homePage = pageProvider.getHomePage();

        homePage.openPromoCategory();

        Assert.assertTrue("Промо категорія не відкрита",
                homePage.isPromoPageOpened());

        homePage.clickFirstProduct();

        ProductPage productPage = pageProvider.getProductPage();

        productPage.verifyProductPageOpened();

        productPage.clickAddToCartButton();

        productPage.verifyProductAddedToCart();
    }
}