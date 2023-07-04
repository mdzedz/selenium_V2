package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void enterText(String text, By locator) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
    }

    protected static void clickElement(By locator) {
        WebElement element = findElement(locator);
        element.click();
    }

    protected String getElementText(By locator) {
        WebElement element = findElement(locator);
        return element.getText();
    }
}
