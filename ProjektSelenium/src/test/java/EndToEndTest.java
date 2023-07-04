import Page.CartPage;
import Page.CheckoutPage;
import Page.LoginPage;
import Page.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EndToEndTest {
    private WebDriver driver;
    private String baseURL;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        baseURL = "https://www.saucedemo.com/";
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Perform login before each test
        driver.get(baseURL);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals("Products", productsPage.getTitle());
    }


    @Test
    public void endToEndTest() {

        // Add backpack to the cart
        productsPage.addToCart("backpack");

        // Verify that the item is added to the cart
        assertTrue(productsPage.isAddedToCart());

        // Navigate to the cart
        productsPage.navigateToCart();

        // Verify that the cart has been opened
        assertEquals("Your Cart", cartPage.getTitle());

        // Verify that the added item is in the cart
        assertEquals("1", cartPage.getCartQuantity());
        assertEquals("Sauce Labs Backpack", cartPage.getItemName());

        // Continue to checkout
        checkoutPage.clickCheckoutButton();

        // Fill in checkout information
        String firstName = "John";
        String lastName = "Doe";
        String zipCode = "12345";
        checkoutPage.fillCheckoutInformation(firstName, lastName, zipCode);

        // Complete checkout
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        // Verify the order completion message
        assertEquals("Thank you for your order!", checkoutPage.getOrderCompletionMessage());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
