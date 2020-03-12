package library.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Web driver service class
 */
public class WebDriverService {

    static WebDriver driver = new ChromeDriver();

    /**
     * Returns remote webDriver
     * @return
     */
    public static WebDriver getDriver(){
        return  driver;
    }


}
