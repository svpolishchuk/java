package maps;

/**
 * Created by polis on 15.12.2016.
 */
import org.openqa.selenium.By;

public enum CreateAccountPage {
    PAGE_HEADER_H1("Create Account", "h1.title", TypeLocator.CSS),
    TAX_ID("", "form[name=customer_form] input[name=tax_id]", TypeLocator.CSS),
    COMPANY("", "form[name=customer_form] input[name=company]", TypeLocator.CSS),
    FIRST_NAME("", "form[name=customer_form] input[name=firstname]", TypeLocator.CSS),
    LAST_NAME("", "form[name=customer_form] input[name=lastname]", TypeLocator.CSS),
    ADDRESS_1("", "form[name=customer_form] input[name=address1]", TypeLocator.CSS),
    ADDRESS_2("", "form[name=customer_form] input[name=address2]", TypeLocator.CSS),
    POSTCODE("", "form[name=customer_form] input[name=postcode]", TypeLocator.CSS),
    CITY("", "form[name=customer_form] input[name=city]", TypeLocator.CSS),
    COUNTRY("", "form[name=customer_form] select[name=country_code]", TypeLocator.CSS),
    ZONE("", "form[name=customer_form] select[name=zone_code]", TypeLocator.CSS),
    EMAIL("", "form[name=customer_form] input[name=email]", TypeLocator.CSS),
    PHONE("", "form[name=customer_form] input[name=phone]", TypeLocator.CSS),
    SUBSCRIBE("", "form[name=customer_form] input[name=newsletter]", TypeLocator.CSS),
    DISIRED_PWD("", "form[name=customer_form] input[name=password]", TypeLocator.CSS),
    CONFIRM_PWD("", "form[name=customer_form] input[name=confirmed_password]", TypeLocator.CSS),
    CREATE_ACCOUNT_BUTTON("Create Account", "form[name=customer_form] button[type=submit]", TypeLocator.CSS);

    private final String text;
    private final String path;
    private final TypeLocator type;

    CreateAccountPage(final String text, final String path, final TypeLocator type) {
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
