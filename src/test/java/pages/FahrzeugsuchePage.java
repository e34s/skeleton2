/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FahrzeugsuchePage {

    @FindBy(id="fl_erstinverkehrssetzung_shortcut_year")
    private WebElement year;

    @FindBy(id="fl_erstinverkehrssetzung_shortcut_month")
    private WebElement month;

    @FindBy(id="fl_marke")
    private WebElement marke;

    @FindBy(css="#fl_fuel_type > label:nth-child(2)")
    private WebElement benzin;

    @FindBy(css="#fl_fuel_type > label:nth-child(4)")
    private WebElement diesel;

    @FindBy(css="#fl_fuel_type > label:nth-child(6)")
    private WebElement andere;

    @FindBy(id="fl_model")
    private WebElement model;

    @FindBy(css="#fl_transmission_type > label:nth-child(2)")
    private WebElement automat;

    @FindBy(css="#fl_transmission_type > label:nth-child(4)")
    private WebElement manuell;

    @FindBy(css="#fl_power > label:nth-child(2)")
    private WebElement ps100;

    @FindBy(css="#fl_power > label:nth-child(4)")
    private WebElement ps200;

    @FindBy(css="#fl_power > label:nth-child(6)")
    private WebElement ps200plus;

    @FindBy(css="#fl_power > label:nth-child(8)")
    private WebElement psWeissNicht;

    @FindBy(id="fl_fzSuchen")
    private WebElement fahrzeugSuchenButton;

    public FahrzeugsuchePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get(("https://secure.axa.ch/ei/mf_main.seam?LINKID=1000&language=01&nzrv=x1z#s=MF_FAHRZEUG_LENKER"));
    }

    public void selectInv(String inv) throws InterruptedException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("01", "Januar");
        map.put("02", "Februar");
        map.put("03", "März");
        map.put("04", "April");
        map.put("05", "Mai");
        map.put("06", "Juni");
        map.put("07", "Juli");
        map.put("08", "August");
        map.put("09", "September");
        map.put("10", "Oktober");
        map.put("11", "November");
        map.put("12", "Dezember");

        String monat;


        //dd.mm.yyyy format
        if (inv.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            //split the input into its parts delimited by .
            String[] parts = inv.split("\\.");
            monat = map.get(parts[1]);

            Select realSelect = new Select(this.year);
            realSelect.selectByVisibleText(parts[2]);

            realSelect = new Select(this.month);
            realSelect.selectByVisibleText(monat);


        }

        //mm.yyyy
        else if (inv.matches("\\d{2}\\.\\d{4}")) {
            String[] parts = inv.split("\\.");
            monat = map.get(parts[0]);

            Select realSelect = new Select(this.year);
            realSelect.selectByVisibleText(parts[1]);

            realSelect = new Select(this.month);
            realSelect.selectByVisibleText(monat);
        }

        else {
            System.out.println("WRONG DATE FORMAT - dd.mm.yyyy required");
        }

    }

    public void selectMonth(String month) throws InterruptedException {

        Select realSelect = new Select(this.month);
        realSelect.selectByVisibleText(month);
    }

    public void selectMarke(String marke) throws InterruptedException {

        Select realSelect = new Select(this.marke);
        realSelect.selectByVisibleText(marke);
    }


    public int returnIndex(WebDriver driver, String value) throws InterruptedException {

        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fl_model_content"))));

        List<WebElement> optionElements = driver.findElement(By.id("fl_model")).findElements(By.tagName("option"));
        String optionIndex = "";
        for (WebElement optionElement : optionElements) {
            if (optionElement.getText().contains(value)) {
                optionIndex = optionElement.getAttribute("index");
                break;
            }
        }
        return Integer.parseInt(optionIndex);
    }

    public void selectModell(WebDriver driver, String model) throws InterruptedException {

        int index  = returnIndex(driver, model);
        Select realSelect = new Select(this.model);
        realSelect.selectByIndex(index);
    }

    public void selectTreibstoff(String treibstoff) throws InterruptedException {

        switch (treibstoff) {
            case "Benzin" :
                benzin.click();
                break;

            case "Diesel" :
                benzin.click();
                break;

            case "Andere" :
                andere.click();
                break;

            default:
                System.out.println("treibstoff invalid");
        }
    }

    public void selectSchaltung(String schaltung) throws InterruptedException {

        switch (schaltung) {
            case "Automat" :
                automat.click();
                break;

            case "Manuell" :
                manuell.click();
                break;

            default:
                System.out.println("schaltung invalid");
        }
    }


    public void selectPS(String ps) throws InterruptedException {

        if (ps!=null) {
            switch (ps) {
                case "Bis 100" :
                    ps100.click();
                    break;

                case "101-200" :
                    ps200.click();
                    break;

                case "Mehr als 200" :
                    ps200plus.click();
                    break;

                case "Weiss nicht" :
                    psWeissNicht.click();
                    break;

                default:
                    System.out.println("ps invalid");
            }
        }

    }

    public void clickSearchButton() throws InterruptedException {
        fahrzeugSuchenButton.click();
    }


    public void selectSpecificModel(WebDriver driver, String specificModel) throws InterruptedException {

        List<WebElement> list = driver.findElements(By.className("table__item__info__content"));

        for (WebElement element : list) {
            if (element.getText().contains(specificModel)) {
                element.click();
                break;
            }
        }
    }

}
