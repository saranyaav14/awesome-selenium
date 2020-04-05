package library.pages;

import library.testBase.TestBase;
import org.openqa.selenium.By;

import static library.testBase.WebDriverService.getDriver;

/**
 * Class contains common methods across pages
 *
 * @author saranya
 */
public class CommonMethods extends TestBase {
    private static String DROP_DOWN_LOCATOR = "//ul[@class='autoFill']/li[contains(.,'%1$s')]";

    /**
     * Define Date locator
     */
    public enum DateLocator {
        ONWARD_DATE("onward_cal"),
        RETURN_DATE("return_cal");
        private String dateLocator;

        public String toString() {
            return dateLocator;
        }

        DateLocator(String dateLocator) {
            this.dateLocator = dateLocator;
        }
    }

    /**
     * Define Month
     */
    public enum Month {
        JAN("Jan"),
        FEB("Feb"),
        MAR("Mar"),
        APR("Apr"),
        MAY("May"),
        JUN("Jun"),
        JUL("Jul"),
        AUG("Aug"),
        SEP("Sep"),
        OCT("Oct"),
        NOV("Nov"),
        DEC("Dec");
        private String month;

        private Month(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
        }
    }

    /**
     * Selects location from dropdown
     *
     * @param value
     */
    public void selectLocationFromDropdown(String value) {
        String locator = String.format(DROP_DOWN_LOCATOR, value);
        selectFromDropDown(locator, value);
    }

    /**
     * Add location to text box
     *
     * @param locatorName
     * @param location
     */
    public void enterLocation(String locatorName, String location) {
        addText(getDriver().findElement(By.id(locatorName)), location);

    }

}
