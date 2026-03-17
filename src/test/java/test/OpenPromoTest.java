package test;

import baseTest.BaseTest;
import org.junit.Test;

public class OpenPromoTest extends BaseTest {

    @Test
    public void openPromoCategoryTest() {
        pageProvider.getHomePage().openPromoCategory();
    }
}