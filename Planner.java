import java.util.* ;
//import java.util.regex.MatchResult;

public class Planner {
    private static Hashtable<Clock, String> activityLs; //time for an activity
    public static String name;
    public  Planner() {
        activityLs = new Hashtable<Clock, String> ();
        
    }
        
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Planner p = new Planner();
        
        String time;
    
        System.out.println("Name: ") ;
        name = scan.next();
        
        for (int i = 1; true ; i++) {
            String activity = "";
            System.out.println("Item " + i);
            System.out.println("Activity: ");
            //MatchResult result = scan.match();
            //for (int j=1; j<=result.groupCount(); j++)
              //  System.out.println(result.groupCount());
            activity = scan.next();
            if (activity.equalsIgnoreCase("end") || activity.equalsIgnoreCase("stop") || activity.equalsIgnoreCase("cancel"))
                break;
            System.out.println("Time: ");
            time = scan.next();
            Clock clock = new Clock(time);
            activityLs.put(clock, activity);
        } 
        System.out.println("\n" + name);
        System.out.println(activityLs.toString()) ;
        scan.close();
    }
}