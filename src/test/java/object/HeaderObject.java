package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.HeaderPage.*;
import static object.TestBase.*;


/**
 * Created by polis on 25.12.2016.
 */
public class HeaderObject extends PageObject {

    public HeaderObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, HOME_LINK.by(), wait);
    }

    public void goToHomePage() {
        click(driver, HOME_LINK.by());
    }

    public void checkout() {
        click(driver, CHECKOUT_LINK.by());
    }

    public int getCountItemIntoCart() {
        return Integer.parseInt(getAttribute(driver, COUNT_ITEMS_INTO_CART.by(), "textContent"));
    }
}
