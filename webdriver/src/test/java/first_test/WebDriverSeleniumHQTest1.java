package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebDriverSeleniumHQTest1 {

    private  WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void  browserSetup() {
        driver = new ChromeDriver();
    }

    @Test (description = "A test for reproducing the catch of errors associated with incorrect email input. >> Test case №1 <<")
    public void SubscribeByEmailTest() {
        driver.get("https://www.autoeurope.eu/");
        WebElement subscribeInput = driver.findElement(By.id("newsletter__footer--input"));
        subscribeInput.sendKeys("badEmail");
        WebElement subscribeButton = driver.findElement(By.className("newsletter__footer--button"));
        JavascriptExecutor  js = (JavascriptExecutor ) driver;
        js.executeScript("arguments[0].click();", subscribeButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.attributeToBe(subscribeInput, "placeholder", "Invalid email"));
        String placeholder = subscribeInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Invalid email");
    }

    @AfterMethod (alwaysRun = true)
    public void browserClean (){
        driver.quit();
        driver = null;
    }

}