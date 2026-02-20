package jeff;

import jeff.command.Command;
import jeff.exception.JeffException;
import jeff.parser.Parser;
import jeff.task.Task;

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
    int[] countOfTasks = new int[]{0};

    Scanner in = new Scanner(System.in);

    while (true) {
        try {
            String line = in.nextLine();
            printLine();

            Command cmd = Parser.parseCommand(line);
            cmd.execute(tasks, countOfTasks);

            printLine();
            if (cmd.isExit()) {
                break;
            }
        } catch (JeffException e) {
            System.out.println(" " + e.getMessage());
            printLine();
        }
    }
}
}
