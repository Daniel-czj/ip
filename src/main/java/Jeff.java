import java.util.Scanner;

public class Jeff {
    public static void main(String[] args) {
        String logo = 
    " (_)     / _|/ _|  \n"
  + "  _  ___| |_| |_  \n"
  + " | |/ _ \\  _|  _| \n"
  + " | |  __/ | | |  \n"
  + " | |\\___|_| |_|   \n"
  + "_/ |             \n"
  + "|__/         \n";
        System.out.println("Hello from\n" + logo
        );
        //echo();
        List();
    }
    // public static void echo() {
    // while(true){
    //     String line;
    //     Scanner in = new Scanner(System.in);
    //     line = in.nextLine();
    //     System.out.println("______________________________________________" );
    //     System.out.println("      " +line);
    //     System.out.println("_______________________________________________" );
    // }
//}
    public static void List() {
        List[] tasks = new List[100];
        int CountOfTasks =0;
        String line;    
        Scanner in = new Scanner(System.in);
        while(true){
            line = in.nextLine();
            System.out.println("______________________________________________" );
            if (line.equals("bye")) {
                System.out.println(" Bye. Hope to see you again soon!");
                break;
            }
            else if (line.contains("mark")) {
                if(line.contains("unmark")) {
                    System.out.println("OK, I've marked this task as not done yet:" );
                    for(int i=0; i<CountOfTasks; i++){
                        if(line.equals("unmark " + tasks[i].getTask())){
                            tasks[i].setStatus(false);
                        }
                    }
                }
                else{
                    System.out.println("Nice! I've marked this task as done:" );
                    for(int i=0; i<CountOfTasks; i++){
                        if(line.equals("mark " + tasks[i].getTask())){
                            tasks[i].setStatus(true);
                        }
                    }
                }
            }
            else if (line.equals("list")) {
                 System.out.println("Here are the tasks in your list:");
                for(int i=0; i<CountOfTasks; i++){
                    System.out.println( (i+1) + ". " + "[" + (tasks[i].getStatus() == true ? "X" : " ") + "]" + tasks[i].getTask());
                }
            }
            else{
                List NewTask = new List(line,false);
                tasks[CountOfTasks] = NewTask;
                CountOfTasks++;
                System.out.println(" Added: " + line);
            }   
            System.out.println("______________________________________________" );
        } 
    }
}
