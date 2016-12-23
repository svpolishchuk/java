package maps;

/**
 * Created by polis on 15.12.2016.
 */
import org.openqa.selenium.By;

public enum CountriesPage {

    COUNTRIE_PAGE_TITLE("Countries | My Store", "", null),
    COUNTRIE_ROWS("",".dataTable tr.row", TypeLocator.CSS),
    COUNTRIE_HREF("", "a", TypeLocator.CSS),
    COUNTRIE_ZONE("", "td:nth-child(4)", TypeLocator.CSS),
    ZONE_PAGE_TITLE("Edit Geo Zone | My Store", "", null),
    ZONE_ROWS("", "#table-zones tr:not(.header)", TypeLocator.CSS),
    ZONE_NAME("", ".//td[3]/select/option[@selected='selected']", TypeLocator.XPATH),
    ZONE_CANCEL_BTN("", "[name=cancel]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    CountriesPage(final String text, final String path, final TypeLocator type) {

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
