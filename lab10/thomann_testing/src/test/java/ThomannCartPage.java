import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ThomannCartPage extends AbstractPage{
        public static final String CART_PAGE_URL = "https://www.thomann.de/gb/basket.html";

        @FindBy(css = ".delete-action")
        private WebElement removeFirstItemFromCartButton;

        @FindBy(css = ".basket-entry:nth-child(1)")
        private List<WebElement> cartItems;

        public ThomannCartPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public ThomannCartPage openPage() {
                return (ThomannCartPage) openPage(CART_PAGE_URL);
        }

        public ThomannCartPage removeFirstItemFromCart() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(removeFirstItemFromCartButton));
                removeFirstItemFromCartButton.click();
                return this;
        }

        public int countItemsInCart() {
                return cartItems.size();
        }
}