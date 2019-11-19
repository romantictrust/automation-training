package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQMainPage {

    private  static final  String HOMEPAGE_URL = "https://www.autoeurope.eu/";
    private WebDriver driver;

    @FindBy(id = "newsletter__footer--input")
    private WebElement subscribeInput;

    @FindBy(xpath = "//*[@id=\"main-footer__content\"]/div[1]/div/div/div[1]/div/div/div[3]/button")
    private WebElement subscribeButton;

    @FindBy(xpath = "//*[@id=\"ui-cookie-support-notification\"]/div/div/div[2]/button")
    private WebElement closeCookieButton;

    public  SeleniumHQMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  SeleniumHQMainPage openPage() {
        driver.get("https://www.autoeurope.eu/");
        return this;
    }

    public SeleniumHQMainPage subscribeEmail(String email) {
        subscribeInput.sendKeys(email);
        closeCookieButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(subscribeButton).click().perform();
        return this;
    }

    public String getPlaceholder() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.attributeToBe(subscribeInput, "placeholder", "Invalid email"));
        return subscribeInput.getAttribute("placeholder");
    }
}
