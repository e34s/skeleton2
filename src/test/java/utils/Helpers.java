package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class Helpers {

    public static final String SCREENSHOT_DIRECTORY = "C:\\Users\\mpalotas\\IdeaProjects\\axa-allure-testng-skeleton\\screenshots\\";
    //public static final String SCREENSHOT_DIRECTORY = "C:\\Users\\mpalotas\\Desktop\\screenshots\\";


    public static void screenshot(RemoteWebDriver driver) {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File ss = new File(SCREENSHOT_DIRECTORY + System.currentTimeMillis() + ".png");
        tmp.renameTo(ss);
        System.out.println("Screenshot: " + ss.getAbsoluteFile());
    }

/*    public static void screenshot(WebDriver driver) {
        WebDriver wd = new Augmenter().augment(driver);
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

        File ss = new File(SCREENSHOT_DIRECTORY + System.currentTimeMillis() + ".png");
        tmp.renameTo(ss);
        System.out.println("Screenshot: " + ss.getAbsoluteFile());
    }*/
}
