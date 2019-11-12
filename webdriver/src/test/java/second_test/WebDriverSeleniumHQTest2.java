package second_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumHQTest2 {

    private  WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void  browserSetup() {
        driver = new ChromeDriver();
    }

    @Test (description = "A test for reproducing the catch of errors associated with mismatch between 'YOUR EMAIL' and 'VERIFY YOUR EMAIL' inputs. >> Test case №3 <<")
    public void SubscribeByEmailTest() {
        driver.get("https://www.autoeurope.eu/member-accounts/");

        // 1
        WebElement createAnAccountLink = driver.findElement(By.className("account_create_link"));
        createAnAccountLink.click();

        // 2
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"member_email_create\"]"));
        WebElement verifyEmailInput = driver.findElement(By.xpath("//*[@id=\"member_reemail\"]"));
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"member_signup\"]/div[5]/div[2]/span"));

        emailInput.sendKeys("email1@gmail.com");
        verifyEmailInput.sendKeys("email2@gmail.com");
        Assert.assertEquals(errorMessage.getAttribute("innerHTML"), "Your email and verify email addresses do not match.");
    }

    @AfterMethod (alwaysRun = true)
    public void browserClean (){
//        driver.quit();
//        driver = null;
    }

}
