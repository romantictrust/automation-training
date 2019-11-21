package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumHQCreateAccountPage {
    private  static final  String CREATEACCOUNT_URL = "https://www.autoeurope.eu/member-accounts/";
    private WebDriver driver;
    private WebElement createAnAccountLink;
    private WebElement emailInput;
    private WebElement verifyEmailInput;
    private WebElement errorMessage;
    private JavascriptExecutor js;


    public  SeleniumHQCreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumHQCreateAccountPage openPage() {
        driver.get(CREATEACCOUNT_URL);
        waitForPageLoaded();
        return this;
    }

    public SeleniumHQCreateAccountPage moveToForm(){
        createAnAccountLink = driver.findElement(By.className("account_create_link"));
        createAnAccountLink.click();
        waitForPageLoaded();
        return this;
    }

    public SeleniumHQCreateAccountPage typeEmails(String email1, String email2) {
        emailInput = driver.findElement(By.xpath("//*[@id=\"member_email_create\"]"));
        verifyEmailInput = driver.findElement(By.xpath("//*[@id=\"member_reemail\"]"));
        errorMessage = driver.findElement(By.xpath("//*[@id=\"member_signup\"]/div[5]/div[2]/span"));
        emailInput.sendKeys(email1);
        verifyEmailInput.sendKeys(email2);
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
