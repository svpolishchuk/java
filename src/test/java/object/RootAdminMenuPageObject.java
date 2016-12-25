package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.RootAdminMenuPage.LOGOUT;
import static object.TestBase.click;
import static object.TestBase.waitElementPresent;

/**
 * Created by polis on 25.12.2016.
 */
public class RootAdminMenuPageObject extends PageObject{

    public RootAdminMenuPageObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, LOGOUT.by(), wait);
    }

    public void clickLogout() {
        click(driver, LOGOUT.by());
    }
}
