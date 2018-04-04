package tests;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FahrzeugsuchePage;
import utils.ExcelAdapter;
import utils.TestBase;

import java.util.Map;

//@Listeners(StatusListener.class)
public class AutoversicherungsTest extends TestBase {

    @Test(dataProvider="datamap", dataProviderClass = ExcelAdapter.class)
    public void newTest(Map<Object, Object> map) throws InterruptedException {

//        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        EventFiringWebDriver driver = (EventFiringWebDriver) getDriver();


        //Fahrzeugsuche
        FahrzeugsuchePage fahrzeugsuche = new FahrzeugsuchePage(driver);
        fahrzeugsuche.loadPage(driver);
        fahrzeugsuche.selectInv((String) map.get("1.INV"));
        fahrzeugsuche.selectMarke((String) map.get("Marke"));
        fahrzeugsuche.selectTreibstoff((String) map.get("Treibstoff"));
        fahrzeugsuche.selectModell(driver, (String) map.get("Modell"));
        fahrzeugsuche.selectSchaltung((String) map.get("Schaltung"));
        fahrzeugsuche.selectPS((String) map.get("ps"));
        fahrzeugsuche.clickSearchButton();

        fahrzeugsuche.selectSpecificModel(driver, (String) map.get("Typbz"));

        Thread.sleep(5000);

    }
}
