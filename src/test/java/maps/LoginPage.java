package maps;

/**
 * Created by polis on 21.12.2016.
 */
import org.openqa.selenium.By;

public enum LoginPage {
    LOGIN_PAGE_FORM("", "[name=login_form]", TypeLocator.CSS),
    USERNAME("", "input[name=username]", TypeLocator.CSS),
    PASSWORD("", "input[name=password]", TypeLocator.CSS),
    LOGIN_BUTTON("", "button[name=login]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    LoginPage(final String text, final String path, final TypeLocator type) {
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