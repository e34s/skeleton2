package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;

public class Helpers {

    public static final String SCREENSHOT_DIRECTORY = "C:\\Users\\mpalotas\\IdeaProjects\\axa-allure-testng-skeleton\\screenshots\\";


    public static void screenshot(EventFiringWebDriver driver) {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File ss = new File(SCREENSHOT_DIRECTORY + System.currentTimeMillis() + ".png");
        tmp.renameTo(ss);
        System.out.println("Screenshot: " + ss.getAbsoluteFile());
    }
}
