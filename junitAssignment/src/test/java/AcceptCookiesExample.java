import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AcceptCookiesExample
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        // Wait for some seconds for the Accept All Cookies button to appear after that clcik.........
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();

        //  Cookies accepted automatically test
        System.out.println("Cookies accepted automatically.");
        driver.quit();
    }
}
