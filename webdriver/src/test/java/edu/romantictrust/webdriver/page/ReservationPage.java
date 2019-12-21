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
    private WebElement transmissionTypeButton;
    private String transmissionChangeText;
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
        getQuoteButton = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[6]/button"));
        getQuoteButton.click();
        logger.info("Reservation request");
        return this;
    }

    public ReservationPage setCountry(CarReservation reservation){
        puCountrySelect = driver.findElement(By.name("PU-country"));
        puCountrySelect.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getPickUpCountry() + "')]")));
        country = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpCountry() + ")]"));
        country.click();
        logger.info("Set country [" + reservation.getPickUpCountry() + "]");
        return  this;
    }

    public ReservationPage setCity(CarReservation reservation){
        puCitySelect = driver.findElement(By.name("PU-city"));
        puCountrySelect.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getPickUpCity() + "')]")));
        city = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpCity() + ")]"));
        city.click();
        logger.info("Set city [" + reservation.getPickUpCity() + "]");
        return  this;
    }

    public ReservationPage setLocation(CarReservation reservation){
        puLocationSelect = driver.findElement(By.name("PU-loc"));
        puLocationSelect.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getPickUpCity() + "')]")));
        location = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpLocation() + ")]"));
        location.click();
        logger.info("Set location [" + reservation.getPickUpLocation() + "]");
        return  this;
    }

    public ReservationPage setPUdate(CarReservation reservation){
        puDateButton = driver.findElement(By.xpath("//*[@id=\"pickup-date\"]"));
        puDateButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getPickUpDate() + "')]")));
        puDate = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpDate() + ")]"));
        puDate.click();
        logger.info("Set pick-up date [" + reservation.getPickUpDate() + "]");
        return  this;
    }

    public ReservationPage setPUtime(CarReservation reservation){
        puTimeButton = driver.findElement(By.xpath("//*[@id=\"pickup-time-button\"]"));
        puTimeButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getPickUpTime() + "')]")));
        puTime = driver.findElement(By.xpath("//*[contains(text()," + reservation.getPickUpTime() + ")]"));
        puTime.click();
        logger.info("Set pick-up time [" + reservation.getPickUpTime() + "]");
        return  this;
    }

    public ReservationPage setDOdate(CarReservation reservation){
        doDateButton = driver.findElement(By.xpath("//*[@id=\"dropoff-date\"]"));
        doDateButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getDropOffDate() + "')]")));
        doDate = driver.findElement(By.xpath("//*[contains(text()," + reservation.getDropOffDate() + ")]"));
        doDate.click();
        logger.info("Set drop-off date [" + reservation.getDropOffDate() + "]");
        return  this;
    }

    public ReservationPage setDOtime(CarReservation reservation){
        doTimeButton = driver.findElement(By.xpath("//*[@id=\"dropoff-time-button\"]"));
        doTimeButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + reservation.getDropOffTime() + "')]")));
        doTime = driver.findElement(By.xpath("//*[contains(text()," + reservation.getDropOffTime() + ")]"));
        doTime.click();
        logger.info("Set drop-off time [" + reservation.getDropOffTime() + "]");
        return  this;
    }

    public ReservationPage changeTransmission(){
        transmissionTypeButton = driver.findElement(By.xpath("//*[@id=\"matrix__filters\"]/div[2]/div[1]/div"));
        transmissionTypeButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Automatic Only')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Automatic Only')]")).click();
        logger.info("Transmission had been changed");
        return this;
    }

    public String getPlaceholder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropoff-date\"]")));
        doDateButton = driver.findElement(By.xpath("//*[@id=\"dropoff-date\"]"));
        logger.info("Resulting date [" + doDateButton.getText() + "]");
        return doDateButton.getText();
    }

    public String getChangedTransmission(){
        transmissionChangeText = driver.findElement(By.xpath("//*[@id=\"matrix__scroll-container\"]/ul[1]/li[2]")).getText();
        logger.info("Resulting text [" + transmissionChangeText + "]");
       return transmissionChangeText;
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
