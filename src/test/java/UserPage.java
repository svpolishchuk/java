import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static maps.UserMenu.*;
import static maps.HomePage.*;

/**
 * Created by polis on 24.12.2016.
 */
public class UserPage extends TestBase{

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserPage(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean loginFormIsPresent() {
        return isElementPresent(driver, FORM_TITLE.by());
    }

    public void typeEmail(final String email) {
        typeText(driver, EMAIL.by(), email);
    }

    public void typePassword(final String password) {
        typeText(driver, PASSWORD.by(), password);
    }

    public void rememberMy(boolean flag) {
        if (isChecked(driver, REMEMBER_ME.by()) && !flag) {
            click(driver, REMEMBER_ME.by());
        } else if (!isChecked(driver, REMEMBER_ME.by()) && flag) {
            click(driver, REMEMBER_ME.by());
        }
    }

    public void clickLoginBtn() {
        click(driver, LOGIN_BUTTON.by());
    }

    public void clickNewCustomerLink() {
        click(driver, NEW_CUSTOMER_LINK.by());
    }

    public String getSuccessMessage() {
        if (waitElementPresent(driver, SUCCESS_MESSAGE.by(), wait)) {
            return getText(driver, SUCCESS_MESSAGE.by());
        } else {
            return "";
        }
    }

    public void doLogout() {
        click(driver, ITEM_MENU_LOGOUT.by());
    }

    public void gotoHomePage() {
        click(driver, HOME_LINK.by());
    }
}
