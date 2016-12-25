package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.LoginPageMap.*;

/**
 * Created by polis on 25.12.2016.
 */
public class LoginAdminObject extends TestBase {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginAdminObject(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean loginAdminFormIsPresent() {
        return waitElementPresent(driver, LOGIN_PAGE_ANCHOR.by(), wait);
    }

    public void typeUserName(final String username) {
        typeText(driver, USERNAME.by(), username);
    }

    public void typeUserPasword(final String userPwd) {
        typeText(driver, PASSWORD.by(), userPwd);
    }

    public void rememberMy(boolean flag) {
        if (isChecked(driver, REMEMBER_ME_CHECK.by()) && !flag) {
            click(driver, REMEMBER_ME_CHECK.by());
        } else if (!isChecked(driver, REMEMBER_ME_CHECK.by()) && flag) {
            click(driver, REMEMBER_ME_CHECK.by());
        }
    }

    public void clickLoginBtn() {
        click(driver, LOGIN_BTN.by());
    }
}
