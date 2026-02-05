import java.util.Scanner;

public class Jeff {
    public static void main(String[] args) {
        String logo = " (_)     / _|/ _|  \n"
                + "  _  ___| |_| |_  \n"
                + " | |/ _ \\  _|  _| \n"
                + " | |  __/ | | |  \n"
                + " | |\\___|_| |_|   \n"
                + "_/ |             \n"
                + "|__/         \n";
        System.out.println("Hello from\n" + logo);
        // echo();
        run();
    }

    // public static void echo() {
    // while(true){
    // String line;
    // Scanner in = new Scanner(System.in);
    // line = in.nextLine();
    // System.out.println("______________________________________________" );
    // System.out.println(" " +line);
    // System.out.println("_______________________________________________" );
    // }
    // }
    public static void run() {
        Task[] tasks = new Task[100];
        int CountOfTasks = 0;
        String line;
        Scanner in = new Scanner(System.in);
        while (true) {
            line = in.nextLine();
            System.out.println("______________________________________________");
            if (line.equals("bye")) {
                System.out.println(" Bye. Hope to see you again soon!");
                break;
            } else if (line.contains("mark")) {
                if (line.contains("unmark")) {
                    System.out.println("OK, I've marked this task as not done yet:");
                    for (int i = 0; i < CountOfTasks; i++) {
                        if (line.equals("unmark " + tasks[i].getTask())) {
                            tasks[i].setStatus(false);
                        }
                    }
                } else {
                    System.out.println("Nice! I've marked this task as done:");
                    for (int i = 0; i < CountOfTasks; i++) {
                        if (line.equals("mark " + tasks[i].getTask())) {
                            tasks[i].setStatus(true);
                        }
                    }
                }
            } else if (line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < CountOfTasks; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
            } else if (line.startsWith("todo ")) {
                String desc = line.substring(5);
                Task t = new Todo(desc);
                tasks[CountOfTasks] = t;
                CountOfTasks++;

                System.out.println("Got it. I've added this task:");
                System.out.println("  " + t);
            } else if (line.startsWith("todo ")) {

                String task = line.substring(5);

                Todo newTask = new Todo(task);
                tasks[CountOfTasks] = newTask;
                CountOfTasks++;

                System.out.println("Got it. I've added this task:");
                System.out.println("  " + newTask);
            }

            else if (line.startsWith("deadline ")) {

                String rest = line.substring(9);
                String[] parts = rest.split(" /by ");

                String task = parts[0];
                String by = parts[1];

                Deadline newTask = new Deadline(task, by);
                tasks[CountOfTasks] = newTask;
                CountOfTasks++;

                System.out.println("Got it. I've added this task:");
                System.out.println("  " + newTask);
            }

            else if (line.startsWith("event ")) {

                String rest = line.substring(6);

                String[] parts1 = rest.split(" /from ");
                String task = parts1[0];

                String[] parts2 = parts1[1].split(" /to ");

                String from = parts2[0];
                String to = parts2[1];

                Event newTask = new Event(task, from, to);
                tasks[CountOfTasks] = newTask;
                CountOfTasks++;

                System.out.println("Got it. I've added this task:");
                System.out.println("  " + newTask);
            }

            else {
                Task NewTask = new Task(line, false);
                tasks[CountOfTasks] = NewTask;
                CountOfTasks++;
                System.out.println(" Added: " + line);
            }
            System.out.println("Now you have " + CountOfTasks + " tasks in the list");
            System.out.println("______________________________________________");
        }
    }
}
