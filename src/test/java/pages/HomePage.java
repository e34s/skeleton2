package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    @FindBy(css="body > div.contents > nav > div > ul > li:nth-child(1) > a")
    private WebElement calculator;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get("https://www.axa.ch/en/private-customers.html");
    }

    public void clickCalculator() {
        calculator.click();
    }
}
