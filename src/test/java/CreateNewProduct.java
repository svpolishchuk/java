
import object.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by polis on 25.12.2016.
 */
public class CreateNewProduct extends TestBase{
    private static final String productName = "Test Product 1";

    public void CreateNewProduct() {
        LoginAdminObject login = new LoginAdminObject(driver, wait);
        AdminMenuObject menu = new AdminMenuObject(driver, wait);
        CatalogPageObject catalog = new CatalogPageObject(driver, wait);
        AddNewProductObject product = new AddNewProductObject(driver, wait);
        RootAdminMenuObject rootMenu = new RootAdminMenuObject(driver, wait);

        assertTrue(login.loginAdminFormIsPresent());
        login();

        assertTrue(menu.isAdminMenuPresent());
        menu.ClickMenuSubitemByName("Catalog", "Catalog");

        assertTrue(catalog.catalogPageIsPresent());
        catalog.clickAddNewProductBtn();
        assertTrue(product.addNewProductPageIsPresent());

        product.selectTabByName("General");
        assertTrue(product.generalTabIsPresent());

        product.setStatus(true);
        product.typeName(CreateNewProduct.productName);
        product.typeCode("new code product");
        product.checkCategory(false, "");
        product.checkCategory(true, "Subcategory");
        assertTrue(product.selectDefaultCategory("Subcategory"));
        product.checkGender(true, "Unisex");
        product.typeQuantity(10);
        assertTrue(product.selectQuantityUnit("pcs"));
        assertTrue(product.selectDeliveryStatus("3-5 days"));
        assertTrue(product.selectSoldOutStatus("Temporary sold out"));
        product.typeUploadImage("D:/viber image 2.jpg");
        product.typeDateValidFrom("01.01.2016");
        product.typeDateValidTo("31.12.2016");

        product.selectTabByName("Information");
        assertTrue(product.informationTabIsPresent());
        assertTrue(product.selectManufacturer("ACME Corp."));
        assertTrue(product.selectSupplier("Amazon"));
        product.typeKeywords("Test, Selenium, TestNG");
        product.typeShortDescription("Test product");
        product.typeDescription("Large description for new product");
        product.typeHeadTitle("Head title for new product");
        product.typeMetaDescription("Meta description");

        product.selectTabByName("Prices");
        assertTrue(product.priceTabIsPresent());
        product.typePurchasePrice(12.45);
        assertTrue(product.selectCurrency("US Dollars"));

        product.setPriceByCurrencyName("USD", 12.45);
        product.setPriceByCurrencyName("RUB", 345.33);
        product.setPriceByCurrencyName("EUR", 10.22);
        product.setPriceByCurrencyName("UAH", 280.25);

        product.clickSave();
        rootMenu.clickLogout();
    }

    @Test
    public void verifyNewProduct() {
        LoginAdminObject login = new LoginAdminObject(driver, wait);
        AdminMenuObject menu = new AdminMenuObject(driver, wait);
        CatalogPageObject catalog = new CatalogPageObject(driver, wait);
        RootAdminMenuObject rootMenu = new RootAdminMenuObject(driver, wait);

        assertTrue(login.loginAdminFormIsPresent());
        login();
        assertTrue(menu.isAdminMenuPresent());
        menu.ClickMenuSubitemByName("Catalog", "Catalog");
        assertTrue(catalog.faindProduct(CreateNewProduct.productName));
        rootMenu.clickLogout();
    }
}
