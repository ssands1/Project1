import java.util.* ;

public class TaskManager {
    private static Hashtable<String, Double> time; // <task, time estimation>
    private static Hashtable<String, Boolean> completed; // <task, complete?>
    private static Hashtable<String, Double> deadline_ls; // <task, time until deadline>
    
    // initialize everything 
    public  TaskManager() {
        time = new Hashtable<String, Double>();
        completed = new Hashtable<String, Boolean>();
        deadline_ls = new Hashtable<String, Double>();
    }
    
    // add a new task
    public void add_task(String task, Double estimation, Double deadline) {
        time.put(task, estimation);
        deadline_ls.put(task, deadline);
        completed.put(task, false);
    }
    
    // mark a task as complete
    public static void complete(String task) {
        completed.put(task, true);
    }
    
    // check if a task is complete
    public String status(String task) {
        if (completed.get(task)){
            return "Complete";
        }else{
            return "Incomplete";
        }
    }
    
    // print all task w/ times and deadlines
    public String toString() {
        Set<String> keys = time.keySet();
        for (String key : keys) {
            System.out.println("Task: " + key);
            System.out.println("Estimated Task Time: " + time.get(key) + " hr");
            System.out.println("Time Until Deadline: " + deadline_ls.get(key) + " hr");
            System.out.println("Status: " + status(key));
        }
        return "";
    }
    
    private static Scanner sc = new Scanner(System.in); // System in
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        
        for (int i = 1; true ; i++) {
            System.out.println("Task " + i + ": ");
            String task = sc.next();
            if (task.equalsIgnoreCase("end") || task.equalsIgnoreCase("stop") || task.equalsIgnoreCase("cancel"))
                break;
            System.out.println("How long will this task take? (in hrs)");
            Double estimation = sc.nextDouble();
            System.out.println("How much time do you have to complete this task? (in hrs)");
            Double deadline = sc.nextDouble();
            tm.add_task(task, estimation, deadline);
        }
        System.out.print(tm.toString());
        complete("Eat");
        System.out.print(tm.toString());
    }
}
