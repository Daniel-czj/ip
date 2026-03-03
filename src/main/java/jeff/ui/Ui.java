package jeff.ui;

import jeff.task.Task;
import jeff.task.TaskList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all user-facing input and output for the Jeff application.
 */
public class Ui {
    private static final String LINE = "______________________________________________";
    private final Scanner in;

    /**
     * Constructs a Ui instance and initialises the input scanner.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Displays the welcome message and logo on startup.
     */
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

    /**
     * Prints a horizontal divider line.
     */
    public void showLine() {
        System.out.println(LINE);
    }

    /**
     * Reads a line of input from the user.
     *
     * @return The user's input as a string.
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a warning when saved tasks cannot be loaded.
     */
    public void showLoadingError() {
        System.out.println("Warning: could not load saved tasks. Starting with empty list.");
    }

    /**
     * Displays the goodbye message when the user exits.
     */
    public void showBye() {
        System.out.println(" Bye. Hope to see you again soon!");
    }

    /**
     * Displays confirmation that a task was added.
     *
     * @param task       The task that was added.
     * @param totalTasks The total number of tasks after adding.
     */
    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list");
    }

    /**
     * Displays confirmation that a task was removed.
     *
     * @param task       The task that was removed.
     * @param totalTasks The total number of tasks remaining.
     */
    public void showTaskRemoved(Task task, int totalTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
    }

    /**
     * Displays confirmation that a task was marked or unmarked.
     *
     * @param task   The task that was updated.
     * @param isDone {@code true} if marked done, {@code false} if unmarked.
     */
    public void showTaskMarked(Task task, boolean isDone) {
        if (isDone) {
            System.out.println("Nice! I've marked this task as done:");
        } else {
            System.out.println("OK, I've marked this task as not done yet:");
        }
        System.out.println("  " + task);
    }

    /**
     * Displays all tasks in the task list.
     *
     * @param tasks The TaskList to display.
     */
    public void showTaskList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Displays tasks that matched a find query.
     *
     * @param results The list of matching tasks.
     */
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

    /**
     * Closes the input scanner.
     */
    public void close() {
        in.close();
    }
}
