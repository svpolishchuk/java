import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 29.11.2016.
 */
public class LitecartAdminLeftPanel extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(titleIs("My Store"));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        AnotherInterpritation();
    }



        public void AnotherInterpritation() {
            List<WebElement> items = driver.findElements(By.id("app-"));
            //go through all item
            for  (int i = 0; i < items.size(); i++) {
                List<WebElement> itemsNew = driver.findElements(By.id("app-"));
                itemsNew.get(i).click();
                Assert.assertTrue("Header is visible", isElementPresent(driver, By.xpath(("//h1"))));

                //go through all subitems
                List<WebElement> subItems = driver.findElements((By.xpath(("//ul[@class='docs']//a"))));
                for (int j = 0; j < subItems.size(); j++) {
                    List<WebElement> subItemsNew = driver.findElements((By.xpath(("//ul[@class='docs']//a"))));
                    subItemsNew.get(j).click();
                    Assert.assertTrue("Page Header is visible", isElementPresent(driver, By.xpath(("//h1"))));
                }
            }
        }
/*

        driver.findElement(By.xpath("//span[.='Appearence']")).click();
        wait.until(titleIs("Template | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Template']")).click();
        wait.until(titleIs("Template | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Logotype']")).click();
        wait.until(titleIs("Logotype | My Store"));

        driver.findElement(By.xpath("//span[2][.='Catalog']")).click();
        wait.until(titleIs("Catalog | My Store"));
        driver.findElement(By.xpath("//span[1][.='Catalog']")).click();
        wait.until(titleIs("Catalog | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Product Groups']")).click();
        wait.until(titleIs("Product Groups | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Option Groups']")).click();
        wait.until(titleIs("Option Groups | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Manufacturers']")).click();
        wait.until(titleIs("Manufacturers | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Suppliers']")).click();
        wait.until(titleIs("Suppliers | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Delivery Statuses']")).click();
        wait.until(titleIs("Delivery Statuses | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Sold Out Statuses']")).click();
        wait.until(titleIs("Sold Out Statuses | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Quantity Units']")).click();
        wait.until(titleIs("Quantity Units | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='CSV Import/Export']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));

        driver.findElement(By.xpath("//span[2][.='Countries']")).click();
        wait.until(titleIs("Countries | My Store"));
        driver.findElement(By.xpath("//span[2][.='Currencies']")).click();
        wait.until(titleIs("Currencies | My Store"));

        driver.findElement(By.xpath("//span[2][.='Customers']")).click();
        wait.until(titleIs("Customers | My Store"));
        driver.findElement(By.xpath("//span[1][.='Customers']")).click();
        wait.until(titleIs("Customers | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='CSV Import/Export']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Newsletter']")).click();
        wait.until(titleIs("Newsletter | My Store"));

        driver.findElement(By.xpath("//span[2][.='Geo Zones']")).click();
        wait.until(titleIs("Geo Zones | My Store"));

        driver.findElement(By.xpath("//span[2][.='Languages']")).click();
        wait.until(titleIs("Languages | My Store"));
        driver.findElement(By.xpath("//span[1][.='Languages']")).click();
        wait.until(titleIs("Languages | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Storage Encoding']")).click();
        wait.until(titleIs("Storage Encoding | My Store"));

        driver.findElement(By.xpath("//span[2][.='Modules']")).click();
        wait.until(titleIs("Job Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Background Jobs']")).click();
        wait.until(titleIs("Job Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Customer']")).click();
        wait.until(titleIs("Customer Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Shipping']")).click();
        wait.until(titleIs("Shipping Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Payment']")).click();
        wait.until(titleIs("Payment Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Order Total']")).click();
        wait.until(titleIs("Order Total Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Order Success']")).click();
        wait.until(titleIs("Order Success Modules | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Order Action']")).click();
        wait.until(titleIs("Order Action Modules | My Store"));

        driver.findElement(By.xpath("//span[2][.='Orders']")).click();
        wait.until(titleIs("Orders | My Store"));
        driver.findElement(By.xpath("//span[1][.='Orders']")).click();
        wait.until(titleIs("Orders | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Order Statuses']")).click();
        wait.until(titleIs("Order Statuses | My Store"));

        driver.findElement(By.xpath("//span[2][.='Pages']")).click();
        wait.until(titleIs("Pages | My Store"));

        driver.findElement(By.xpath("//span[2][.='Reports']")).click();
        wait.until(titleIs("Monthly Sales | My Store"));
        driver.findElement(By.xpath("//span[1][.='Monthly Sales']")).click();
        wait.until(titleIs("Monthly Sales | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Most Sold Products']")).click();
        wait.until(titleIs("Most Sold Products | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Most Shopping Customers']")).click();
        wait.until(titleIs("Most Shopping Customers | My Store"));

        driver.findElement(By.xpath("//span[2][.='Settings']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Store Info']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Defaults']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='General']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Listings']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Images']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Checkout']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Advanced']")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Security']")).click();
        wait.until(titleIs("Settings | My Store"));

        driver.findElement(By.xpath("//span[2][.='Slides']")).click();
        wait.until(titleIs("Slides | My Store"));

        driver.findElement(By.xpath("//span[2][.='Tax']")).click();
        wait.until(titleIs("Tax Classes | My Store"));
        driver.findElement(By.xpath("//span[1][.='Tax Classes']")).click();
        wait.until(titleIs("Tax Classes | My Store"));
        driver.findElement(By.xpath("//span[1][.='Tax Rates']")).click();
        wait.until(titleIs("Tax Rates | My Store"));

        driver.findElement(By.xpath("//span[2][.='Translations']")).click();
        wait.until(titleIs("Search Translations | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Search Translations']")).click();
        wait.until(titleIs("Search Translations | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='Scan Files']")).click();
        wait.until(titleIs("Scan Files For Translations | My Store"));
        driver.findElement(By.xpath("//li/a/span[.='CSV Import/Export']")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));

        driver.findElement(By.xpath("//span[2][.='Users']")).click();
        wait.until(titleIs("Users | My Store"));

        driver.findElement(By.xpath("//span[2][.='vQmods']")).click();
        wait.until(titleIs("vQmods | My Store"));
        driver.findElement(By.xpath("//span[1][.='vQmods']")).click();
        wait.until(titleIs("vQmods | My Store"));
*/
    }
}