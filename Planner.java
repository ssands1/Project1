import java.util.* ;
public class Planner {
    private static Hashtable<Integer, String> activity_ls; //time for an activity
    
    public  Planner() {
        activity_ls = new Hashtable<Integer, String> ();
        
    }
    
    /*public String toString() {
        for (Hashtable plan: activity_ls) {
            plan.get(name);
        }
    }*/
    
    public static void main(String[] args) {
        Planner p = new Planner();
        StdOut.println("Name: ") ;
        
        String name = StdIn.readString() ;
        Integer time = 0;
        String activity = "";
        for (int i = 0; !activity.equals("End") ; i++) {
            System.out.println("Item " + i);
            System.out.println("Time: ");
            time = StdIn.readInt();
            System.out.println("Activity: ");
            activity = StdIn.readString();
            activity_ls.put(time, activity);
        }
        System.out.println(name);
        System.out.println(activity_ls.toString()) ;
        
    }
}