import object.*;
import org.junit.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
/**
 * Created by polis on 25.12.2016.
 */
public class CheckBrowserLog extends TestBase {

    @Test
    public void verifyBrowserLog() {
        LoginAdminPageObject login = new LoginAdminPageObject(driver, wait);
        AdminMenuPageObject admin = new AdminMenuPageObject(driver, wait);
        RootAdminMenuPageObject root = new RootAdminMenuPageObject(driver, wait);
        CatalogPage catalog = new CatalogPage(driver, wait);
        ProductPage product = new ProductPage(driver, wait);

        driver.get("http://localhost/litecart/admin/login.php");
        assertTrue(login.pageIsPresent());
        login();
        assertTrue(admin.pageIsPresent());
        admin.clickMenuItemByName("Catalog");
        assertTrue(catalog.pageIsPresent());
        catalog.openAllCategories();

        for (int i=0; i<catalog.getCountProduct(); i++) {
            catalog.openProductPageByIndex(i);
            assertTrue(product.pageIsPresent());
            assertFalse(isContainsMsgErrorLevel(getBrowserLog()));
            product.clickCancel();
            assertTrue(catalog.pageIsPresent());
        }

        root.clickLogout();
        assertTrue(login.pageIsPresent());
    }

    private boolean isContainsMsgErrorLevel(LogEntries entries) {
        /*
			SEVERE (highest value)
			WARNING
			INFO
			CONFIG
			FINE
			FINER
			FINEST (lowest value)
		*/
        for (LogEntry entry : entries.getAll()) {
            if (entry.getLevel().getName().equals("SEVERE") ||
                    entry.getLevel().getName().equals("WARNING")) {
                return true;
            }
        }
        return false;
    }
}
