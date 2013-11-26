
import java.io.File;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
class CalendarModel {

    private Set<CalendarEvent> events;

    public CalendarModel() {
        events = new HashSet<>();
        //events may become TreeSet later, if sorting as TreeSet is easier.
    }

    public static String getWeekdayShortName(int weekDay) {
        String ret = "";
        switch (weekDay) {
            case Calendar.MONDAY:
                ret = "Mo";
                break;
            case Calendar.TUESDAY:
                ret = "Tu";
                break;
            case Calendar.WEDNESDAY:
                ret = "We";
                break;
            case Calendar.THURSDAY:
                ret = "Th";
                break;
            case Calendar.FRIDAY:
                ret = "Fr";
                break;
            case Calendar.SATURDAY:
                ret = "Sa";
                break;
            case Calendar.SUNDAY:
                ret = "Su";
                break;
        }
        return ret;
    }

    public void addEvent(CalendarEvent event) {
        boolean overlaps = false;
        for (Iterator<CalendarEvent> it = events.iterator(); it.hasNext() && (overlaps == false);) {
            CalendarEvent e = it.next();
            if ((event.getStartDate().getTimeInMillis() <= e.
                    getEndDate().getTimeInMillis()) && (event.
                    getEndDate().getTimeInMillis() >= e.getStartDate().
                    getTimeInMillis())) {
                overlaps = true;
            }
        }
        //Checked if events are overlapping. Make sure that viewer catches the following exception and displays an error window saying that the dates overlap
        if (overlaps) {
            throw new IllegalArgumentException();
        } else {
            events.add(event);
        }
    }

    public void addEvents(File input) {
        //Add events from input file. Use addEvent(CalendarEvent) for each event in the input file.
    }
}
