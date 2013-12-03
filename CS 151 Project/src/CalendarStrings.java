
import java.util.Calendar;
import java.util.Collection;

/**
 * The CalendarStrings contains useful strings that the viewer can use.
 *
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
public class CalendarStrings {

    /**
     * Returns a two-letter abbreviation of the specified day of the week.
     *
     * @param weekDay the day of the week
     * @return a two-letter abbreviation of the specified day of the week
     */
    public static String getWeekdayShortName(int weekDay) {
        switch (weekDay) {
            case Calendar.MONDAY:
                return "Mo";
            case Calendar.TUESDAY:
                return "Tu";
            case Calendar.WEDNESDAY:
                return "We";
            case Calendar.THURSDAY:
                return "Th";
            case Calendar.FRIDAY:
                return "Fr";
            case Calendar.SATURDAY:
                return "Sa";
            case Calendar.SUNDAY:
                return "Su";
            default:
                return "";
        }
    }

    /**
     * Returns the specified day of the week as an int.
     *
     * @param weekDay a two-letter abbreviation of the specified day of the week
     * @return the day of the week as an int
     */
    public static int getWeekdayInt(String weekDay) {
        switch (weekDay) {
            case "Mo":
                return Calendar.MONDAY;
            case "Tu":
                return Calendar.TUESDAY;
            case "We":
                return Calendar.WEDNESDAY;
            case "Th":
                return Calendar.THURSDAY;
            case "Fr":
                return Calendar.FRIDAY;
            case "Sa":
                return Calendar.SATURDAY;
            case "Su":
                return Calendar.SUNDAY;
            default:
                return -1;
        }
    }

    /**
     * Prints a set of CalendarEvents as a string.
     *
     * @param events the events to print out
     * @return the CalendarEvents as a string
     */
    public static String getEventsAsString(Collection<CalendarEvent> events) {
        String ret = "";
        for (CalendarEvent e : events) {
            ret += e.getName() + ";" + e.getYear() + ";" + e.getStartMonth() + ";" + e.getEndMonth() + ";" + e.getStartTime() + ";" + e.getEndTime() + ";\n";
        }
        return ret;
    }
}
