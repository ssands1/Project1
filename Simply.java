import java.util.* ;
public class Planner {
    private Hashtable<String, String[]> plan; //Planner for a User
     
    public  Planner() {
       Hashtable<String, String[]> plan = new Hashtable<String, String[]> ();
       String[] plan1 = new String[3];
       plan1[0] = "CHM 215 Lecture";
       plan1[1] = "COS 226 Precept";
       plan1[2] = "MAT 202 Help Session";
       StdOut.println(Arrays.toString(plan1));
       plan.put("Todd", plan1);
       StdOut.println(plan);
       
       
    }


public static void main(String[] args) {
    Planner() ;
    
}
}