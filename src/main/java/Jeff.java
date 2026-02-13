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
        run();
    }

    private static void printLine() {
        System.out.println("______________________________________________");
    }

    public static void run() {
        Task[] tasks = new Task[100];
        int countOfTasks = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String line = in.nextLine();
                String trimmed = line.trim();
                printLine();
                if (trimmed.equals("bye")) {
                    System.out.println(" Bye. Hope to see you again soon!");
                    break;
                } else if (line.contains("mark")) {
                    if (line.contains("unmark")) {
                        System.out.println("OK, I've marked this task as not done yet:");
                        for (int i = 0; i < countOfTasks; i++) {
                            if (line.equals("unmark " + tasks[i].getTask())) {
                                tasks[i].setStatus(false);
                            }
                        }
                    } else {
                        System.out.println("Nice! I've marked this task as done:");
                        for (int i = 0; i < countOfTasks; i++) {
                            if (line.equals("mark " + tasks[i].getTask())) {
                                tasks[i].setStatus(true);
                            }
                        }
                    }
                } else if (trimmed.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < countOfTasks; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                } else if (trimmed.startsWith("todo")) {
                    String desc = "";
                    if (trimmed.length() > 4) {
                        desc = trimmed.substring(4).trim();
                    }
                    if (desc.isEmpty()) {
                        throw new JeffException("OOPS!!! The description of a todo cannot be empty.");
                    }

                    if (countOfTasks >= tasks.length) {
                        throw new JeffException("OOPS!!! Task list is full.");
                    }
                    Task t = new Todo(desc);
                    tasks[countOfTasks++] = t;

                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + t);
                    System.out.println("Now you have " + countOfTasks + " tasks in the list");
                    printLine();
                    continue;
                } else if (trimmed.startsWith("deadline ")) {

                    String rest = line.substring(9);
                    String[] parts = rest.split(" /by ");

                    String task = parts[0];
                    String by = parts[1];

                    Deadline newTask = new Deadline(task, by);
                    tasks[countOfTasks] = newTask;
                    countOfTasks++;

                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                } else if (trimmed
                        .startsWith("event ")) {

                    String rest = line.substring(6);

                    String[] parts1 = rest.split(" /from ");
                    String task = parts1[0];

                    String[] parts2 = parts1[1].split(" /to ");

                    String from = parts2[0];
                    String to = parts2[1];

                    Event newTask = new Event(task, from, to);
                    tasks[countOfTasks] = newTask;
                    countOfTasks++;

                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                } else {
                    throw new JeffException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

                System.out.println("Now you have " + countOfTasks + " tasks in the list");
                printLine();

            } catch (JeffException e) {
                System.out.println(" " + e.getMessage());
                printLine();
            }
        }
    }

}
