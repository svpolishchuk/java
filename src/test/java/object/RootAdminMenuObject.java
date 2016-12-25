package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.RootAdminMenuPage.LOGOUT;

/**
 * Created by polis on 25.12.2016.
 */
public class RootAdminMenuObject extends TestBase {

    private final WebDriver driver;

    @SuppressWarnings("unused")
    private final WebDriverWait wait;

    public RootAdminMenuObject(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLogout() {
        click(driver, LOGOUT.by());
    }
}
