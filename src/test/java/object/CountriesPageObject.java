package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static maps.CountriesPage.*;

import static object.TestBase.*;

/**
 * Created by polis on 25.12.2016.
 */
public class CountriesPageObject extends PageObject {

    public CountriesPageObject(final WebDriver driver, final WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public boolean pageIsPresent() {
        return waitElementPresent(driver, COUNTRIES_PAGE_TITLE.by(), wait);
    }

    public void clickCountryByName(final String countryName) {
        int countCountries = getCountElements(driver, COUNTRIES_ROWS.by());
        String name;
        for (int i=0; i<countCountries; i++) {
            name = getAttribute(getElementByIndex(driver, COUNTRIES_ROWS.by(), i),
                    COUNTRIES_HREF.by(), "textContent");
            if (countryName.equals(name)) {
                click(getElementByIndex(driver, COUNTRIES_ROWS.by(), i),
                        COUNTRIES_HREF.by());
                break;
            }
        }
    }
}
