package simple;

import io.qameta.allure.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

public class BrowserTest extends TestBase {

    @Test(description = "opening axa website")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Browser Tests")
    @Story("open AXA CH website")
    @Description("verify page title after opening AXA homepage")
    public void simpleTest() {

        EventFiringWebDriver driver = (EventFiringWebDriver) getDriver();
        driver.get("https://www.axa.ch");
        Assert.assertEquals(driver.getTitle(), "Private customers");
        driver.quit();
    }
}
