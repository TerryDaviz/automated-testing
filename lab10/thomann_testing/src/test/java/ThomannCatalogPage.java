import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThomannCatalogPage extends AbstractPage {
        public static final String CATALOG_PAGE_URL = "https://www.thomann.de/gb/guitar_sets.html";

        @FindBy(css = ".consent-button")
        private WebElement acceptCookiesButton;
        @FindBy(css = ".basket-button:first-of-type")
        private WebElement firstAddItemToCartButton;

        public ThomannCatalogPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public ThomannCatalogPage openPage() {
                return (ThomannCatalogPage) openPage(CATALOG_PAGE_URL);
        }
        public ThomannCatalogPage addFirstAvailableItemToCart() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
                acceptCookiesButton.click();
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(firstAddItemToCartButton));
                firstAddItemToCartButton.click();
                return this;
        }
}
