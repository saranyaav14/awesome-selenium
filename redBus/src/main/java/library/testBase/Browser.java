package library.testBase;

/**
 *  Browser Class
 */
public class Browser {

    /**
     * Returns path of remote driver
     * @return
     */
    public static String getPathOfDriver(){
        ClassLoader classLoader = Browser.class.getClassLoader();
        return classLoader.getResource("chromedriver.exe").getPath();
    }

    /**
     * Set up chrome driver path
     */
    public  static void setChromeProperties(){
        System.setProperty("webdriver.chrome.driver", getPathOfDriver());
    }
}
