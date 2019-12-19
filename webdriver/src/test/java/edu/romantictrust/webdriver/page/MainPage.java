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

public class MainPage {
    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private WebElement subscribeInput;
    private WebElement subscribeButton;
    private WebElement languageSwitchDropdown;
    private WebElement ruIcon;
    private WebElement currencyField;
    private JavascriptExecutor js;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        waitForPageLoaded();
        logger.info("Opened page");
        return this;
    }

    public MainPage subscribeEmail(User user) {
        js = (JavascriptExecutor ) driver;
        subscribeInput = driver.findElement(By.xpath("//*[@id=\"newsletter__footer--input\"]"));
        subscribeButton = driver.findElement(By.xpath("//*[@id=\"main-footer__content\"]/div[1]/div/div/div[1]/div/div/div[3]/button"));
        subscribeInput.sendKeys(user.getUsername());
        js.executeScript("arguments[0].click();", subscribeButton);
        logger.info("Entered email: [" + user.getUsername() + "]");
        return this;
    }

    public MainPage switchLanguage() {
        js = (JavascriptExecutor ) driver;
        languageSwitchDropdown = driver.findElement(By.xpath("//*[@id=\"secnav__country\"]/div/li"));
        js.executeScript("arguments[0].click();", languageSwitchDropdown);
        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"sitepicker\"]/div[3]/div[3]/dl[2]/dd/dl/a[7]")));
        ruIcon = driver.findElement(By.xpath("//*[@id=\"sitepicker\"]/div[3]/div[3]/dl[2]/dd/dl/a[7]"));
        js.executeScript("arguments[0].click();", ruIcon);
        logger.info("Language switched to: [Ru]");
        return this;
    }

    public String getPlaceholder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.attributeToBe(subscribeInput, "placeholder", "Invalid email"));
        return subscribeInput.getAttribute("placeholder");
    }

    public String getActualUrl() {
        logger.info("Redirected to: [" + driver.getCurrentUrl() + "]");
        return driver.getCurrentUrl();
    }

    public String getActualCurrency(){
        currencyField = driver.findElement(By.xpath("//*[@id=\"country_rates-ui-mod--0\"]/ul[1]/li[1]/span/a"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(currencyField, "RUB"));
        return currencyField.getText().substring(0, 3);
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
