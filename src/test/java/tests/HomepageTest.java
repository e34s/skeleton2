package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestBase;

public class HomepageTest extends TestBase {

    @Test
    public void simpleHomepageTest() throws InterruptedException {

        WebDriver driver = firingWebDriver.get();

        HomePage hp = new HomePage(driver);
        hp.loadPage(driver);
        hp.clickCalculator();

        Thread.sleep(5000);
    }
}
