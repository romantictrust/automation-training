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

public class AuthorizationPage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/member-accounts/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private WebElement errorPlaceholder;
    private JavascriptExecutor js;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthorizationPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoaded();
        logger.info("Opened page");
        return this;
    }

    public AuthorizationPage signIn(User user){
        js = (JavascriptExecutor ) driver;
        emailInput = driver.findElement(By.xpath("//*[@id=\"member_username\"]"));
        emailInput.sendKeys(user.getEmail());
        passwordInput = driver.findElement(By.xpath("//*[@id=\"member_password\"]"));
        passwordInput.sendKeys(user.getPassword());
        signInButton = driver.findElement(By.xpath("//*[@id=\"account_login_button\"]"));
        js.executeScript("arguments[0].click();", signInButton);
        logger.info("Entered email: [" + user.getEmail() + "] Entered password: [" + user.getPassword() + "]");
        return this;
    }

    public String getPlaceholder() {
        errorPlaceholder = driver.findElement(By.xpath("//*[@id=\"member-response-left\"]"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(errorPlaceholder, "PLEASE ENTER A VALID EMAIL AND PASSWORD."));
        return errorPlaceholder.getText();
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
