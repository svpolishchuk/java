package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 25.12.2016.
 */

public enum HeaderPage {
    HOME_LINK("", "i.fa.fa-home[title=Home]", TypeLocator.CSS),
    COUNT_ITEMS_INTO_CART("", "div#cart span.quantity", TypeLocator.CSS),
    CART("", "div#cart", TypeLocator.CSS),
    CHECKOUT_LINK("", "Checkout »", TypeLocator.LINK);

    private final String text;
    private final String path;
    private final TypeLocator type;

    HeaderPage(final String text, final String path, final TypeLocator type) {
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
        } else if (type == TypeLocator.LINK) {
            return By.linkText(path);
        } else {
            return By.xpath(path);
        }
    }
}
