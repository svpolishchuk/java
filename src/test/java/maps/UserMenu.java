package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 24.12.2016.
 */
public enum UserMenu {

        FORM_TITLE("Login", "#box-account-login > h3.title", TypeLocator.CSS),
        EMAIL("", "form[name=login_form] input[name=email]", TypeLocator.CSS),
        PASSWORD("", "form[name=login_form] input[name=password]", TypeLocator.CSS),
        REMEMBER_ME("", "form[name=login_form] input[name=remember_me]", TypeLocator.CSS),
        LOGIN_BUTTON("", "form[name=login_form] button[name=login]", TypeLocator.CSS),
        LOST_PASSWORD_BUTTON("", "form[name=login_form] button[name=lost_password]", TypeLocator.CSS),
        NEW_CUSTOMER_LINK("", "form[name=login_form] a", TypeLocator.CSS),
        ITEM_MENU_LOGOUT("", "Logout", TypeLocator.LINK),
        SUCCESS_MESSAGE("", ".notice.success", TypeLocator.CSS);

        private final String text;
        private final String path;
        private final TypeLocator type;

        UserMenu(final String text, final String path, final TypeLocator type) {
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
