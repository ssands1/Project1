import java.util.* ;
public class TaskManager {
    private static Hashtable<Integer, String> taskManager; //TaskManager for user
    
    public  TaskManager() {
        Hashtable<Integer, String> taskManager = new Hashtable<Integer, String> ();    
        
    }
    
    //place new task as priority n, move all other task down a priority
    public void add_task(Integer priority, String task) {
      /*  String oldTask = "";
        Stack oldTasks = new Stack();
        
        // push all task w/ lower priority than inserted task onto stack
        for (Integer task_priority: taskManager) {
            if (task_priority >= priority) {
                oldTask = taskManager.get(task_priority);
                oldTasks.push(oldTask);
            }
        }
        
        int size = taskManager.size;
        
        // place task back one priortity lower than original
        for (int i = priority; i < size; i++) {
            String task = oldTask.pop;
            taskManager*/
    }
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        StdOut.println("Name: ") ;
        String name = StdIn.readString() ;
        String task = "";
        Integer priority = 0;
        for (int i = 0; !task.equals("End") ; i++) {
            System.out.println("Priority: ");
            priority = StdIn.readInt();
            System.out.println("Task: ");
            task = StdIn.readString();
            if (taskManager.get(priority) != null) {
                tm.add_task(priority, task);
            }
                
            taskManager.put(priority, task);
        }
    }
}