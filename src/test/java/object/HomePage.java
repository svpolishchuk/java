package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.MostPopular.*;
import static object.TestBase.*;

/**
 * Created by polis on 25.12.2016.
 */
public class HomePage extends PageObject{

    public HomePage(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, MS_HEADER_SECTION.by(), wait);
    }

    public boolean sectionIsEmpty() {
        int count = getCountElements(driver, MS_PRODUCT_LIST.by());
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean msFindElementByName(final String productName) {
        String name;
        for(int i=0; i<getCountElements(driver, MS_PRODUCT_LIST.by()); i++) {
            name = getAttribute(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i),
                    MS_PRODUCT_NAME.by(), "textContent");
            if (productName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void msClickProductByName(final String productName) {
        String name;
        for(int i=0; i<getCountElements(driver, MS_PRODUCT_LIST.by()); i++) {
            name = getAttribute(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i),
                    MS_PRODUCT_NAME.by(), "textContent");
            if (productName.equals(name)) {
                click(getElementByIndex(driver, MS_PRODUCT_LIST.by(), i), MS_PRODUCT_LINK.by());
            }
        }
    }
}
