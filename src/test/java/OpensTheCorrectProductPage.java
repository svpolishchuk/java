import org.junit.Test;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import static maps.CompaingProductPage.COM_PRODUCT_LIST;
import static maps.CompaingProductPage.COM_PRODUCT_HREF;
import static maps.CompaingProductPage.COM_PRODUCT_NAME;
import static maps.CompaingProductPage.COM_PRODUCT_REG_PRICE;
import static maps.CompaingProductPage.COM_PRODUCT_CAM_PRICE;
import static maps.ProductPage.PRODUCT_CAM_PRICE;
import static maps.ProductPage.PRODUCT_NAME;
import static maps.ProductPage.PRODUCT_REG_PRICE;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


/**
 * Created by polis on 23.12.2016.
 */
public class OpensTheCorrectProductPage extends TestBase {
    @Test
    public void operationYellowDuck() {
        driver.get("http://localhost/litecart/en/");
        assertTrue(isElementPresent(driver, COM_PRODUCT_LIST.by()));
        int countProduct = getCountElements(driver, COM_PRODUCT_LIST.by());
        String name1, name2;
        String regPrice1, regPrice2;
        String camPrice1, camPrice2;
        WebElement product;

        for (int i=0; i<countProduct; i++) {
            assertTrue(isElementPresent(driver, COM_PRODUCT_LIST.by()));
            product = getElementByIndex(driver, COM_PRODUCT_LIST.by(), i);
            name1 = getAttribute(product, COM_PRODUCT_NAME.by(), "textContent");
            regPrice1 = getAttribute(product, COM_PRODUCT_REG_PRICE.by(), "textContent");

            assertEquals(getElementColor(product, COM_PRODUCT_REG_PRICE.by()),
                    "rgba(119, 119, 119, 1)", "");
            assertEquals(getElementFontSize(product, COM_PRODUCT_REG_PRICE.by()),
                    "14.4px", "");
            assertEquals(getElementTextDecoration(product, COM_PRODUCT_REG_PRICE.by()),
                    "line-through");

            camPrice1 = getAttribute(product, COM_PRODUCT_CAM_PRICE.by(), "textContent");

            assertEquals(getElementColor(product, COM_PRODUCT_CAM_PRICE.by()),
                    "rgba(204, 0, 0, 1)", "");
            assertEquals(getElementFontSize(product, COM_PRODUCT_CAM_PRICE.by()),
                    "18px", "");
            assertEquals(getElementFontWeight(product, COM_PRODUCT_CAM_PRICE.by()),
                    "bold");

            click(product, COM_PRODUCT_HREF.by());

            assertTrue(isElementPresent(driver, PRODUCT_NAME.by()));
            name2 = getAttribute(driver, PRODUCT_NAME.by(), "textContent");
            regPrice2 = getAttribute(driver, PRODUCT_REG_PRICE.by(), "textContent");
            assertEquals(getElementColor(driver, PRODUCT_REG_PRICE.by()),
                    "rgba(102, 102, 102, 1)", "PRODUCT_REG_PRICE color is nod GREY");
            assertEquals(getElementFontSize(driver, PRODUCT_REG_PRICE.by()),
                    "16px", "PRODUCT_REG_PRICE font size is not 16px");
            assertEquals(getElementTextDecoration(driver, PRODUCT_REG_PRICE.by()),
                    "line-through", "PRODUCT_REG_PRICE isn't line-through");

            camPrice2 = getAttribute(driver, PRODUCT_CAM_PRICE.by(), "textContent");
            assertEquals(getElementColor(driver, PRODUCT_CAM_PRICE.by()),
                    "rgba(204, 0, 0, 1)", "PRODUCT_CAM_PRICE color is not RED");
            assertEquals(getElementFontSize(driver, PRODUCT_CAM_PRICE.by()),
                    "22px", "PRODUCT_CAM_PRICE font size is not 22px");
            assertEquals(getElementFontWeight(driver, PRODUCT_CAM_PRICE.by()),
                    "bold", "PRODUCT_CAM_PRICE is not BOLD");
            assertEquals(name1, name2, "Product name is not equals");
            assertEquals(regPrice1, regPrice2, "Regular price is not equals");
            assertEquals(camPrice1, camPrice2, "Campaing price is not equals");

            System.out.println(name1 + " <===> " + name2);
            System.out.println(regPrice1 + " <===> " + regPrice2);
            System.out.println(camPrice1 + " <===> " + camPrice2);

            driver.navigate().back();
        }
    }
}
