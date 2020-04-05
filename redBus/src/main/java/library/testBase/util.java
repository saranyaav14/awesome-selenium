package library.testBase;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class
 */
public class util {

    /**
     * Returns current details as map
     * @return
     */
    public Map<String,String> getCurrentDate() {
        LocalDate currentDate = LocalDate.now(); // 2016-06-17
        Map<String,String> details = new HashMap<>();
        details.put("date",String.valueOf(currentDate.getDayOfMonth()));
        details.put("month",String.valueOf(currentDate.getMonth()));
        details.put("year",String.valueOf(currentDate.getYear()));
        return details;
    }

}
