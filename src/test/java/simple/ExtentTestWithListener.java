package simple;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentListener;

@Listeners(ExtentListener.class)
public class ExtentTestWithListener {

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
