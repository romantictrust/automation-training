package edu.romantictrust.webdriver.page;

import edu.romantictrust.webdriver.model.User;
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

public class MotorHomePage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/motorhome-hire/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement driversAgeCheckbox;
    private WebElement ageInput;
    private WebElement findHomeButton;
    private WebElement errorPopup;
    private JavascriptExecutor js;

    public MotorHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MotorHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoaded();
        driversAgeCheckbox = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[1]/label"));
        ageInput = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[1]/input[2]"));
        findHomeButton = driver.findElement(By.xpath("//*[@id=\"ae-search\"]/div[3]/div[2]/button"));
        logger.info("Opened page");
        return this;
    }

    public MotorHomePage setUsersAge(User user) {
        js = (JavascriptExecutor ) driver;
        js.executeScript("arguments[0].click();", driversAgeCheckbox);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(ageInput));
        ageInput.sendKeys(user.getAge());
        js.executeScript("arguments[0].click();", findHomeButton);
        logger.info("Entered age: [" + user.getAge() + "]");
        return this;
    }

    public String getErrorPopupMessage(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"noResultWarning\"]/div[2]")));
        errorPopup = driver.findElement(By.xpath("//*[@id=\"noResultWarning\"]/div[2]"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(errorPopup, "Sorry, no results were found for your search, please try a new search."));
        return errorPopup.getText();
    }

    private void waitForPageLoaded() {
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
