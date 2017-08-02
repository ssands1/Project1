import java.util.* ;

public class Planner {
    private static Map<String, Clock> activityLs; //time for an activity
    public static String name;
    public  Planner() {
        activityLs = new TreeMap<String, Clock> ();
        
    }
        
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Planner p = new Planner();
        
        String time;
    
        System.out.println("Name: ") ;
        name = scan.nextLine();
        
        for (int i = 1; true ; i++) {
            String activity = "";
            System.out.println("Item " + i);
            System.out.println("Activity: ");
            activity = scan.nextLine();
            if (activity.equalsIgnoreCase("end") || activity.equalsIgnoreCase("stop") || activity.equalsIgnoreCase("cancel"))
                break;
            System.out.println("Time: ");
            time = scan.nextLine();
            Clock clock = new Clock(time);
            activityLs.put(activity, clock);
        } 
        scan.close();

        //Map<String, Clock> timeline = new TreeMap<String, Clock>(activityLs);
        System.out.println("\n" + name);
        System.out.println(activityLs.toString());
        //System.out.println(timeline.toString());
    }
}