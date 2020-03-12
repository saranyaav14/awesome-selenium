import org.junit.Test;

import library.pages.HomePage;
import library.testBase.TestBase;
import library.components.Constant;

import static library.testBase.Browser.setChromeProperties;
import static library.testBase.WebDriverService.getDriver;

/**
 * This is a test class which will search buses for given from and to locations and for given date
 */
public class searchForBuses extends TestBase {
    String month = HomePage.Month.MAR.getMonth();
    String year = "2020";

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
        String location = "Kanchipuram";
        String toLocation = "Coimbatore (All Locations)";
        HomePage homePage = new HomePage();
        homePage.enterLocation(HomePage.Location.FROM_LOCATION.getLocation(),"Kanchi");
        homePage.selectLocationFromDropdown(location);
        homePage.enterLocation(HomePage.Location.TO_LOCATION.getLocation(),toLocation);
        homePage.selectLocationFromDropdown(toLocation);

        logger.info("SELECT FROM DATE");
        waitForPageLoad();
        homePage.selectMonthAndYear(year,month);
        homePage.selectDate("13");
        waitForPageLoad();

        logger.info("SELECT TO DATE");
        homePage.clickDatePicker(HomePage.DateLocator.RETURN_DATE.toString());
        waitForPageLoad();
        homePage.selectMonthAndYear(year,month);
        homePage.selectDate("22");

        logger.info("CLICK ON SEARCH BUTTON");
        homePage.clickButton(HomePage.Button.SEARCH_BTN.getButton());

        logger.info("QUITS DRIVER");
        getDriver().quit();
    }
}
