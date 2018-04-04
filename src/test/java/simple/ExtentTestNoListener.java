package simple;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestNoListener {

    protected static ExtentReports reports;
    protected static ExtentTest test;

    @Test
    public void passedTest() {

        reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");

        test = reports.startTest("passedTest()");
        test.log(LogStatus.INFO, "test is started");
        test.log(LogStatus.INFO, "doing something");


        Assert.assertTrue(true);

        reports.endTest(test);
        reports.flush();

    }

}
