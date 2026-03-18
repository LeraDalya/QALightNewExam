package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private String BASE_URL = "https://flowers.ua";

    private By promoCategory = By.xpath("//a[@title='Акційні букети']");
    private By firstProduct = By.xpath("//span[@title='Букет \"Attraction of Love\"']");
    private By promoTitle = By.xpath("//h1"); // заголовок сторінки
    private By searchInput = By.xpath("//input[@type='search']");
    private By searchButton = By.xpath("//button[contains(@class,'search')]");
    private By noResultsText = By.xpath("//*[contains(text(),'нічого не знайдено') or contains(text(),'Нічого не знайдено')]");

    public void openHomePage() {
        openUrl(BASE_URL);
    }

    public void openPromoCategory() {
        webDriver.get(BASE_URL + "/ua/promo");
    }

    public void clickFirstProduct() {
        webDriver.findElement(firstProduct).click();
    }

    public boolean isPromoPageOpened() {
        return webDriver.findElement(promoTitle).isDisplayed();
    }

    public void searchForProduct(String text) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(text);

        webDriver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public boolean isNoResultsMessageDisplayed() {
        return webDriver.getPageSource().toLowerCase().contains("не знайдено");
    }

}