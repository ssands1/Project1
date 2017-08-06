import java.util.*;

public class Simply {
    // Declare for Planner
    public Planner p; // Planner Object
    public String name;
    private Map<String, String> activityLs; // <start time, activity>
    private Map<String, Double> activityTime; // <activity, duration>*/
    
    // Declare for TaskManager
    public static TaskManager tm; // Time Managment Object
    /*private static Hashtable<String, Double> time; // <task, time estimation>
     private static Hashtable<String, Boolean> completed; // <task, complete?>
     private static Hashtable<String, Double> deadline_ls; // <task, time until deadline>*/
    
    //Declare for TimeBreakdown & WorkForecast
    private static TimeBreakdown tb; // TimeBreakdown Object
    private static WorkForecast work; // Work Object
    /*private static Hashtable<String, Double> time; //<task, time estimation>
     private static Hashtable<String, String> category_ls; // <task, category>
     private static Double sum; // sum of all task inputed*/
    
    
    public Simply(String name){
        //initialize for Planner
        p = new Planner(name);
        
        //initialize for TaskManager
        tm = new TaskManager();
        /*tm.time = new Hashtable<String, Double>();
         tm.completed = new Hashtable<String, Boolean>();
         tm.deadline_ls = new Hashtable<String, Double>();*/
        
        //initialize for TimeBreakdown & WorkForecast
        tb = new TimeBreakdown();
        /*tb.time = new Hashtable<String, Double>();
         tb.category_ls = new Hashtable<String, String>();
         tb.sum = 0.00;*/
    }
    
    /* logins into app
     public void login() {
     // call User.java
     }*/
    
    // adds a task
    public void add_task(String task, String category, Double time, Double deadline) {
        tb.add_commit(task, category, time);
        tm.add_task(task, time, deadline);
    }
    
    // adds an event
    public void add_event(String time, String activity, String category, Double duration) {
        p.add(time, activity, duration);
        tb.add_commit(activity, category, duration);
    }
    
    // shows TimeBreakdown and WorkForecasting
    public void timeReport() {
        tb.totaltime();
        System.out.println();
        tb.timePerCategory();
        System.out.println();
        System.out.println("Free Time: " + work.free_time() + " hr " + work.quality_time(work.free_time()));
        System.out.println("Work Time: " + work.work_time() + " hr ");
    }
    
    // marks a task as complete
    public static void complete_task(String task) {
        tm.complete(task);
    }
    
    // shows all task w/ their status
    public static void task_list() {
        Set<String> keys = tm.completed.keySet();
        for (String key: keys) {
            System.out.println(tm.status(key));
        }
    }
    
    // shows all events
    public void view_planner(String lastAdded) {
        System.out.println("\n" + name);
        System.out.println(activityLs.toString()) ;       
        System.out.println(lastAdded);
    }
    private static Scanner sc = new Scanner(System.in); // System in
    
    public void main(String[] args) {
        System.out.println("Name: ") ;
        String n = sc.nextLine();
        Simply sim = new Simply(n);
        
        String lastAdded = "if you read this, no events were entered";
        
        //if (type == "Event") {
        for (int i = 1; true ; i++) {
            System.out.println("Task or Event?");
            Integer type = sc.nextInt();
            if (type == 0) {
                System.out.println("Activity " + i + ": ");
                String activity = sc.next();
                if (activity.equalsIgnoreCase("end") || activity.equalsIgnoreCase("stop") || activity.equalsIgnoreCase("cancel"))
                    break;
                System.out.println("Start Time: ");
                String time = sc.next();
                System.out.println("Duration: ");
                Double duration = sc.nextDouble();
                System.out.println("How would you categorize this task?");
                String category = sc.next();
                sim.add_event(time, activity, category, duration);
                lastAdded = p.get(time);
            }else if (type == 1) {
                System.out.println("Task " + i + ": ");
                String task = sc.next();
                if (task.equalsIgnoreCase("end") || task.equalsIgnoreCase("stop") || task.equalsIgnoreCase("cancel"))
                    break;
                System.out.println("How long will this task take? (in hrs)");
                Double estimation = sc.nextDouble();
                System.out.println("How would you categorize this task?");
                String category = sc.next();
                System.out.println("How much time do you have to complete this task? (in hrs)");
                Double deadline = sc.nextDouble();
                sim.add_task(task, category, estimation, deadline);
            }
        }
        
        if (p != null) {
            sim.view_planner(lastAdded);
        }
        
        System.out.println("General Time Report" + "/n");
        sim.timeReport();
        
        // print task list, then complete a tasl, then print again
        task_list();
        complete_task("COS_226");
        task_list();
        
        sc.close();
    }
}