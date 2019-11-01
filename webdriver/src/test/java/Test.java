import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.autoeurope.eu/");
        WebElement subscribeInput = driver.findElement(By.id("newsletter__footer--input"));
        subscribeInput.sendKeys("badEmail");
        WebElement subscribeButton = driver.findElement(By.className("newsletter__footer--button"));
        JavascriptExecutor  js = (JavascriptExecutor ) driver;
        js.executeScript("arguments[0].click();", subscribeButton);
        subscribeButton.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
