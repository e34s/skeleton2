package simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentListener;
import utils.TestBase;


@Listeners(ExtentListener.class)
public class ExtentTestWithListener extends TestBase {

    @Test
    public void passedTest() {


        Reporter.log("hello world");
        Assert.assertTrue(true);

    }

    @Test
    public void failedTest() {

        RemoteWebDriver driver = (RemoteWebDriver) getDriver();

        Reporter.log("hello world");
        Assert.assertTrue(false);

    }

}
