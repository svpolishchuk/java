import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by polis on 25.12.2016.
 */
public class WindowHelper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WindowHelper(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getActiveWindowId() {
        return driver.getWindowHandle();
    }

    public void switchToWindow(final String windowId) {
        driver.switchTo().window(windowId);
    }

    public Set<String> getIdCurrentWindows() {
        return driver.getWindowHandles();
    }

    public String getNewWindowId(Set<String> oldWindowId) {
        if (!waitNewWindowPresent(driver, wait, oldWindowId)) {
            return "";
        }

        Set<String> newWindowId = driver.getWindowHandles();
        for (String id : newWindowId) {
            if (oldWindowId.contains(id)) {
                continue;
            } else {
                return id;
            }
        }
        return "";
    }

    public static boolean waitNewWindowPresent(final WebDriver driver, final WebDriverWait wait,
                                               final Set<String> oldWindowId) {
        try {
            wait.until(ExpectedConditionsHelper.presentNewWindow(driver, oldWindowId));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public void closeActiveWindow() {
        driver.close();
    }
}