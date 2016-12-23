package maps;

/**
 * Created by polis on 21.12.2016.
 */
import org.openqa.selenium.By;

public enum RootMenu {
    ITEM_MENU_LOGOUT("", "[title=Logout]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    RootMenu(final String text, final String path, final TypeLocator type) {
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
