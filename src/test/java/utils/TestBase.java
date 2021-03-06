package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeSuite
    public void setup() {
        String OS = System.getProperty("os.name");
        System.out.println("setting up webdriver properties");

        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.gecko.driver","/home/e34/workspace/seleniumtraining/resources/linux/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/home/e34/workspace/seleniumtraining/resources/linux/chromedriver");
                break;

            case "Mac OS X":
                System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
                System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
                break;

            case "Windows 10":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\geckodriver.exe");
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\IdeaProjects\\e34seleniumtraining\\resources\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpalotas\\Desktop\\drivers\\chromedriver.exe");
                break;

            default:
                System.out.println(System.getProperty("os.name") + " is not supported ");
                break;
        }
    }

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    //protected static ThreadLocal<EventFiringWebDriver> firingWebDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (@Optional String browser) throws MalformedURLException {


        //Set DesiredCapabilities
        DesiredCapabilities capability = new DesiredCapabilities();

        if (browser == null) {
            capability.setCapability("browserName", "chrome");
        }
        else {
            capability.setCapability("browserName", browser);
        }
        capability.setCapability("e34:token", "72aa4d82");
        capability.setCapability("e34:l_testName", "Selenium Test");
        capability.setCapability("video", true);
        capability.setCapability("e34_timeout_per_test_ms", 60000);


        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability));
        //driver.set(new RemoteWebDriver(new URL("https://vm-106.element34.net/wd/hub"), capability));
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //firingWebDriver.set(new EventFiringWebDriver(driver.get()));
        //EventListener listener = new EventListener(driver.get());
        //firingWebDriver.get().register(listener);

    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
        //return firingWebDriver.get();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}