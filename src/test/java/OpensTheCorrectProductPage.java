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


/**
 * Created by polis on 23.12.2016.
 */
public class OpensTheCorrectProductPage extends TestBase {

    @Test
    public void OperationYellowDuck() {
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

            assertEquals("rgba(119, 119, 119, 1)",getElementColor(driver, COM_PRODUCT_REG_PRICE.by()));
            assertEquals("14.4px", getElementFontSize(product, COM_PRODUCT_REG_PRICE.by()));
            assertEquals("line-through",getElementTextDecoration(product, COM_PRODUCT_REG_PRICE.by()));

            camPrice1 = getAttribute(product, COM_PRODUCT_CAM_PRICE.by(), "textContent");

            assertEquals("rgba(204, 0, 0, 1)", getElementColor(driver, COM_PRODUCT_CAM_PRICE.by()));
            assertEquals("18px", getElementFontSize(product, COM_PRODUCT_CAM_PRICE.by()));
            assertEquals("bold", getElementFontWeight(product, COM_PRODUCT_CAM_PRICE.by()));

            click(product, COM_PRODUCT_HREF.by());

            assertTrue(isElementPresent(driver, PRODUCT_NAME.by()));
            name2 = getAttribute(driver, PRODUCT_NAME.by(), "textContent");
            regPrice2 = getAttribute(driver, PRODUCT_REG_PRICE.by(), "textContent");

            assertEquals("PRODUCT_REG_PRICE color is nod GREY", "rgba(102, 102, 102, 1)",getElementColor(driver, PRODUCT_REG_PRICE.by()));
            assertEquals("PRODUCT_REG_PRICE font size is not 16px","16px", getElementFontSize(driver, PRODUCT_REG_PRICE.by()));
            assertEquals("PRODUCT_REG_PRICE isn't line-through","line-through", getElementTextDecoration(driver, PRODUCT_REG_PRICE.by()));

            camPrice2 = getAttribute(driver, PRODUCT_CAM_PRICE.by(), "textContent");

            assertEquals( "PRODUCT_CAM_PRICE color is not RED","rgba(204, 0, 0, 1)",getElementColor(driver, PRODUCT_CAM_PRICE.by()));
            assertEquals( "PRODUCT_CAM_PRICE font size is not 22px","22px",getElementFontSize(driver, PRODUCT_CAM_PRICE.by()));
            assertEquals("PRODUCT_CAM_PRICE is not BOLD","bold", getElementFontWeight(driver, PRODUCT_CAM_PRICE.by()));

            assertEquals("Product name is not equals",name1, name2 );
            assertEquals("Regular price is not equals",regPrice1, regPrice2 );
            assertEquals("Campaing price is not equals",camPrice1, camPrice2 );

            System.out.println(name1 + " <===> " + name2);
            System.out.println(regPrice1 + " <===> " + regPrice2);
            System.out.println(camPrice1 + " <===> " + camPrice2);

            driver.navigate().back();
        }
    }
}
