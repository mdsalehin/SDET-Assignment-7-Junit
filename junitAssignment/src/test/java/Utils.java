import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils
{
    public static void scroll(WebDriver driverOBJ,int px)
    {
        JavascriptExecutor jsScroll =  (JavascriptExecutor) driverOBJ;
        jsScroll.executeScript("window.scrollTo(0,"+px+")");
    }
}
