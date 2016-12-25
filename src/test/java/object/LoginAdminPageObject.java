package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.LoginPageMap.*;
import static object.TestBase.*;

/**
 * Created by polis on 25.12.2016.
 */
public class LoginAdminPageObject extends PageObject {

    public LoginAdminPageObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
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
