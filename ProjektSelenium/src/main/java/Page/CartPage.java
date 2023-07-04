package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private By titleLocator = By.cssSelector(".title");
    private By cartQuantityLocator = By.cssSelector(".cart_quantity");
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By removeButtonLocator = By.xpath("(//button[normalize-space()='Remove'])[1]");
    private By shoppingCartBadgeLocator = By.xpath("(//div[@class='cart_item'])[1]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebElement pageTitle = findElement(titleLocator);
        return pageTitle.getText();
    }

    public String getCartQuantity() {
        WebElement cartQuantityBadge = findElement(cartQuantityLocator);
        return cartQuantityBadge.getText();
    }

    public String getItemName() {
        WebElement itemName = findElement(itemNameLocator);
        return itemName.getText();
    }

    public String getItemPrice() {
        WebElement itemPrice = findElement(itemPriceLocator);
        return itemPrice.getText();
    }

    public void removeItem(String product) {
        By removeButtonLocator = By.xpath(String.format("(//div[text()='%s']/following-sibling::div/button)[1]", product));
        if (isElementPresent(removeButtonLocator)) {
            WebElement removeButton = findElement(removeButtonLocator);
            removeButton.click();
        }
    }

    public By getShoppingCartBadgeLocator() {
        return shoppingCartBadgeLocator;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}




