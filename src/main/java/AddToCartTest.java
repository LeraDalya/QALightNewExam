import baseTest.BaseTest;
import libs.PageProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    private WebDriver driver;
    private PageProvider pageProvider;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        pageProvider = new PageProvider(driver);
    }

    @Test
    public void addProductToCartTest() {
        HomePage homePage = pageProvider.getHomePage();
        homePage.openPromoCategory();
        homePage.clickFirstProduct();

        ProductPage productPage = pageProvider.getProductPage();
        productPage.clickAddToCartButton();

        productPage.verifyProductAddedToCart();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
