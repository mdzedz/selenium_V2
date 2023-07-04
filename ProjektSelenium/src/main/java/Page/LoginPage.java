package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By usernameLocator = By.cssSelector("input[data-test='username']");
    private By passwordLocator = By.cssSelector("input[data-test='password']");
    private By buttonLocator = By.cssSelector("input[data-test='login-button']");
    private By checkoutButtonLocator = By.xpath("//*[@id='checkout']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WebElement usernameInput = findElement(usernameLocator);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = findElement(passwordLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = findElement(buttonLocator);
        loginButton.click();
    }

    public void clickCheckoutButtonLogin() {
        WebElement checkoutButton = findElement(checkoutButtonLocator);
        checkoutButton.click();
    }
}

