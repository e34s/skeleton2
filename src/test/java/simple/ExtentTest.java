package simple;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyListener;

@Listeners(MyListener.class)
public class ExtentTest {

    @Test
    public void passedTest() {

        Reporter.log("hello world");
        Assert.assertTrue(true);

    }

    @Test
    public void failedTest() {

        Reporter.log("hello world");
        Assert.assertTrue(false);

    }

}
