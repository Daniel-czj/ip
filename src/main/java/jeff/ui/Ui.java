package jeff.ui;

import jeff.task.Task;
import jeff.task.TaskList;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final String LINE = "______________________________________________";
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = " (_)     / _|/ _|  \n"
                + "  _  ___| |_| |_  \n"
                + " | |/ _ \\  _|  _| \n"
                + " | |  __/ | | |  \n"
                + " | |\\___|_| |_|   \n"
                + "_/ |             \n"
                + "|__/         \n";
        System.out.println("Hello from\n" + logo);
    }

    public void showLine() {
        System.out.println(LINE);
    }

    public String readCommand() {
        return in.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("Warning: could not load saved tasks. Starting with empty list.");
    }

    public void showBye() {
        System.out.println(" Bye. Hope to see you again soon!");
    }

    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list");
    }

    public void showTaskRemoved(Task task, int totalTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    public void showTaskMarked(Task task, boolean isDone) {
        if (isDone) {
            System.out.println("Nice! I've marked this task as done:");
        } else {
            System.out.println("OK, I've marked this task as not done yet:");
        }
        System.out.println("  " + task);
    }

    public void showTaskList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showMatchingTasks(ArrayList<Task> results) {
        if (results.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + "." + results.get(i));
            }
        }
    }

    public void close() {
        in.close();
    }
}
