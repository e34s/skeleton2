package simple;

import io.qameta.allure.*;
import javafx.application.Application;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.File;

import static utils.Helpers.screenshot;

public class AllureBrowserTest extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Feature 1")
    @Story("Story 1")
    @Description("verify page title after opening AXA homepage")
    public void openAxaWebsite() {

        WebDriver driver = getDriver();
        driver.get("https://www.axa.ch");
        Assert.assertEquals(driver.getTitle(), "Private customers");
        screenshot((RemoteWebDriver) driver);
        saveScreenshot(((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Feature 2")
    @Story("Story 1")
    @Description("ZKB page can be openend")
    public void openZKBWebsite() {

        WebDriver driver = getDriver();
        driver.get("https://www.zkb.ch");
        Assert.assertTrue(true);
        saveScreenshot(((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(RemoteWebDriver driver) {
        System.out.println("calling allure screenshot");
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public void screenshot(RemoteWebDriver driver) {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File ss = new File("" + System.currentTimeMillis() + ".png");
        tmp.renameTo(ss);
        System.out.println("Screenshot: " + ss.getAbsoluteFile());
    }
}
