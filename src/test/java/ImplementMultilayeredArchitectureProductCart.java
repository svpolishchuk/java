import maps.HeaderPage;
import object.CartPageObject;
import object.HeaderObject;
import object.HomePage;
import object.ProductPage;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
/**
 * Created by polis on 26.12.2016.
 */
public class ImplementMultilayeredArchitectureProductCart extends TestBase {

        @Test
        public void addPtoductToCart() {
            HomePage home = new HomePage(driver, wait);
            ProductPage product = new ProductPage(driver, wait);
            HeaderObject header = new HeaderObject(driver, wait);
            String [] productNames = {"Yellow Duck", "Purple Duck", "Green Duck", "Blue Duck"};
            header.goToHomePage();

            for (String productName : productNames) {
                assertTrue(home.pageIsPresent());
                assertTrue(home.msFindElementByName(productName));
                home.msClickProductByName(productName);
                assertTrue(product.pageIsPresent());
                assertEquals(productName, product.getProductName());
                product.addToCartProduct();
                assertTrue(product.waitChangeCountInCart());
                header.goToHomePage();
            }
        }

        @Test
        public void removeProductFromCart() {
            HeaderObject header = new HeaderObject(driver, wait);
            CartPageObject cart = new CartPageObject(driver, wait);
            header.checkout();
            cart.deleteAllProducts();
            assertTrue(cart.pageIsPresent());
            assertTrue(cart.deleteAllProducts());
        }
    }