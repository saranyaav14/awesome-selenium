package library.pages;

import library.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static library.testBase.WebDriverService.getDriver;

/**
 * Search Result page class
 * @author saranya
 *
 */
public class SearchResultPage extends TestBase {
    private static final By BUS_COUNT_LOCATOR = By.xpath("//span[@class=w-60 d-block d-found]//span");
    private static final By BUS_DETAILS_LOCATOR = By.xpath("//ul[@class='bus-items']//div[@class = 'clearfix bus-item-details']");
    private static By CALENDER_NEXT_BUTTON = By.xpath("//div[@class='rb-calendar-month']//li[@class='rb-next active']");
    private static String CALENDER_DATE_LOCATOR = "//div[@id='rb-calmiddle']//li[@data-date='%1$s']";
    private static String DATE_PICKER_LOCATOR = "//input[@id='%1$s']";
    private static String MONTH_AND_YEAR_LOCATOR = "//div[@id='rb-calmiddle']//span[@id='%1$s']";
    private static String FILTER_TEMPLATE = "//labels[@title='%1$s']";
    public static String FILTER_LABEL = "//li[@title='%1$s']";
    public static String  FILTER_SECTION_DROPPING_POINT_TEMPLATE = "//div[text()='DROPPING POINT']/following::input[1]";
    public static String DROPPING_POINT_LOCATION_TEMPLATE = "//ul[@class='filterup-list']//li[@data-value='%1$s']";
    public static String APPLY_BUTTON_TEMPLATE = "//div[text()='APPLY']";


    /**
     * Define button
     */
    public enum Button {
        MODIFY("Modify"),
        SEARCH("SEARCH");
        private String button;

        public String getButton() {
            return button;
        }

        Button(String button) {
            this.button = button;
        }
    }
    /**
     * Define filter checkout button
     */
    public enum Filter {
        SEATER("SEATER"),
        SLEEPER("SLEEPER"),
        AC("AC"),
        NONAC("NONAC");
        private String button;

        public String getFilter() {
            return button;
        }

        Filter(String button) {
            this.button = button;
        }
    }

    /**
     * Define location
     */
    public enum Location {
        FROM_LOCATION("src"),
        TO_LOCATION("dest");
        private String location;

        public String toString() {
            return location;
        }

        Location(String location) {
            this.location = location;
        }
    }

    /**
     * Define location
     */
    public enum Calender {
        MONTH("rb-month"),
        YEAR("rb-year");
        private String calender;

        public String toString() {
            return calender;
        }

        Calender(String calender) {
            this.calender = calender;
        }
    }

    /**
     * Returns no of buses available
     *
     * @return
     */
    public String getCountOfBuses() {
        WebElement element = getDriver().findElement(BUS_COUNT_LOCATOR);
        return element.getText();

    }

    /**
     * Returns list of buses
     */
    public List<ArrayList> getBusDetails() {
        List<WebElement> buses = getDriver().findElements(BUS_DETAILS_LOCATOR);
        List<ArrayList> entireDetails = new ArrayList<>();
        for (WebElement bus : buses) {
            ArrayList<String> busDetail = new ArrayList<>();
            String busName = bus.findElement(By.xpath(".//div[@class='travels lh-24 f-bold d-color']")).getText();
            String availableSeats = bus.findElement(By.xpath(".//div[@class='seat-left m-top-30']")).getText();
            String busFare = bus.findElement(By.xpath(".//div[@class='fare d-block']")).getText();
            busDetail.add(busName);
            busDetail.add(availableSeats);
            busDetail.add(busFare);
            entireDetails.add(busDetail);
        }
        return entireDetails;
    }

    /**
     * prints Details of Bus
     */
    public void printDetails() {
        List<ArrayList> details = getBusDetails();
        for (ArrayList detail : details) {
            logger.info("\nBUS NAME : " + detail.get(0) + " , " + "AVAILABLE SEATS : " + detail.get(1) + " , " + "FARE : " + detail.get(2));
        }
    }

    /**
     * Return month or year
     *
     * @return
     */
    public String getMonthOrYear(String locator) {
        return getDriver().findElement(By.xpath(String.format(MONTH_AND_YEAR_LOCATOR, locator))).getText();
    }

    public void selectMonthAndYear(String year, String month) {
        while (getMonthOrYear(Calender.YEAR.toString()).equals(year) == false) {
            waitForPageLoad();
            WebElement next = getDriver().findElement(CALENDER_NEXT_BUTTON);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", next);

        }
        while (getMonthOrYear(Calender.MONTH.toString()).equals(month.toUpperCase()) == false) {
            WebElement next = getDriver().findElement(CALENDER_NEXT_BUTTON);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", next);
        }

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
     * Clicks date picker
     *
     * @param type
     */
    public void clickDatePicker(String type) {
        getDriver().findElement(By.xpath(String.format(DATE_PICKER_LOCATOR, type))).click();
    }
    /**
     * Add dropping point in popup
     *
     * @param location
     */
    public void addDroppingPoint(String location) {
        getDriver().findElement(By.xpath(String.format(DROPPING_POINT_LOCATION_TEMPLATE, location))).click();
    }

}
