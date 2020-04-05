package library.testBase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class
 */
public class Util extends TestBase{

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
     * Returns current details as map
     * @return
     */
    public Map<String,String> getCurrentDateDetails() {
        LocalDate currentDate = LocalDate.now(); // 2016-06-17
        String month = String.valueOf(currentDate.getMonth()).toLowerCase();
        month = month.substring(0,3);
        Map<String,String> details = new HashMap<>();
        details.put("day",String.valueOf(currentDate.getDayOfMonth()));
        details.put("month",month);
        details.put("year",String.valueOf(currentDate.getYear()));
        return details;
    }

    /**
     * Increase date to the N days
     * @param days casesCount of the days
     * @return date increased by N days
     */
    public static String increaseCurrentDateByXDays(final int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }


}
