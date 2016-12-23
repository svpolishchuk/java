package maps;

import org.openqa.selenium.By;
/**
 * Created by polis on 23.12.2016.
 */

public enum CompaingProductPage {
    COM_PRODUCT_LIST("", "div#box-campaigns li", TypeLocator.CSS),
    COM_PRODUCT_HREF("", "a:first-child", TypeLocator.CSS),
    COM_PRODUCT_NAME("", ".name", TypeLocator.CSS),
    COM_PRODUCT_REG_PRICE("", ".regular-price", TypeLocator.CSS),
    COM_PRODUCT_CAM_PRICE("", ".campaign-price", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    CompaingProductPage(final String text, final String path, final TypeLocator type) {
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
