import java.util.* ;
import java.text.*;

// Saves time commitments in a hashtable and allows users to view the sum of the time spent 
// and the breakdown
public class TimeBreakdown {
    public static Hashtable<String, Double> time; //<task, time estimation>
    public static Hashtable<String, String> category_ls; // <task, category>
    public static Double sum; // sum of all task inputed
    
    public  TimeBreakdown() {
        time = new Hashtable<String, Double>();
        category_ls = new Hashtable<String, String>();
        sum = 0.00;
    }
    
    //returns sum
    public Double sumIt(){
        return sum;
    }
    
    // outputs time for each task and time breakdown in percents
    public void totaltime() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        
        // prints all task w/ % of total time and category 
        if (time != null && !time.isEmpty()) {
            Set<String> keys = time.keySet();
            for (String key : keys) {
                Double duration = time.get(key);
                Double percent = (duration/sum) * 100.00;
                System.out.println(key + ": " + formatter.format(duration) + " hr " + formatter.format(percent) + "%");
                System.out.println("Category: " + category_ls.get(key));
            }
        }
    }
    
    public void timePerCategory() {
        NumberFormat formatter = new DecimalFormat("#0.00");
//print time by category
        Set<String> keys = category_ls.keySet();
        for (String key : keys) {
            String category = category_ls.get(key);
            Double time = categoryTime(category);
            System.out.println("Category: " + category);
            System.out.println(formatter.format(time));
        }
    }
    
    public Double categoryTime(String category) {
        Double t = 0.00;
        
        Set<String> keys = category_ls.keySet();
        for (String key: keys) {
            if (category_ls.get(key) == category) {
                t += time.get(key);
            }
        }
        return t;
    }
    public void add_commit(String task, String category, Double duration) {
        time.put((String) task, (Double) duration);
        category_ls.put(task, category);
        sum += duration;
    }
    
    private static Scanner sc = new Scanner(System.in); // System in
    
    public static void main(String[] args) {
        TimeBreakdown tb = new TimeBreakdown();  
        
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
    }
}