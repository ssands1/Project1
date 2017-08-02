import java.util.* ;
//import java.util.regex.MatchResult;

public class Planner {
    public static String name;
    private static Map<String, String> activityLs; // <time, activity>
    
    public  Planner(String n) {
        name = n;
        activityLs = new TreeMap<String, String> ();
    }

    public static void add(String time, String activity) {
        Clock clock = new Clock(time);
        activityLs.put(clock.toString(), activity);
         
    }

    public static String get(String time) {
        Clock clock = new Clock(time);
        return activityLs.get(clock.toString());
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
            System.out.println("Time: ");
            String time = scan.nextLine();
            p.add(time, activity);
            lastAdded = p.get(time);
        }

        scan.close();
        System.out.println("\n" + name);
        System.out.println(activityLs.toString()) ;       
        System.out.println(lastAdded);
    }
}