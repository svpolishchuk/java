import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static maps.CreateAccountPage.*;
import static maps.LoginPage.*;

/**
 * Created by polis on 24.12.2016.
 */
public class CreateAccount extends TestBase {

    private final WebDriver driver;

    public CreateAccount(final WebDriver driver) {
        this.driver = driver;
    }

    public String getHeader() {
        return getAttribute(driver, PAGE_HEADER_H1.by(), "textContent");
    }

    public void typeTaxId(final String taxId) {
        typeText(driver, TAX_ID.by(), taxId);
    }

    public void typeCompany(final String company) {
        typeText(driver, COMPANY.by(), company);
    }

    public void typeFirstName(final String firsName) {
        typeText(driver, FIRST_NAME.by(), firsName);
    }

    public void typeLastName(final String lastName) {
        typeText(driver, LAST_NAME.by(), lastName);
    }

    public void typeUsername(final String username) {
        typeText(driver, USERNAME.by(), username);
    }

    public void typeAddress_1(final String address_1) {
        typeText(driver, ADDRESS_1.by(), address_1);
    }

    public void typeAddress_2(final String address_2) {
        typeText(driver, ADDRESS_2.by(), address_2);
    }

    public void typePostcode(final String postCode) {
        typeText(driver, POSTCODE.by(), postCode);
    }

    public void typeCity(final String city) {
        typeText(driver, CITY.by(), city);
    }

    public void selectCountry(final String country) {
        Select select = new Select(getElement(driver, COUNTRY.by()));
        select.selectByValue(country);
    }

    public void selectZone(final String zone) {
        Select select = new Select(getElement(driver, ZONE.by()));
        select.selectByValue(zone);
    }

    public void typeEmail(final String email) {
        typeText(driver, EMAIL.by(), email);
    }

    public void typePhone(final String phone) {
        typeText(driver, PHONE.by(), phone);
    }

    public void checkSubscribe() {
        if (!getElement(driver, SUBSCRIBE.by()).isSelected()) {
            click(driver, SUBSCRIBE.by());
        }
    }

    public void uncheckSubscribe() {
        if (getElement(driver, SUBSCRIBE.by()).isSelected()) {
            click(driver, SUBSCRIBE.by());
        }
    }

    public void typePassword(final String password) {
        typeText(driver, DISIRED_PWD.by(), password);
    }

    public void typeConfirmPassword(final String password) {
        typeText(driver, CONFIRM_PWD.by(), password);
    }

    public void clickCreateAccountBtn() {
        click(driver, CREATE_ACCOUNT_BUTTON.by());
    }
}
