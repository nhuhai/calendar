
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
class CalendarEvent implements Comparable<CalendarEvent> {

    private String name;
    private Calendar startDate, endDate;
    private boolean repeating;

    CalendarEvent(String name, Calendar startDate, Calendar endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        repeating = false;
    }

    CalendarEvent(String name, Calendar startDate, Calendar endDate, boolean repeating) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repeating = repeating;
    }

    @Override
    public int compareTo(CalendarEvent o) {
        return startDate.compareTo(o.startDate);
    }

    String getName() {
        return name;
    }

    int getYear() {
        return startDate.get(Calendar.YEAR);
    }

    int getStartMonth() {
        return startDate.get(Calendar.MONTH);
    }

    int getEndMonth() {
        return endDate.get(Calendar.MONTH);
    }

    String getDays() {
        Calendar temp = GregorianCalendar.getInstance();
        temp.setTime(startDate.getTime());
        String ret = "";
        while (temp.getTimeInMillis() <= endDate.getTimeInMillis()) {
            ret += CalendarModel.getWeekdayShortName(temp.get(Calendar.DAY_OF_WEEK));
            temp.add(Calendar.DAY_OF_YEAR, 1);
        }
        return ret;
    }

    int getStartTime() {
        return startDate.get(Calendar.HOUR_OF_DAY);
    }

    int getEndTime() {
        return endDate.get(Calendar.HOUR_OF_DAY);
    }

    Calendar getStartDate() {
        return startDate;
    }

    Calendar getEndDate() {
        return endDate;
    }

    boolean isRepeating() {
        return repeating;
    }
}
