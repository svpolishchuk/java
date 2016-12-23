package maps;

/**
 * Created by polis on 15.12.2016.
 */
import org.openqa.selenium.By;

public enum ContentPage {

    CONTENT_PAGE_HEADER("", "td#content h1", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    ContentPage(final String text, final String path, final TypeLocator type) {
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
