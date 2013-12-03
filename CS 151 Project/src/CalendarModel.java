
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * @deprecated The new method is CalendarStrings.getWeekdayShortName
     */
    @Deprecated
    public static String getWeekdayShortName(int weekDay) {
        return CalendarStrings.getWeekdayShortName(weekDay);
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
    public void addEvents(File input) throws FileNotFoundException {
        /*Adds events from input file.
         Uses addEvent(CalendarEvent) for each event in the input file.*/
        Scanner scanner = new Scanner(input);
        String currentLine;
        HashSet<CalendarEvent> newEvents = new HashSet<>();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            String[] elements = currentLine.split(";");
            String name = elements[0];
            int year = Integer.parseInt(elements[1]);
            int startMonth = Integer.parseInt(elements[2]);
            int endMonth = Integer.parseInt(elements[3]);
            ArrayList<Integer> days = new ArrayList<>();
            //Add days from elements[4].
            int startTime = Integer.parseInt(elements[5]);
            int endTime = Integer.parseInt(elements[6]);
            //Add event.
        }
    }

    /**
     * Returns a TreeSet of the events stored in this CalendarModel.
     *
     * @return a TreeSet of the events stored in this CalendarModel
     */
    TreeSet<CalendarEvent> getEvents() {
        return events;
    }
}
