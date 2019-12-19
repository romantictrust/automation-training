package edu.romantictrust.webdriver.page;

import edu.romantictrust.webdriver.model.CarReservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReservationPage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement puCountrySelect;
    private WebElement puCitySelect;
    private WebElement puLocationSelect;
    private WebElement puDateButton;
    private WebElement puTimeButton;
    private WebElement doDateButton;
    private WebElement doTimeButton;
    private WebElement getQuoteButton;
    private JavascriptExecutor js;


    public ReservationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ReservationPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoaded();
        logger.info("Opened page");
        return this;
    }

    public ReservationPage setRentCarData(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement puCountrySelect = driver.findElement(By.name("PU-country"));
        js.executeScript("arguments[0].click();", puCountrySelect);
        puCountrySelect.sendKeys(reservation.getPickUpCountry());
        WebElement puCitySelect = driver.findElement(By.name("PU-city"));
        js.executeScript("arguments[0].click();", puCitySelect);
        js.executeScript("arguments[0].click();", puCitySelect);
        puCitySelect.sendKeys(reservation.getPickUpCity());
        WebElement puLocationSelect = driver.findElement(By.name("PU-loc"));
        js.executeScript("arguments[0].click();", puLocationSelect);
        js.executeScript("arguments[0].click();", puLocationSelect);
        puLocationSelect.sendKeys(reservation.getPickUpLocation());
        WebElement puDateButton = driver.findElement(By.xpath("//*[@id=\"pickup-date\"]"));
        js.executeScript("arguments[0].click();", puDateButton);
        js.executeScript("arguments[0].click();", puDateButton);
        puDateButton.sendKeys(reservation.getPickUpDate());
        WebElement puTimeButton = driver.findElement(By.xpath("//*[@id=\"pickup-time-button\"]"));
        js.executeScript("arguments[0].click();", puTimeButton);
        js.executeScript("arguments[0].click();", puTimeButton);
        puTimeButton.sendKeys(reservation.getPickUpTime());
        WebElement doDateButton = driver.findElement(By.xpath("//*[@id=\"dropoff-date\"]"));
        js.executeScript("arguments[0].click();", doDateButton);
        js.executeScript("arguments[0].click();", doDateButton);
        doDateButton.sendKeys(reservation.getDropOffDate());
        WebElement doTimeButton = driver.findElement(By.xpath("//*[@id=\"dropoff-time-button\"]"));
        js.executeScript("arguments[0].click();", doTimeButton);
        js.executeScript("arguments[0].click();", doTimeButton);
        doTimeButton.sendKeys(reservation.getDropOffTime());
        WebElement getQuoteButton = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[6]/button"));
        js.executeScript("arguments[0].click();", getQuoteButton);
        js.executeScript("arguments[0].click();", getQuoteButton);
        return this;
    }

    public String getPlaceholder() {
        return "hi";
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
