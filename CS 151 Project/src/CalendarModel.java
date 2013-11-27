
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * The CalendarModel contains a set of the CalendarEvents that a calendar can
 * use.
 *
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
public class CalendarModel {

    private TreeSet<CalendarEvent> events;

    /**
     * Constructs a new CalendarModel. The CalendarModel contains a set of the
     * CalendarEvents that a calendar can use.
     */
    public CalendarModel() {
        events = new TreeSet<>();
    }

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
     * Adds the specified event.
     *
     * @param event the event
     */
    public void addEvent(CalendarEvent event) {
        //Checks that the start time is not after the end time.
        if (event.getStartDate().compareTo(event.getEndDate()) > 0) {
            //Viewer catches the exception and displays an error window.
            throw new IllegalArgumentException();
        }
        /*Checks if events are overlapping.
         The set must be sorted to work.*/
        boolean done = false;
        for (Iterator<CalendarEvent> it = events.iterator(); it.hasNext() && (done == false);) {
            CalendarEvent e = it.next();
            //If the new event starts after this event.
            if (event.getStartDate().compareTo(e.getStartDate()) > 0) {
                //If the new event starts during this event.
                if (event.getStartDate().compareTo(e.getEndDate()) < 0) {
                    //Viewer catches the exception and displays an error window.
                    throw new IllegalArgumentException();
                } else {
                    done = true;
                }
            }
        }
        events.add(event);
    }

    /**
     * Removes the specified event from the CalendarModel.
     *
     * @param event the event
     * @return whether the removal was successful
     */
    boolean removeEvent(CalendarEvent event) {
        return events.remove(event);
    }

    /**
     * Removes all events from the CalendarModel.
     */
    void clearEvents() {
        events.clear();
    }

    /**
     * Adds multiple events from the specified file.
     *
     * @param input the file
     */
    public void addEvents(File input) {
        /*Adds events from input file.
         Uses addEvent(CalendarEvent) for each event in the input file.*/
    }

    /**
     * Returns a TreeSet of the events stored in this CalendarModel.
     *
     * @return a TreeSet of the events stored in this CalendarModel
     */
    public TreeSet<CalendarEvent> getEvents() {
        return events;
    }
}
