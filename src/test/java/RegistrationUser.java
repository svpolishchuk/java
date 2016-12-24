import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static maps.CompaingProductPage.COM_PRODUCT_LIST;
import static maps.LoginPage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 24.12.2016.
 */

public class RegistrationUser extends TestBase {

    private String testFirstName = "Serhii1";
    private String testLastName = "Polishchuk1";
    private String testEmail = "polishchuk@test1.com";
    private String testPwd = "123456";

    @Test
    public void CreateNewUser() {
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));

        CreateAccount newAccount = new CreateAccount(driver);
        UserPage user = new UserPage(driver, wait);
        user.clickNewCustomerLink();
        assertEquals("Create Account",newAccount.getHeader());
        newAccount.typeTaxId("8475985689");
        newAccount.typeCompany("Test");
        newAccount.typeFirstName(testFirstName);
        newAccount.typeLastName(testLastName);
        newAccount.typeAddress_1("Kolosa 4");
        newAccount.typePostcode("65465");
        newAccount.typeCity("Barsa");
        newAccount.typeEmail(testEmail);
        newAccount.typePhone("+380 95 063-21-32");
        newAccount.typePassword(testPwd);
        newAccount.typeConfirmPassword(testPwd);
        newAccount.clickCreateAccountBtn();

        assertEquals("Your customer account has been created.", user.getSuccessMessage().trim());

        user.doLogout();
        assertTrue(user.loginFormIsPresent());
    }

    @Test
    public  void VerificationNewUser(){
        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));

        UserPage user = new UserPage(driver, wait);

        user.gotoHomePage();
        assertTrue(user.loginFormIsPresent());
        user.typeEmail(testEmail);
        user.typePassword(testPwd);
        user.clickLoginBtn();

        String msg = user.getSuccessMessage();
        assertTrue(msg.contains(testFirstName));
        assertTrue(msg.contains(testLastName));
        user.doLogout();
    }
//
//    public boolean verifyAnchor() {
//        return isElementPresent(driver, LOGIN_PAGE_FORM.by());
//    }
//
//    public void typeUserName(final String username) {
//        typeText(driver, USERNAME.by(), username);
//    }
//
//    public void typeUserPasword(final String userPwd) {
//        typeText(driver, PASSWORD.by(), userPwd);
//    }
//
//    public void clickLoginBtn() {
//        click(driver, LOGIN_BUTTON.by());
//    }

}