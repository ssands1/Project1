import java.util.* ;
//import java.util.regex.MatchResult;

public class Planner {
    public static String name;
    public static Map<String, String> activityLs; // <start time, activity>
    public static Map<String, Double> activityTime; // <activity, duration>
    
    public  Planner(String n) {
        name = n;
        this.activityLs = new TreeMap<String, String> ();
        this.activityTime = new TreeMap<String, Double> ();
    }

    public void add(String time, String activity, Double duration) {
        Clock clock = new Clock(time);
        this.activityLs.put(clock.toString(), activity);
        this.activityTime.put(activity, duration);
    }

    public String get(String time) {
        Clock clock = new Clock(time);
        return this.activityLs.get(clock.toString());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        System.out.println("Name: ") ;
        String n = scan.nextLine();
        Planner p = new Planner(n);
        String lastAdded = "if you read this, no events were entered";
        for (int i = 1; true ; i++) {
            System.out.println("Activity " + i + ": ");
            String activity = scan.nextLine();
            if (activity.equalsIgnoreCase("end") || activity.equalsIgnoreCase("stop") || activity.equalsIgnoreCase("cancel"))
                break;
            System.out.println("Start Time: ");
            String time = scan.nextLine();
            System.out.println("Duration: ");
            Double duration = scan.nextDouble();
            p.add(time, activity, duration);
            lastAdded = p.get(time);
        }
        
        scan.close();
        System.out.println("\n" + name);
        // System.out.println(activityLs.toString()) ;       
        System.out.println(lastAdded);
    }
}