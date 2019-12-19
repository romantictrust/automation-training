package edu.romantictrust.webdriver.test;

import edu.romantictrust.webdriver.driver.DriverSingleton;
import edu.romantictrust.webdriver.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

//    @AfterMethod(alwaysRun = true)
//    public void stopBrowser()
//    {
//        DriverSingleton.closeDriver();
//    }
}
