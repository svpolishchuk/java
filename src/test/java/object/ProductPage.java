package object;

import org.openqa.selenium.By;
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
        return waitElementPresent(driver, HEADER_PAGE_EDIT.by(), wait);
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

    public void selectTabByName(final String tabName) {
        int countTabs = getCountElements(driver, TAB_LIST.by());
        WebElement tab;
        String text;
        for (int i = 0; i < countTabs; i++) {
            tab = getElementByIndex(driver, TAB_LIST.by(), i);
            text = getAttribute(tab, TAB_URL.by(), "textContent");
            if (tabName.equals(text)) {
                click(tab, TAB_URL.by());
            }
        }
    }

    public void clickSave() {
        click(driver, SAVE_BTN.by());
    }

    public void clickCancel() {
        click(driver, CANCEL_BTN.by());
    }

// ----------------------------------- General Tab -----------------------------------

    public boolean generalTabIsPresent() {
        return waitElementPresent(driver, GENERAL_STATUS_ENABLE.by(), wait);
    }

    public void setStatus(boolean enable) {
        if (enable) {
            click(driver, GENERAL_STATUS_ENABLE.by());
        } else {
            click(driver, GENERAL_STATUS_DISABLE.by());
        }
    }

    public void typeName(final String name) {
        typeText(driver, GENERAL_NAME.by(), name);
    }

    public void typeCode(final String code) {
        typeText(driver, GENERAL_CODE.by(), code);
    }

    public void checkCategory(boolean check, final String name) {
        int count = getCountElements(driver, GENERAL_CATEGORY_CHECK_BOX.by());
        WebElement element;
        for (int i = 0; i < count; i++) {
            element = getElementByIndex(driver, GENERAL_CATEGORY_CHECK_BOX.by(), i);
            WebElement categoryName = getElementByIndex(driver, GENERAL_CATEGORY_NAME.by(), i);
            if (name.equals(getAttribute(element, (By) categoryName,"textContent").trim())) {
                if ((isChecked(driver,(By) element) && !check) || (!isChecked(driver,(By) element) && check)) {
                    click(driver,(By) element);
                }
            }
        }
    }

    public boolean selectDefaultCategory(final String value) {
        return selectOptionByName(driver, GENERAL_DEFAULT_CATEGORY.by(), GENERAL_DEF_CATEGORY_OPTION.by(), value);
    }

    public void checkGender(boolean check, final String name) {
        int count = getCountElements(driver, GENERAL_GENDER_CHECK_BOX.by());
        WebElement element;
        for (int i = 0; i < count; i++) {
            element = getElementByIndex(driver, GENERAL_GENDER_CHECK_BOX.by(), i);
            if (name.equals(getAttribute(element,(By) getElementByIndex(driver, GENERAL_GENDER_NAME.by(), i),
                    "textContent").trim())) {
                if ((isChecked(driver,(By) element) && !check) || (!isChecked(driver, (By) element) && check)) {
                    click(driver,(By) element);
                }
            }
        }
    }

    public void typeQuantity(double quantity) {
        typeText(driver, GENERAL_QUANTITY.by(), ""+quantity);
    }

    public boolean selectQuantityUnit(final String value) {
        return selectOptionByName(driver, GENERAL_QUANTITY_UNIT.by(), GENERAL_QUANTITY_UNIT_OPTION.by(), value);
    }

    public boolean selectDeliveryStatus(final String value) {
        return selectOptionByName(driver, GENERAL_DELIVERY_STATUS.by(), GENERAL_DELIVERY_STATUS_OPTION.by(), value);
    }

    public boolean selectSoldOutStatus(final String value) {
        return selectOptionByName(driver, GENERAL_SOLD_OUT_STATUS.by(), GENERAL_SOLD_OUT_STATUS_OPTION.by(), value);
    }

    public void typeUploadImage(final String fileName) {
        typeTextWithoutClear(driver, GENERAL_UPLOAD_IMAGES.by(), fileName);
    }

    public void typeDateValidFrom(final String date) {
        typeTextWithoutClear(driver, GENERAL_DATE_VALID_FROM.by(), date);
    }

    public void typeDateValidTo(final String date) {
        typeTextWithoutClear(driver, GENERAL_DATE_VALID_TO.by(), date);
    }

// --------------------------------- Information Tab ---------------------------------

    public boolean informationTabIsPresent() {
        return waitElementPresent(driver, INFORMATION_MANUFACTURER.by(), wait);
    }

    public boolean selectManufacturer(final String value) {
        return selectOptionByName(driver, INFORMATION_MANUFACTURER.by(),
                INFORMATION_MANUFACTURER_OPTION.by(), value);
    }

    public boolean selectSupplier(final String value) {
        return selectOptionByName(driver, INFORMATION_SUPPLIER.by(), INFORMATION_SUPPLIER_OPTION.by(), value);
    }

    public void typeKeywords(final String keywords) {
        typeText(driver, INFORMATION_KEYWORDS.by(), keywords);
    }

    public void typeShortDescription(final String shordDescription) {
        typeText(driver, INFORMATION_SHORT_DESCRIPTION.by(), shordDescription);
    }

    public void typeDescription(final String description) {
        typeText(driver, INFORMATION_DESCRIPTION.by(), description);
    }

    public void typeHeadTitle(final String headTitle) {
        typeText(driver, INFORMATION_HEAD_TITLE.by(), headTitle);
    }

    public void typeMetaDescription(final String metaDescription) {
        typeText(driver, INFORMATION_META_DESCRIPTION.by(), metaDescription);
    }

// ------------------------------------ Price Tab ------------------------------------
     public boolean priceTabIsPresent() {
        return waitElementPresent(driver, PRICE_PURCHASE_PRICE_VALUE.by(), wait);
    }

    public void typePurchasePrice(double price) {
        typeText(driver, PRICE_PURCHASE_PRICE_VALUE.by(), "" + price);
    }

    public boolean selectCurrency(final String currency) {
        return selectOptionByName(driver, PRICE_CURRENCY_OF_PURCHASE_PRICE.by(),
                PRICE_CURRENCY_OF_PURCHASE_PRICE_OPTION.by(), currency);
    }

    public boolean selectTaxClass(final String taxClass) {
        return selectOptionByName(driver, PRICE_TAX_CLASS.by(), PRICE_TAX_CLASS_OPTION.by(), taxClass);
    }

    public void setPriceByCurrencyName(final String currencyName, double price) {
        int countCurrencyName = getCountElements(driver, PRICE_PRICE.by());
        String name;
        for (int i = 0; i < countCurrencyName; i++) {
            name = getAttribute(driver,(By) getElementByIndex(driver, PRICE_PRICE_CURRENCY_NAME.by(), i), "textContent");
            if (name.equals(currencyName)) {
                typeText(driver, (By) getElementByIndex(driver, PRICE_PRICE.by(), i), "" + price);
            }
        }
    }

    public void setPriceInclTaxByCurrencyName(final String currencyName, double price) {
        int countCurrencyName = getCountElements(driver, PRICE_PRICE_INCLUDE_TAX.by());
        String name;
        for (int i = 0; i < countCurrencyName; i++) {
            name = getAttribute(driver,(By) getElementByIndex(driver, PRICE_PRICE_CURRENCY_NAME.by(), i), "textContent");
            if (name.equals(currencyName)) {
                typeText(driver, (By) getElementByIndex(driver, PRICE_PRICE_INCLUDE_TAX.by(), i), "" + price);
            }
        }
    }
}
