import maps.HeaderPage;
import object.CartPageObject;
import object.HeaderObject;
import object.HomePage;
import object.ProductPage;
import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.*;


/**
 * Created by polis on 25.12.2016.
 */
public class ProductCart extends TestBase {

    @Test
    public void addPtoductToCart() {
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));
        HomePage home = new HomePage(driver, wait);
        ProductPage product = new ProductPage(driver, wait);
        HeaderObject header = new HeaderObject(driver, wait);
        String [] productNames = {"Yellow Duck", "Purple Duck", "Green Duck", "Blue Duck" };
        header.goToHomePage();

        for (String productName : productNames) {
            assertTrue(home.pageIsPresent());
            assertTrue(home.msFindElementByName(productName));
            home.msClickProductByName(productName);

            assertTrue(product.pageIsPresent());
            assertEquals(productName, product.getProductName());

            product.addToCartProduct("Small");
            assertTrue(product.waitChangeCountInCart());

            header.goToHomePage();
        }

        CartPageObject cart = new CartPageObject(driver, wait);

        header.checkout();
        cart.deleteAllProducts();

        assertTrue(cart.pageIsPresent());
        assertTrue(cart.deleteAllProducts());
    }
}

