/******************************************************************************
  *  Name:    Spencer Sands
  *  NetID:   ssands
  *  Precept: P14A
  * 
  *  Description: Please note that most of this description and all method 
  *               descriptions come directly from the exam sheet. This program 
  *               represents time on a 24-hour clock, such as 00:00, 13:30, or 
  *               23:59. Time is measured in hours (00 - 23) and minutes (00 - 
  *               59). There are methods for returning the clock as a string, 
  *               testing to see if the clock is earlier than another clock,
  *               and advancing the clock one minute, as well as a main method
  *               for testing these methods. 
  *  
  *****************************************************************************/
public class Clock 
{
    private int hour;   // the clock's hour
    private int minute; // the clock's minute
    
    // creates a clock whose initial time is h hours and m minutes
    public Clock(int h, int m)
    {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and "
                                              + "59 inclusive and hours must be"
                                              + " between 0 and 23 inclusive");
        }
        hour = h;
        minute = m;
    }
    
    // creates a clock whose initial time is specified by a string,
    // using the format HH:MM
    public Clock(String time)
    {
        int colonIndex = time.indexOf(58); //58 is ASCII colon number
        if (colonIndex == -1) {
            hour = Integer.parseInt(time.substring(0,2));
            minute = 0;
        } else {            
            hour = Integer.parseInt(time.substring(0, colonIndex));
            minute = Integer.parseInt(time.substring(colonIndex + 1, colonIndex + 3));
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Minutes must be between 0 and "
                                                  + "59 inclusive and hours must be"
                                                  + " between 0 and 23 inclusive");
            }
        }
        if (time.toLowerCase().contains("pm") && hour != 12)
            hour += 12;
        else if (hour == 12 && time.toLowerCase().contains("am"))
            hour = 0;
    }
    
    // returns a string representation of this clock, using the format HH:MM
    public String toString()
    {
        StringBuilder sB = new StringBuilder();
        if (hour < 10) // 07:12 instead of 7:12
            sB.append("0");
        sB.append(hour + ":");
        if (minute < 10) // 12:07 instead of 12:7
            sB.append("0");
        sB.append(minute);
        return sB.toString();
    }
    
    // is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that)
    {
        if (this.hour + this.minute / 60.0 < that.hour + that.minute / 60.0)
            return true;
        return false;
    }
    
    // adds 1 minute to the time on this clock
    public void tic()
    {
        if (this.minute == 59) {
            this.minute = 0;
            this.hour++;
            if (this.hour == 24)
                this.hour = 0;
        }
        else 
            this.minute++;
    }
    
    // tests all instance methods in this class
    public static void main(String[] args)
    {
        // testing constructor and toString:
        Clock noon = new Clock(12, 0); // creates new clock with time 12:00
        noon.toString();               // prints said clock
        Clock midnight = new Clock(0, 0); // creates new clock with time 0:00
        midnight.toString();              // prints said clock
        Clock eleven59PM = new Clock(23, 59); // creates a new clock with 11:59
        eleven59PM.toString();                  // prints said clock
        Clock a1 = new Clock("01:14");
        
        // testing isEarlierThan()
        System.out.println("Noon is earlier than midnight: " 
                           + noon.isEarlierThan(midnight));
        System.out.println("Noon is earlier than 23:59: " 
                           + noon.isEarlierThan(eleven59PM));
        // advances each clock five minutes
        for (int i = 0; i < 5; i++) {
            noon.tic();
            midnight.tic();
            eleven59PM.tic();
            a1.tic();
        }
        System.out.println("Five minutes after 12:00, 0:00, and 23:59 respectively "
                           + "are:\n"
                           + noon.toString() + "\n" + midnight.toString() + "\n"
                           + eleven59PM.toString());
    }
}