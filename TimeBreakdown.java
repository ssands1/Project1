import java.util.* ;

// Saves time commitments in a hashtable and allows users to view the sum of the time spent 
// and the breakdown
public class TimeBreakdown {
    private static Hashtable<String, Integer> time; //Hashtable to store task and time durations
    
    public  TimeBreakdown() {
        time = new Hashtable<String, Integer> ();
    }
 
    // sums total time and time breakdown in percents
    public void totaltime() {
        int sum = 0;

        // push all task w/ lower priority than inserted task onto stack
        if (time != null && !time.isEmpty()) {
                Set<String> keys = time.keySet();
                for (String key : keys) {
                        Integer duration = time.get(key);
                        sum += duration;
                    }
                for (String key : keys) {
                        Integer duration = time.get(key);
                        double percent = ((double) duration/sum) * 100.00;
                        System.out.println(key + ": " + duration + " min " + percent + "%");
                    }
                }
    }
    
    public void add_commit(String task, Integer duration) {
        time.put((String) task, (Integer) duration);
    }
    
    private static Scanner sc = new Scanner(System.in); // System in
    
    public static void main(String[] args) {
        TimeBreakdown tb = new TimeBreakdown();  

        String task = "";
        for (int i = 0; !task.equals("End") ; i++) {
            
            System.out.println("Task: ");
            task = sc.next();

            System.out.println("Time (min): ");
            Integer time = sc.nextInt();

            tb.add_commit(task, time);
        }
        tb.totaltime();
        // System.out.print(time.toString());
    }
}