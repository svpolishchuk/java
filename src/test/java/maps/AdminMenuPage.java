package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 25.12.2016.
 */
public enum AdminMenuPage {
    ADMIN_MENU_ANCHOR("", "ul#box-apps-menu", TypeLocator.CSS),
    ADMIN_MENU_ITEMS_LI("", "li#app-", TypeLocator.CSS),
    ADMIN_MENU_ITEM_URL("", "a", TypeLocator.CSS),
    ADMIN_MENU_ITEM_SELECTED("", "li#app-.selected", TypeLocator.CSS),
    ADMIN_MENU_ITEM_NAME("", "a>span.name", TypeLocator.CSS),
    ADMIN_MENU_SUBMENU_ITEMS_LI("", "ul>li", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    AdminMenuPage(final String text, final String path, final TypeLocator type) {
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
