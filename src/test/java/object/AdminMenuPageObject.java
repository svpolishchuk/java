package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.AdminMenuPage.*;
import static object.TestBase.*;
import static object.TestBase.waitElementPresent;

/**
 * Created by polis on 25.12.2016.
 */
public class AdminMenuPageObject extends PageObject {

    public AdminMenuPageObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, ADMIN_MENU_ANCHOR.by(), wait);
    }

    public void clickMenuItemByName(final String itemName) {
        WebElement item;
        int countItems = getCountElements(driver, ADMIN_MENU_ITEMS_LI.by());
        for (int i=0; i<countItems; i ++) {
            item = getElementByIndex(driver, ADMIN_MENU_ITEMS_LI.by(), i);
            if (itemName.equals(getText(item, ADMIN_MENU_ITEM_NAME.by()))) {
                click(item, ADMIN_MENU_ITEM_URL.by());
            }
        }
    }

    public void clickMenuSubitemByName(final String itemName, final String subitemName) {
        WebElement item, subItem;
        int countSubItems;
        int countItems = getCountElements(driver, ADMIN_MENU_ITEMS_LI.by());
        for (int i=0; i<countItems; i ++) {
            item = getElementByIndex(driver, ADMIN_MENU_ITEMS_LI.by(), i);
            if (itemName.equals(getText(item, ADMIN_MENU_ITEM_NAME.by()))) {
                click(item, ADMIN_MENU_ITEM_URL.by());
                item = getElement(driver, ADMIN_MENU_ITEM_SELECTED.by());
                countSubItems = getCountElements(item, ADMIN_MENU_SUBMENU_ITEMS_LI.by());
                for (int j=0; j<countSubItems; j++) {
                    item = getElement(driver, ADMIN_MENU_ITEM_SELECTED.by());
                    subItem = getElementByIndex(item, ADMIN_MENU_SUBMENU_ITEMS_LI.by(), j);
                    if (subitemName.equals(getText(subItem, ADMIN_MENU_ITEM_NAME.by()))) {
                        click(subItem, ADMIN_MENU_ITEM_URL.by());
                    }
                }
            }
        }
    }
}
