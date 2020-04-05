package library.pages;

import library.testBase.TestBase;
import org.openqa.selenium.By;

import static library.testBase.WebDriverService.getDriver;

/**
 * Home Page Class
 * @author saranya
 */
public class HomePage extends TestBase {
    private static By TO_TEXT_BOX = By.xpath("//label[contains(.,'FROM')]/preceding::input");
    private static By DATE_LOCATOR = By.id("onward_cal");
    private static By SEARCH_BTN = By.id("search_btn");
    private static By DROPDOWN_LOCATOR = By.xpath("//ul[@class='autoFill']");
    private static String DROP_DOWN_LOCATOR = "//ul[@class='autoFill']/li[contains(.,'%1$s')]";
    private static By MONTH_TITLE = By.xpath("//div[@class='rb-calendar']//td[@class='monthTitle']");
    private static By CALENDER_NEXT_BUTTON = By.xpath("//div[@class='rb-calendar']//td[@class='next']");
    private static String CALENDER_DATE_LOCATOR = "//div[@class='rb-calendar']//td[text()='%1$s']";
    private static String DATE_PICKER_LOCATOR = "//label[contains(.,'Return Date')]";
    private static String INPUT_TEXT_BOX = "//input[@id='%1$s']";

    /**
     * Define location
     */
    public enum Location {
        FROM_LOCATION("src"),
        TO_LOCATION("dest");
        private String location;

        public String getLocation() {
            return location;
        }

        Location(String location) {
            this.location = location;
        }
    }

    /**
     * Define button
     */
    public enum Button {
        SEARCH("search_btn"),
        SEARCH_BTN("Search Buses");
        private String button;

        public String getButton() {
            return button;
        }

        Button(String button) {
            this.button = button;
        }

    }

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
    public enum Key{
        DAY("day"),
        YEAR("year"),
        MONTH("month");
        private String key;

        public String toString() {
            return key;
        }

        Key(String button) {
            this.key = key;
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
     * Define header bar
     */
    public enum Headers {
        HEADER_BAR("rh_header");
        private String header;

        private Headers(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }
    }

    /**
     * Add location to text box
     *
     * @param locatorName
     * @param location
     */
    public void enterLocation(String locatorName, String location) {
        addText(getDriver().findElement(By.xpath(String.format(INPUT_TEXT_BOX,locatorName))), location);

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
     * Clicks button
     *
     * @param buttonName
     */
    public void clickButton(String buttonName) {
        getDriver().findElement(By.xpath("//button[@id='search_btn']")).click();

    }

    /**
     * Selects date
     *
     * @param date
     * @param month
     * @param year
     */
    public void selectDate(String date, String month, String year) {
        String monthTiltle = month + " " + year;
    }


    /**
     * Selects month
     *
     * @param year
     * @param month
     */
    public void selectMonthAndYear(String year, String month) {
        String[] values = getMonthAndYearDetails();
        while (String.valueOf(values[1]).equals(year) == false) {
            getDriver().findElement(CALENDER_NEXT_BUTTON).click();
            values = getMonthAndYearDetails();
        }
        while (String.valueOf(values[0]).toLowerCase().equals(month.toLowerCase()) == false) {
            getDriver().findElement(CALENDER_NEXT_BUTTON).click();
            values = getMonthAndYearDetails();
        }
    }


    /**
     * Return month and year details
     *
     * @return
     */
    public String[] getMonthAndYearDetails() {
        waitForPageLoad();
        String actualText = getDriver().findElement(MONTH_TITLE).getText();
        String[] values = actualText.split(" ");
        return values;
    }

    /**
     * Selects date from date picker
     *
     * @param dateValue
     */
    public void selectDate(String dateValue) {
        getDriver().findElement(By.xpath(String.format(CALENDER_DATE_LOCATOR, dateValue))).click();
    }

    /**
     * Clicks date picer
     *
     * @param type
     */
    public void clickDatePicker(String type) {
        getDriver().findElement(By.xpath(String.format(DATE_PICKER_LOCATOR, type))).click();
    }

}
