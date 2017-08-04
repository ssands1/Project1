import java.util.* ;

// Saves future time committments time commitments in a hashtable and allows users to view the sum of the time spent 
// and the breakdown
public class WorkForecast {
    private static Planner work; //Hashtable to store task and time durations
    private static TimeBreakdown breakdown;
    
    public  WorkForecast(String name) {
        work = new Planner(name);
        breakdown = new TimeBreakdown();
    }
    
    /*public void add_commit(String task, Integer duration) {
        breakdown.time.put((String) task, (Integer) duration);
    }
    */
    public void free_time() {
        // int fT_week = 144 - some call to total time in task manager or breakdown
    }     
    
    public void work_time() {
        //int wT_week = total time in task manager or breakdown
    } 
    
    public String quality_time(int n) {
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
        /*TimeBreakdown tb = new TimeBreakdown();  
        
        String task = "";
        for (int i = 0; !task.equals("End") ; i++) {
            
            System.out.println("Task: ");
            task = sc.next();
            
            System.out.println("Time (min): ");
            Integer time = sc.nextInt();
            
            tb.add_commit(task, time);
        }
        tb.totaltime();
        System.out.print(time.toString());*/
    }
}