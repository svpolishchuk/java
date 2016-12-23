package maps;

/**
 * Created by polis on 21.12.2016.
 */
import org.openqa.selenium.By;

public enum HomePage {
    IMAGE_WRAPPER("", "div.image-wrapper", TypeLocator.CSS),
    STICKER("", "div.sticker", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    HomePage(final String text, final String path, final TypeLocator type) {
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