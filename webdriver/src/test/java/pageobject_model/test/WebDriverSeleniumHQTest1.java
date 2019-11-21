package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.SeleniumHQMainPage;


public class WebDriverSeleniumHQTest1 {

    private  WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void  browserSetup() {
        driver = new ChromeDriver();
    }

    @Test (description = "A test for reproducing the catch of errors associated with incorrect email input. >> Test case №1 <<")
    public void SubscribeByEmailTest() {
        String expectedEmailConfirmationString = new SeleniumHQMainPage(driver)
                .openPage()
                .subscribeEmail("nobody").getPlaceholder();
        Assert.assertEquals(expectedEmailConfirmationString, "Invalid email");
    }

    @AfterMethod (alwaysRun = true)
    public void browserClean (){
        driver.quit();
        driver = null;
    }

}
