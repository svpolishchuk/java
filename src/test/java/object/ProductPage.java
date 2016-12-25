package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.HeaderPage.COUNT_ITEMS_INTO_CART;
import static maps.ProductPage.*;
import static object.TestBase.*;

/**
 * Created by polis on 25.12.2016.
 */
public class ProductPage extends PageObject {

    public ProductPage(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, HEADER_PAGE.by(), wait);
    }

    public String getProductName() {
        return getAttribute(driver, HEADER_PAGE.by(), "textContent");
    }

    public void addToCartProduct(String size) {
        if(isElementPresent(driver,PRODUCT_SIZE.by())) {
            selectProductSize(size);
        }
        click(driver, PRODUCT_ADD_TO_CART_BTN.by());
    }

    public boolean waitChangeCountInCart() {
        int count = Integer.parseInt(getAttribute(driver, COUNT_ITEMS_INTO_CART.by(), "textContent")) + 1;
        return waitTextToPresentInElement(COUNT_ITEMS_INTO_CART.by(), wait, ""+count);
    }

    public void selectProductSize(String size){
        click(driver,PRODUCT_SIZE.by());
        Select dropdown = new Select(driver.findElement(PRODUCT_SIZE.by()));
        dropdown.selectByVisibleText(size);

    }
}
