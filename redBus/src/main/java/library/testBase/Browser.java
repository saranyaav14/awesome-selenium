package library.testBase;

/**
 *  Browser Class
 */
public class Browser {

    /**
     * Set up chrome driver path
     */
    public  static void setChromeProperties(){
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("chrome.driver","78.0");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\test\\Documents\\awsome-selenium\\rb\\src\\main\\resources\\chromedriver.exe");
    }
}
