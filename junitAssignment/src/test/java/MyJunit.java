import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit
{
    WebDriver driverOBJ;
    @BeforeAll
    public void setUp()
    {
        driverOBJ = new ChromeDriver();
        driverOBJ.manage().window().maximize();
        driverOBJ.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void standardPractice() throws InterruptedException
    {
        driverOBJ.get("https://www.digitalunite.com/practice-webform-learners");

        // Accept cookies automatically
        driverOBJ.findElement(By.id("onetrust-accept-btn-handler")).click();

        List<WebElement> userFromOBJ = driverOBJ.findElements(By.className("form-control"));
        userFromOBJ.get(0).sendKeys("MD SALAHIN");
        userFromOBJ.get(1).sendKeys("01568260741");

        //edit-date
        WebElement datePickerElementOBj =  driverOBJ.findElement(By.id("edit-date"));
        datePickerElementOBj.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        datePickerElementOBj.sendKeys("10/06/2025");
        Thread.sleep(3000);
        datePickerElementOBj.sendKeys(Keys.ENTER);


        userFromOBJ.get(3).sendKeys("salahin1999@gmail.com");
        userFromOBJ.get(4).sendKeys("Hi this is me salahin");
        //fro file upload
        //userFromOBJ.get(5).sendKeys("D:\\Automation.salahin.jpg"); //not working letter check

        //fro scrolling
        Utils.scroll(driverOBJ, 600);
        //fro file upload
        driverOBJ.findElement(By.id("edit-uploadocument-upload")).sendKeys("D:\\Automation\\salahin.jpg"); // working now

        WebElement checkBoxOBJ =  driverOBJ.findElement(By.id("edit-age"));
        JavascriptExecutor jsOBJ = (JavascriptExecutor) driverOBJ;
        jsOBJ.executeScript("arguments[0].click();",checkBoxOBJ);
        // Thread.sleep(3000);
        // edit-submit
        // driverOBJ.findElement(By.id("edit-submit")).click();
        // Thread.sleep(3000);

        WebElement submitBtn = driverOBJ.findElement(By.id("edit-submit"));
        jsOBJ.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        Thread.sleep(3000);

        List<WebElement> userAssertionRead = driverOBJ.findElements(By.className("form-control"));
        String userNameActual = userAssertionRead.get(0).getAttribute("value");
        String userPhoneNumberActual = userAssertionRead.get(1).getAttribute("value");

        // Modify the date to be in the desired format (MM/dd/yyyy)
        String userDateActual = userAssertionRead.get(2).getAttribute("value");
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try
        {
            date = originalFormat.parse(userDateActual);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        String formattedDate = targetFormat.format(date);

        String userEmailActual = userAssertionRead.get(3).getAttribute("value");
        String userTellYourselfActual = userAssertionRead.get(4).getAttribute("value");

        // Declare expected values
        String userNameExpected = "MD SALAHIN";
        String userPhoneNumberExpected = "01568260741";
        String userDateExpected = "10/06/2025";
        String userEmailExpected = "salahin1999@gmail.com";
        String userTellYourselfExpected = "Hi this is me salahin";

        Assertions.assertEquals(userNameExpected, userNameActual, "User name does not match");
        Assertions.assertEquals(userPhoneNumberExpected, userPhoneNumberActual, "Phone number does not match");
        Assertions.assertEquals(userDateExpected, formattedDate, "Date does not match");
        Assertions.assertEquals(userEmailExpected, userEmailActual, "Email does not match");
        Assertions.assertEquals(userTellYourselfExpected, userTellYourselfActual, "Self description does not match");
    }
    @Test
    public void scrapTableData()
    {
        driverOBJ.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        //$$('.inner-scroll') $$('.table-responsive') table-responsive inner-scroll
        //amra akta table niya e kaj krtasi multiple se jno kintu element no elements ok?>?
        //ar pura table tai akta webElement amra ayta ke rkbo web element ar modhe
         WebElement tableObj =  driverOBJ.findElement(By.className("inner-scroll"));
    }

    @Test
    public void scrapTableData1()
    {
        driverOBJ.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        WebDriverWait wait = new WebDriverWait(driverOBJ, Duration.ofSeconds(30));
        // Find the table container
        WebElement tableObj = driverOBJ.findElement(By.className("inner-scroll"));
        // ---- Print data rows -----------
        // Find all rows inside the table (usually <tr> elements)
        List<WebElement> allRows = tableObj.findElements(By.tagName("tr"));

        // Loop through each row
        for (WebElement row : allRows)
        {
            // Find all cells in the row (<td> elements)
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells)
            {
                System.out.print(cell.getText() + " | "); // this is a separate by "|" this
            }
            System.out.println();
        }
    }
    @AfterAll
    //FOR QUIT
    public void quitDriver()
    {
        driverOBJ.quit();
        //driverOBJ.close();
    }
}
