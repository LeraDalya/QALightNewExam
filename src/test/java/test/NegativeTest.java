package test;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import baseTest.BaseTest;

public class NegativeTest extends BaseTest {

    @Test
    public void negativeTest_invalidPage() {

        HomePage homePage = pageProvider.getHomePage();

        homePage.openHomePage();

        homePage.searchForProduct("asdfghjkl123456");

        Assert.assertTrue("No results message is NOT displayed",
                homePage.isNoResultsMessageDisplayed());
    }
}