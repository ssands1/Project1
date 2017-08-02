import java.util.* ;
import java.util.concurrent.TimeUnit;
public class TaskManager {
    private static Hashtable<Integer, String> taskManager; //TaskManager for user
    
    public  TaskManager() {
        taskManager = new Hashtable<Integer, String> ();
    }
    
    //place new task as priority n, move all other task down a priority
    public void add_task(Integer priority, String task) {
        String oldTask = "";
        Stack oldTasks = new Stack();
        
        // push all task w/ lower priority than inserted task onto stack
        if (taskManager != null) {
            if (!taskManager.isEmpty()) {
                Set<Integer> keys = taskManager.keySet();
                for (Integer key : keys) {
                    if (key >= priority) {
                        oldTask = taskManager.get(key);
                        oldTasks.push((String) oldTask);
                    }
                }
                
                int size = taskManager.size();
                
                // place task back one priortity lower than original
                for (int i = priority; i < size; i++) {
                    String temp_task = (String) oldTasks.pop();
                    taskManager.put (i + 1, temp_task);
                } 
            }
            taskManager.put(priority, task);
        }
    }
    private static Scanner sc = new Scanner(System.in); // System in
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        // System.out.println("Name: ") ;
        // String name = sc.nextLine() ;
        Integer priority = 1;
        for (int i = 0; !priority.equals(0) ; i++) {
            
            System.out.println("Priority: ");
            priority = sc.nextInt();
            
            /*try{
                Thread.sleep((long) 1000);
                
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // code for stopping current task so thread stops
            }*/
            
            System.out.println("Task: ");
            String task = sc.next();
            
            tm.add_task(priority, task);
            
            if (taskManager != null) {
                taskManager.put(priority, task);
            }
        }
        System.out.print(taskManager.toString());
    }
}