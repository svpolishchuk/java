package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.CatalogPage.*;
import static object.TestBase.*;

/**
 * Created by polis on 25.12.2016.
 */
public class CatalogPage extends PageObject{

    public CatalogPage(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, HEADER_PAGE.by(), wait);
    }

    public void clickAddNewCategoryBtn() {
        click(driver, ADD_NEW_CATEGORY_BTN.by());
    }

    public void clickAddNewProductBtn() {
        click(driver, ADD_NEW_PRODUCT_BTN.by());
    }

    public boolean findProduct(final String productName) {
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

    public void openAllCategories() {
        int count;
        boolean flag = true;
        WebElement element = null;
        while(flag) {
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
                    continue;
                }
            }
        }
    }

    public int getCountProduct() {
        int count = 0;
        WebElement element = null;
        for (int i=0; i<getCountElements(driver, CATALOG_TREE_ROW.by()); i++) {
            element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
            if (isElementPresent(element, CATALOG_TREE_ROW_PRODUCT_LINK.by())) {
                count++;
            }
        }
        return count;
    }

    public void openProductPageByIndex(int index) {
        int count = 0;
        WebElement element = null;
        for (int i=0; i<getCountElements(driver, CATALOG_TREE_ROW.by()); i++) {
            element = getElementByIndex(driver, CATALOG_TREE_ROW.by(), i);
            if (isElementPresent(element, CATALOG_TREE_ROW_PRODUCT_LINK.by())) {
                if (count == index) {
                    click(element, CATALOG_TREE_ROW_PRODUCT_LINK.by());
                }
                count++;
            }
        }
    }
}
