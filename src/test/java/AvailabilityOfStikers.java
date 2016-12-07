import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by PSV_LaDevelopers on 05.12.2016.
 */
public class AvailabilityOfStikers extends TestBase {

    @Test
    public void Availability() {

        driver.get("http://localhost/litecart/en/");
        wait.until(titleIs("Online Store | My Store"));
        // Most Popular
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-most-popular li.product:nth-of-type(1) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-most-popular li.product:nth-of-type(2) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-most-popular li.product:nth-of-type(3) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-most-popular li.product:nth-of-type(4) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-most-popular li.product:nth-of-type(5) .sticker")));

        //Campaigns
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-campaigns li.product:nth-of-type(1) .sticker")));

        // Latest Products
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-latest-products li.product:nth-of-type(1) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-latest-products li.product:nth-of-type(2) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-latest-products li.product:nth-of-type(3) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-latest-products li.product:nth-of-type(4) .sticker")));
        Assert.assertTrue("Number of stickers is not equal to 1", areElementsPresent(driver, By.cssSelector("#box-latest-products li.product:nth-of-type(5) .sticker")));
    }
}
