package pageobject_model.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static final String RESOURCES_PATH = "src\\test\\resources\\";
    private static final String SYSTEM_PROPERTY_BROWSER = "browser";
    private static final String SYSTEM_PROPERTY_BROWSER_FIREFOX = "firefox";

    private static WebDriver driver;


    private DriverSingleton() {}

    public static WebDriver getDriver(){
        if (null == driver){
            // switch -> if (here we have just one case + default so even IDE asks to change switch to if statement)
            if (SYSTEM_PROPERTY_BROWSER_FIREFOX.equals(System.getProperty(SYSTEM_PROPERTY_BROWSER))) {
                System.setProperty("webdriver.gecko.driver", RESOURCES_PATH + "geckodriver.exe");
                driver = new FirefoxDriver();
            }
            System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
