import Page.LoginPage;
import Page.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testStandardUserLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Products", productsPage.getTitle());
    }

    @Test
    public void testProblemUserLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("problem_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Products", productsPage.getTitle());
    }

    @Test
    public void testPerformanceUserLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Products", productsPage.getTitle());
    }

    @Test
    public void testLoginWithoutCredentials() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        assertEquals("Epic sadface: Username is required", errorMessage);
    }

    @Test
    public void testLoginWithoutPassword() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        assertEquals("Epic sadface: Password is required", errorMessage);
    }

    @Test
    public void testLoginWithoutUsername() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        assertEquals("Epic sadface: Username is required", errorMessage);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
