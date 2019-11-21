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

public class SeleniumHQMainPage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/";
    private WebDriver driver;
    private WebElement subscribeInput;
    private WebElement subscribeButton;
    private JavascriptExecutor js;


    public  SeleniumHQMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  SeleniumHQMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoaded();
        subscribeInput = driver.findElement(By.xpath("//*[@id=\"newsletter__footer--input\"]"));
        subscribeButton = driver.findElement(By.xpath("//*[@id=\"main-footer__content\"]/div[1]/div/div/div[1]/div/div/div[3]/button"));
        return this;
    }

    public SeleniumHQMainPage subscribeEmail(String email) {
        subscribeInput.sendKeys(email);
        js = (JavascriptExecutor ) driver;
        js.executeScript("arguments[0].click();", subscribeButton);
        return this;
    }

    public String getPlaceholder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.attributeToBe(subscribeInput, "placeholder", "Invalid email"));
        return subscribeInput.getAttribute("placeholder");
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
