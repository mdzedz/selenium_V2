package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class ProductsPage extends BasePage {
    private Map<Select, By> selectMap;
    private By pageTitle = By.cssSelector("span.title");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By cartLink = By.cssSelector(".shopping_cart_link");
    private By backpackButton = By.cssSelector("button[data-test*='backpack']");

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.selectMap = new HashMap<>();
        this.selectMap.put(Select.SORT, By.cssSelector("select.product_sort_container"));
    }

    public String getTitle() {
        WebElement pageTitleElement = findElement(pageTitle);
        return pageTitleElement.getText();
    }

    public void addToCart(String product) {
        String addToCartButtonSelector = "button[data-test*='" + product + "']";
        By addToCartButton = By.cssSelector(addToCartButtonSelector);
        clickElement(addToCartButton);
    }

    public boolean isAddedToCart() {
        WebElement cartBadgeElement = findElement(cartBadge);
        return cartBadgeElement.isEnabled();
    }

    public String getCartItemsAmount() {
        WebElement cartBadgeElement = findElement(cartBadge);
        return cartBadgeElement.getText();
    }

    public void navigateToCart() {
        clickElement(cartLink);
    }

    public String getTextFromBackpackButton() {
        WebElement backpackButtonElement = findElement(backpackButton);
        return backpackButtonElement.getText();
    }

    public enum Select {
        SORT
    }
}
