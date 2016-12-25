import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.management.ObjectName;
import java.util.*;

import static maps.CountriesPage.*;

import java.util.ArrayList;
import java.util.TreeSet;

import static maps.LeftMenu.MENU_ITEM_SELECTED;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 10.12.2016.
 */
public class SortCountriesAndGeozonesInAdmin extends TestBase {

    @Test
    public void verifySortCountries() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(titleIs("My Store"));
        login();
        driver.findElement(By.xpath("//span[2][.='Countries']")).click();
        wait.until(titleIs("Countries | My Store"));
        ArrayList<String> origOrder = new ArrayList<String>();
        TreeSet<String> sortedOrder = new TreeSet<String>();

        assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
        String name;
        for (WebElement row : getElements(driver, COUNTRIE_ROWS.by())) {
            name = getAttribute(row, COUNTRIE_HREF.by(), "textContent");
            origOrder.add(name);
            sortedOrder.add(name);
        }
        assertTrue(compare(origOrder, sortedOrder));
    }

    @Test
    public void verifySortZones() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(titleIs("My Store"));
        login();
        driver.findElement(By.xpath("//span[2][.='Geo Zones']")).click();
        wait.until(titleIs("Geo Zones | My Store"));
        assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
        int countRows = getCountElements(driver, COUNTRIE_ROWS.by());
        int countZones;
        ArrayList<String> origOrder = new ArrayList<String>();
        TreeSet<String> sortedOrder = new TreeSet<String>();
        String name;

        for(int i=0; i<countRows; i++) {
            origOrder.clear();
            sortedOrder.clear();
            assertTrue(isElementPresent(driver, COUNTRIE_ROWS.by()));
            if(!"0".equals(getText(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_ZONE.by()))) {
                System.out.println(getAttribute(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_HREF.by(), "textContent"));
                click(getElementByIndex(driver, COUNTRIE_ROWS.by(), i), COUNTRIE_HREF.by());
                assertTrue("Title not present", titleIsPresent(wait, ZONE_PAGE_TITLE.text()));
                countZones = getCountElements(driver, ZONE_ROWS.by())- 1;
                for(int j=0; j<countZones; j++) {
                    name = getText(getElementByIndex(driver, ZONE_ROWS.by(), j), ZONE_NAME.by());
                    origOrder.add(name);
                    sortedOrder.add(name);
                }
                assertTrue(compare(origOrder, sortedOrder));
                click(driver, ZONE_CANCEL_BTN.by());
            }
        }
    }

    private boolean compare(ArrayList<String> origOrder, TreeSet<String> sortedOrder) {
        String []str = sortedOrder.toArray(new String[sortedOrder.size()]);
        for(int i = 0; i<origOrder.size(); i++) {
            System.out.println('\t' + origOrder.get(i) + " <===> " + str[i]);
            if (!origOrder.get(i).trim().toLowerCase().equals(str[i].trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
