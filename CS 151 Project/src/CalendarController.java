import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * The controller part for the calendar project containing all the listeners
 * 
 * @author Christopher Raleigh
 * @author Roberto Villasenor
 * @author Hai Nguyen
 */
public class CalendarController
{

    private CalendarModel model;
    private CalendarEvent event;
    
    /*
     * Listener for the Day View button
     */
    class DayViewListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    /*
     * Listener for the Week View button
     */
    class WeekViewListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    /*
     * Listener for the Month View button
     */
    class MonthViewListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    /*
     * Listener for the Agenda View button
     */
    class AgendaViewListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    /*
     * Listener for the Create button
     */
    class CreateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            event = new CalendarEvent(null, null, null);
            model.addEvent(event);
        }
        
    }
    
    /*
     * Listener for the From File button
     */
    class FromFileListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    }
    
    /*
     * Listener for the Next Month button
     */
    class NextMonthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    /*
     * Listener for the Previous Month button
     */
    class PreviousmonthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
