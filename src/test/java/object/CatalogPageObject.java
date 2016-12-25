package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.CatalogPage.*;

/**
 * Created by polis on 25.12.2016.
 */
public class CatalogPageObject extends TestBase {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CatalogPageObject(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean catalogPageIsPresent() {
        return waitElementPresent(driver, HEADER_PAGE.by(), wait);
    }

    public void clickAddNewCategoryBtn() {
        click(driver, ADD_NEW_CATEGORY_BTN.by());
    }

    public void clickAddNewProductBtn() {
        click(driver, ADD_NEW_PRODUCT_BTN.by());
    }

    public boolean faindProduct(final String productName) {
        int count;
        String text;
        boolean flag = true;
        WebElement element;
        while (flag) {
            flag = false;
            count = getCountElements(driver, CATALOG_TREE_ROW.by());
            for (int i=0; i<count; i++) {
                element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
                if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_OPEN_ICON.by())) {
                    continue;
                } else if (isElementPresent(element, CATALOG_TREE_ROW_GROUP_CLOSE_ICON.by())) {
                    click(element, CATALOG_TREE_ROW_GROUP_LINK.by());
                    flag = true;
                    break;
                } else {
                    text = getAttribute(element,
                            CATALOG_TREE_ROW_PRODUCT_LINK.by(), "textContent");
                    if (productName.equals(text)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
