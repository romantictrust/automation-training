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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReservationPage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement puCountrySelect;
    private WebElement country;
    private WebElement puCitySelect;
    private WebElement city;
    private WebElement puLocationSelect;
    private WebElement location;
    private WebElement puDateButton;
    private WebElement puDate;
    private WebElement puTimeButton;
    private WebElement puTime;
    private WebElement doDateButton;
    private WebElement doDate;
    private WebElement doTimeButton;
    private WebElement doTime;
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

    public ReservationPage runCarReservation(CarReservation reservation){
        WebElement getQuoteButton = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[6]/button"));
        getQuoteButton.click();
        logger.info("Reservation request");
        return this;
    }

    public ReservationPage setCountry(CarReservation reservation){
        WebElement puCountrySelect = driver.findElement(By.name("PU-country"));
        puCountrySelect.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text()," + reservation.getPickUpCountry() + ")]")));
        country = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpCountry() + ")]"));
        country.click();
        logger.info("Set country [" + reservation.getPickUpCountry() + "]");
        return  this;
    }

    public ReservationPage setCity(CarReservation reservation){
        WebElement puCitySelect = driver.findElement(By.name("PU-city"));
        puCountrySelect.click();
        puCitySelect.sendKeys(reservation.getPickUpCity());
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text()," + reservation.getPickUpCity() + ")]")));
        city = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpCity() + ")]"));
        city.click();
        logger.info("Set city [" + reservation.getPickUpCity() + "]");
        return  this;
    }

    public ReservationPage setLocation(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement puLocationSelect = driver.findElement(By.name("PU-loc"));
        js.executeScript("arguments[0].click();", puLocationSelect);
        puLocationSelect.sendKeys(reservation.getPickUpLocation());
        location.findElement(By.linkText(reservation.getPickUpLocation()));
        js.executeScript("arguments[0].click();", location);
        logger.info("Set location [" + reservation.getPickUpLocation() + "]");
        return  this;
    }

    public ReservationPage setPUdate(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement puDateButton = driver.findElement(By.xpath("//*[@id=\"pickup-date\"]"));
        js.executeScript("arguments[0].click();", puDateButton);
        puDateButton.sendKeys(reservation.getPickUpDate());
        logger.info("Set pick-up date [" + reservation.getPickUpDate() + "]");
        System.exit(0);
        return  this;
    }

    public ReservationPage setPUtime(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement puTimeButton = driver.findElement(By.xpath("//*[@id=\"pickup-time-button\"]"));
        js.executeScript("arguments[0].click();", puTimeButton);
        puTimeButton.sendKeys(reservation.getPickUpTime());
        logger.info("Set pick-up time [" + reservation.getPickUpTime() + "]");
        return  this;
    }

    public ReservationPage setDOdate(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement doDateButton = driver.findElement(By.xpath("//*[@id=\"dropoff-date\"]"));
        js.executeScript("arguments[0].click();", doDateButton);
        doDateButton.sendKeys(reservation.getDropOffDate());
        logger.info("Set drop-off date [" + reservation.getDropOffDate() + "]");
        return  this;
    }

    public ReservationPage setDOtime(CarReservation reservation){
        js = (JavascriptExecutor ) driver;
        WebElement doTimeButton = driver.findElement(By.xpath("//*[@id=\"dropoff-time-button\"]"));
        js.executeScript("arguments[0].click();", doTimeButton);
        doTimeButton.sendKeys(reservation.getDropOffTime());
        logger.info("Set drop-off time [" + reservation.getDropOffTime() + "]");
        return  this;
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
