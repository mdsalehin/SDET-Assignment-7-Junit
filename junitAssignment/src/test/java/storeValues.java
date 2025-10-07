/*public class storeValues
{
    public static void main(String[] args)
    {
        String filePathObj = "./src/test/resources/cellValuesText";
    }
}*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class storeValues
{
    public static void main(String[] args) throws IOException
    {
        String filePath = "./src/test/resources/cellValuesText.txt";
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        // this is Locate by the table
        WebElement tableObj = driver.findElement(By.className("inner-scroll"));
        List<WebElement> allRows = tableObj.findElements(By.tagName("tr"));

        FileWriter fw = new FileWriter(filePath);
        for (WebElement row : allRows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells)
            {
                fw.write(cell.getText() + " | "); // Write each of the cell
            }
            fw.write("\n");
        }

        fw.close();
        System.out.println("Data successfully written to " + filePath);
        driver.quit();
    }
}
