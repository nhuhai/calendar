
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A CalendarEvent has a name, a start time, and an end time.
 *
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
public class CalendarEvent implements Comparable<CalendarEvent> {

    private String name;
    private Calendar startDate, endDate;
    private boolean repeating;

    /**
     * Constructs a new CalendarEvent. A CalendarEvent has a name, a start time,
     * and an end time.
     *
     * @param name the event's name
     * @param startDate the event's start time
     * @param endDate the event's end time
     */
    public CalendarEvent(String name, Calendar startDate, Calendar endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        repeating = false;
    }

    /**
     * Constructs a new CalendarEvent. A CalendarEvent has a name, a start time,
     * and an end time.
     *
     * @param name the event's name
     * @param startDate the event's start time
     * @param endDate the event's end time
     * @param repeating whether the event repeats every week
     */
    public CalendarEvent(String name, Calendar startDate, Calendar endDate, boolean repeating) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repeating = repeating;
    }

    @Override
    public int compareTo(CalendarEvent o) {
        return startDate.compareTo(o.startDate);
    }

    /**
     * Returns the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the year of the event's start time.
     *
     * @return the year of the event's start time
     */
    public int getYear() {
        return startDate.get(Calendar.YEAR);
    }

    /**
     * Returns the month of the event's start time.
     *
     * @return the month of the event's start time
     */
    public int getStartMonth() {
        return startDate.get(Calendar.MONTH);
    }

    /**
     * Returns the month of the event's end time.
     *
     * @return
     */
    public int getEndMonth() {
        return endDate.get(Calendar.MONTH);
    }

    /**
     * Returns an ArrayList of each day of the week that the event spans, in
     * order.
     *
     * @return an ArrayList of each day of the week that the event spans
     */
    public ArrayList<Integer> getDays() {
        Calendar temp = GregorianCalendar.getInstance();
        temp.setTime(startDate.getTime());
        ArrayList<Integer> ret = new ArrayList<>();
        while (temp.getTimeInMillis() <= endDate.getTimeInMillis()) {
            ret.add(temp.get(Calendar.DAY_OF_WEEK));
            temp.add(Calendar.DAY_OF_YEAR, 1);
        }
        return ret;
    }

    /**
     * Returns the hour of the event's start time.
     *
     * @return the hour of the event's start time
     */
    public int getStartTime() {
        return startDate.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the hour of the event's end time.
     *
     * @return the hour of the event's end time
     */
    public int getEndTime() {
        return endDate.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Returns the event's start time as a Calendar.
     *
     * @return the event's start time
     */
    Calendar getStartDate() {
        return startDate;
    }

    /**
     * Returns the event's end time as a Calendar.
     *
     * @return the event's end time
     */
    Calendar getEndDate() {
        return endDate;
    }

    /**
     * Returns whether the event repeats weekly.
     *
     * @return whether the event repeats weekly
     */
    public boolean isRepeating() {
        return repeating;
    }
}
