package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 25.12.2016.
 */
public enum RootAdminMenuPage {
    LOGOUT("", "td#sidebar > div.header > a[title=Logout]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    RootAdminMenuPage(final String text, final String path, final TypeLocator type) {
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
