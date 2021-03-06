import java.util.* ;

// Saves future time committments time commitments in a hashtable and allows users to view the sum of the time spent 
// and the breakdown
public class WorkForecast {
    public static TimeBreakdown tb; //TimeBreakdown Object
    public static Hashtable<String, Double> time; //<task, time estimation>
    public static Hashtable<String, String> category_ls; // <task, category>
    public static Double sum; // sum of all task inputed
    
    public  WorkForecast() {
        tb = new TimeBreakdown();
        tb.time = new Hashtable<String, Double>();
        tb.category_ls = new Hashtable<String, String>();
        tb.sum = 0.00;
    }
    
    //free time assuming no calendar events for a given period
    public Double free_time(TimeBreakdown timeB) {
        return (24 - timeB.sumIt());  //free time assuming no calendar events
     
    }     
    
    public Double work_time(TimeBreakdown timeBreak) {
        return timeBreak.sumIt(); //total time for all text in a given period
    } 
    
    public String quality_time(Double n) {
        if (n > 42) {
            return "Very Good";
        }else if (n > 29) { 
            return "Good";
        }else if (n > 14) {
            return "Fair";
        }else if (n > 7) { 
            return "Bad";
        }else{
            return "Very Bad";
        }
    }
    private static Scanner sc = new Scanner(System.in); // System in
    
    public static void main(String[] args) {
         WorkForecast work = new WorkForecast();
        
        for (int i = 1; true ; i++) {
            System.out.println("Task " + i + ": ");
            String task = sc.next();
            if (task.equalsIgnoreCase("end") || task.equalsIgnoreCase("stop") || task.equalsIgnoreCase("cancel"))
                break;
            System.out.println("How long will this task take? (in hrs)");
            Double estimation = sc.nextDouble();
            System.out.println("How would you categorize this task?");
            String category = sc.next();
            tb.add_commit(task, category, estimation);
        }
        tb.totaltime();
        tb.timePerCategory();
        System.out.println("Free Time: " + work.free_time(tb) + " hr " + work.quality_time(work.free_time(tb)));
        System.out.println("Work Time: " + work.work_time(tb) + " hr ");
        
    }
}