package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.CartPage.*;
import static object.TestBase.*;


/**
 * Created by polis on 25.12.2016.
 */
public class CartPageObject extends PageObject {

    public CartPageObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return (waitElementPresent(driver, HEADER_PAGE.by(), wait) ||
                waitElementPresent(driver, CART_IS_EMPTY.by(), wait));
    }

    public boolean deleteAllProducts() {
        int count;
        String productName;
        String productNameInTable;
        WebElement element = null;
        while(isElementPresent(driver, CART_SHORTCUT_FIRST.by())) {
            click(getElement(driver, CART_SHORTCUT_FIRST.by()), CART_SHORTCUT_LINK.by());
            productName = getAttribute(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_NAME.by(), "textContent");
            count = getCountElements(driver, CART_PRODUCT_IN_TABLE.by());
            for (int i=0; i<count; i++) {
                WebElement cartProduct = getElementByIndex(driver, CART_PRODUCT_IN_TABLE.by(), i);
                productNameInTable = getAttribute(driver, (By) cartProduct, "textContent");
                if (productName.equals(productNameInTable)) {
                    element = getElementByIndex(driver, CART_PRODUCT_IN_TABLE.by(), i);
                    break;
                }
            }
            click(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_REMOVE_BTN.by());
            if (!waitElementStaleness(driver, (By) element, wait)) {
                return false;
            }
        }
        if (!isElementPresent(driver, CART_PRODUCT_FIRST.by())) {
            return true;
        }
        productName = getAttribute(getElement(driver, CART_PRODUCT_FIRST.by()),
                CART_PRODUCT_NAME.by(), "textContent");
        productNameInTable = getAttribute(driver, CART_PRODUCT_IN_TABLE.by(), "textContent");
        if (productName.equals(productNameInTable)) {
            element = getElement(driver, CART_PRODUCT_IN_TABLE.by());
        }

        click(getElement(driver, CART_PRODUCT_FIRST.by()), CART_PRODUCT_REMOVE_BTN.by());
        if (!waitElementStaleness(driver,(By)element, wait)) {
            return false;
        }
        return true;
    }
}
