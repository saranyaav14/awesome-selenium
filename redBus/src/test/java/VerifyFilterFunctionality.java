import library.components.Constant;
import library.pages.CommonMethods;
import library.pages.HomePage;
import library.pages.SearchResultPage;
import library.testBase.TestBase;
import library.testBase.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static library.testBase.Browser.setChromeProperties;
import static library.testBase.WebDriverService.getDriver;

/**
 * This is a test class which will search buses for given from and to locations and for given date
 */
public class VerifyFilterFunctionality extends TestBase {
    String month = HomePage.Month.MAR.getMonth();
    String year = "2020";
    String fromLocation = "Kanchipuram";
    String toLocation = "Coimbatore (All Locations)";
    String modifiedFromLocation = "Trichy";
    String modifiedToLocation = "Chennai (All Locations)";
    Map<String,String> currentDayDetails;
    String  futureDay;

    @Before
    public void getCurrentDayDetails(){
        Util util = new Util();
        currentDayDetails = util.getCurrentDateDetails();
        futureDay = util.increaseCurrentDateByXDays(2);

    }


    /**
     * test method
     */
    @Test
    public void search()  {

        logger.info("SET UP WEB DRIVER");
        setChromeProperties();


        logger.info("GO TO URL");
        launchPage(Constant.BASE_URL);

        logger.info("ADD FROM AND TO LOCATION");
        HomePage homePage = new HomePage();
        homePage.enterLocation(HomePage.Location.FROM_LOCATION.getLocation(),fromLocation);
        homePage.selectLocationFromDropdown(fromLocation);
        homePage.enterLocation(HomePage.Location.TO_LOCATION.getLocation(),toLocation);
        homePage.selectLocationFromDropdown(toLocation);

        logger.info("SELECT FROM DATE");
        waitForPageLoad();
        homePage.selectMonthAndYear(year,month);
        homePage.selectDate(currentDayDetails.get("day"));
        waitForPageLoad();

        logger.info("SELECT TO DATE");
        homePage.clickDatePicker(HomePage.DateLocator.RETURN_DATE.toString());
        waitForPageLoad();
        homePage.selectMonthAndYear(year,month);
        homePage.selectDate(futureDay);

        logger.info("CLICK ON SEARCH BUTTON");
        homePage.clickButton(HomePage.Button.SEARCH_BTN.getButton());
        waitForPageLoad();

        logger.info("GET NO OF BUSES");
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.printDetails();

        logger.info("Apply bus type filter");
        searchResultPage.clickOnButton(SearchResultPage.Filter.SEATER.getFilter());
        Assert.assertTrue(getElement(SearchResultPage.FILTER_LABEL,SearchResultPage.Filter.SEATER.getFilter()).isDisplayed());
        getDriver().quit();
    }
}
