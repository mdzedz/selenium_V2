import Page.CartPage;
import Page.CheckoutPage;
import Page.LoginPage;
import Page.ProductsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class CartFeatureTest {
    private WebDriver driver;
    private String baseURL;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
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
    public void testAddProductToCart() {
        // Add backpack to the cart
        productsPage.addToCart("backpack");

        // Check that there is 1 element in the cart
        assertTrue(productsPage.isAddedToCart());

        // Navigate to the cart
        productsPage.navigateToCart();

        // Check that the cart has been opened
        assertEquals("Your Cart", cartPage.getTitle());

        // Check that the element is in the cart
        assertEquals("1", cartPage.getCartQuantity());
        assertEquals("Sauce Labs Backpack", cartPage.getItemName());
    }

    @Test
    public void testAddAndRemoveProductFromCart(){
        // Add backpack to the cart
        productsPage.addToCart("backpack");
        // Check that there is 1 element in the cart
        assertTrue(productsPage.isAddedToCart());
        // Check that the button shows 'remove' statement
        assertEquals("Remove", productsPage.getTextFromBackpackButton());
        // Remove backpack from the cart
        cartPage.removeItem("backpack");
        // Check that the element is no longer in the cart
       assertFalse(cartPage.isElementPresent(cartPage.getShoppingCartBadgeLocator()));
    }

    @Test
    public void testAddAndDeleteProductFromCart() throws InterruptedException {
        // Add backpack to the cart
        productsPage.addToCart("backpack");

        Thread.sleep(2000);

        // Check that there is an element in the cart
        assertTrue(productsPage.isAddedToCart());

        Thread.sleep(2000);

        // Navigate to the cart
        productsPage.navigateToCart();

        Thread.sleep(2000);

        // Check that the cart has been opened
        assertEquals("Your Cart", cartPage.getTitle());

        Thread.sleep(2000);

        // Check that the element is in the cart
        assertEquals("1", cartPage.getCartQuantity());
        assertEquals("Sauce Labs Backpack", cartPage.getItemName());

        Thread.sleep(2000);

        // Remove item from the cart
        cartPage.removeItem("Sauce Labs Backpack");

        Thread.sleep(2000);

        // Check that the element is no longer in the cart
        Assertions.assertTrue(cartPage.isElementPresent(cartPage.getShoppingCartBadgeLocator()));
    }

    @Test
    public void testAddMultipleProductsToCart() {
        // Add backpack to the cart
        productsPage.addToCart("backpack");

        // Check that there is an element in the cart
        assertTrue(productsPage.isAddedToCart());

        // Check that there is 1 element in the cart
        assertEquals("1", productsPage.getCartItemsAmount());

        // Add the second item to the cart
        productsPage.addToCart("bike-light");

        // Check that there are 2 elements in the cart
        assertEquals("2", productsPage.getCartItemsAmount());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
