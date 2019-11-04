import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.autoeurope.eu/");
        WebElement subscribeInput = driver.findElement(By.id("newsletter__footer--input"));
        subscribeInput.sendKeys("badEmail");
        WebElement subscribeButton = driver.findElement(By.className("newsletter__footer--button"));
        JavascriptExecutor  js = (JavascriptExecutor ) driver;
        js.executeScript("arguments[0].click();", subscribeButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBe(subscribeInput, "placeholder", "Invalid email"));
        String placeholder = subscribeInput.getAttribute("placeholder");
        System.out.println(placeholder);
        Thread.sleep(5000);
        driver.quit();
    }
}
