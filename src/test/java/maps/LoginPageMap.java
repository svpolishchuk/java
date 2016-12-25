package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 25.12.2016.
 */
public enum LoginPageMap {
    LOGIN_PAGE_ANCHOR("", "form[name=login_form]", TypeLocator.CSS),
    USERNAME("", "form[name=login_form] input[name=username]", TypeLocator.CSS),
    PASSWORD("", "form[name=login_form] input[name=password]", TypeLocator.CSS),
    REMEMBER_ME_CHECK("", "form[name=login_form] input[name=remember_me]", TypeLocator.CSS),
    LOGIN_BTN("", "form[name=login_form] button[name=login]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    LoginPageMap(final String text, final String path, final TypeLocator type) {
        this.text = text;
        this.path = path;
        this.type = type;
    }

    public String text() {
        return text;
    }

    public By by() {
        if (type == TypeLocator.CSS) {
            return By.cssSelector(path);
        } else {
            return By.xpath(path);
        }
    }
}
