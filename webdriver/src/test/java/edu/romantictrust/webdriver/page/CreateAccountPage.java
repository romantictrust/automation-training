package edu.romantictrust.webdriver.page;

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
import edu.romantictrust.webdriver.model.User;

public class CreateAccountPage {
    private  static final  String CREATEACCOUNT_URL = "https://www.autoeurope.eu/member-accounts/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement createAnAccountLink;
    private WebElement emailInput;
    private WebElement verifyEmailInput;
    private WebElement errorMessage;
    private JavascriptExecutor js;


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage openPage() {
        driver.get(CREATEACCOUNT_URL);
        waitForPageLoaded();
        logger.info("Opened page");
        return this;
    }

    public CreateAccountPage moveToForm(){
        createAnAccountLink = driver.findElement(By.className("account_create_link"));
        createAnAccountLink.click();
        waitForPageLoaded();
        logger.info("Moved to form");
        return this;
    }

    public CreateAccountPage typeEmails(User user) {
        emailInput = driver.findElement(By.xpath("//*[@id=\"member_email_create\"]"));
        verifyEmailInput = driver.findElement(By.xpath("//*[@id=\"member_reemail\"]"));
        errorMessage = driver.findElement(By.xpath("//*[@id=\"member_signup\"]/div[5]/div[2]/span"));
        String modifiedEmail = user.getEmail() + "qwerty";
        emailInput.sendKeys(user.getEmail());
        verifyEmailInput.sendKeys(modifiedEmail);
        logger.info("Entered email: [" + user.getEmail() + "] and confirmed it with [" + modifiedEmail + "]");
        return this;
    }

    public String getErrorMessage() {
        Assert.assertEquals(errorMessage.getAttribute("innerHTML"), "Your email and verify email addresses do not match.");
        return errorMessage.getAttribute("innerHTML");
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
