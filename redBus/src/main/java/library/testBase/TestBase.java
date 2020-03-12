package library.testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static library.testBase.WebDriverService.getDriver;
import static library.testBase.WebDriverService.driver;

/**
 * Test base class
 */
public class TestBase {
    public Logger logger = Logger.getLogger(TestBase.class.getName());
    private static String HEADER_TEMPLATE = "//header[@id='%1$s']";
    private static String BUTTON_TEMPLATE = "//button[contains(.,'%1$s')]";

    /**
     * Redirect page to given url
     * @param url
     */
    public void goToURL(String url){
        getDriver().get(url);
        waitForPageLoad();
        getDriver().manage().window().maximize();
    }

    /**
     * Sets up chrome driver properties
     */
    public static void setUpDriver(){
        Browser browser = new Browser();
        browser.setChromeProperties();
    }

    /**
     * Launches page
     * @param url
     */
    public void launchPage(String url){
        setUpDriver();
        goToURL(url);
    }

    /**
     * Enters text
     * @param element
     * @param text
     */
    public void addText(WebElement element,String text){
        element.sendKeys(text);
    }

    /**
     * Make webdriver to Wait for given amount of time
     */
    public void waitForPageLoad(){
        getDriver().manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
    }

    /**
     * Clicks an element
     * @param element
     * @param text
     */
    public void click(WebElement element, String text) {
//        Assert.checkNonNull(element.isDisplayed());
        element.click();
    }

    /**
     * Selects value from dropdown
     * @param locator
     * @param value
     */
    public void selectFromDropDown(String locator,String value){
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(locator))));
        List<WebElement> dropdownValues =  getDriver().findElements(By.xpath(locator));
        for (WebElement dropdownValue : dropdownValues) {
//            logger.info("value is"+dropdownValue.getText());
//            String actual = dropdownValue.getText();

            if (dropdownValue.
                    getText().contentEquals(value)) {
                logger.info("------------------ inside if block-----------------------------------");
                dropdownValue.click();
                break;
            }
        }
    }

    /**
     * Clicks Header bar
     * @param element
     */
    public void clickHeader(String element){
        WebElement header = driver.findElement(By.xpath(String.format(HEADER_TEMPLATE,element)));
        header.click();
    }

    /**
     * Clicks button
     * @param element
     */
    public void clickButton(String element){
        WebElement btn = driver.findElement(By.xpath(String.format(BUTTON_TEMPLATE,element)));
        btn.click();
    }
}
