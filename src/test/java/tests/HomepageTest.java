package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestBase;

import static utils.Helpers.screenshot;

public class HomepageTest extends TestBase {

    @Test
    public void simpleHomepageTest() throws InterruptedException {

        RemoteWebDriver driver = (RemoteWebDriver) getDriver();

        HomePage hp = new HomePage(driver);
        hp.loadPage(driver);
        hp.clickCalculator();
        screenshot(driver);

        Thread.sleep(5000);
    }
}
