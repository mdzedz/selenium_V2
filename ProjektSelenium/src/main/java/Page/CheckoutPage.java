package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private static By checkoutButtonLocator = By.cssSelector(".checkout_button");
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By zipCodeLocator = By.id("postal-code");
    private By continueButtonLocator = By.cssSelector(".cart_button");
    private By finishButtonLocator = By.cssSelector(".cart_button");
    private By orderCompletionMessageLocator = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static void clickCheckoutButton() {
        clickElement(checkoutButtonLocator);
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        enterText(firstName, firstNameLocator);
        enterText(lastName, lastNameLocator);
        enterText(zipCode, zipCodeLocator);
    }

    public void clickContinueButton() {
        clickElement(continueButtonLocator);
    }

    public void clickFinishButton() {
        clickElement(finishButtonLocator);
    }

    public String getOrderCompletionMessage() {
        return getElementText(orderCompletionMessageLocator);
    }
}
