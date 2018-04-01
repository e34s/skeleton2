package simple;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

public class BrowserTest extends TestBase {

    @Test(description = "opening axa website")
    public void simpleTest() {

        EventFiringWebDriver driver = (EventFiringWebDriver) getDriver();
        driver.get("https://www.axa.ch");
        Assert.assertEquals(driver.getTitle(), "Private customers");
        driver.quit();
    }
}
