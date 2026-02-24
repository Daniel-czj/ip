package jeff;

import jeff.command.Command;
import jeff.exception.JeffException;
import jeff.parser.Parser;
import jeff.storage.Storage;
import jeff.task.Task;

import java.io.IOException;
import java.util.ArrayList;
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
        Storage storage = new Storage("data", "jeff.txt");

        ArrayList<Task> tasks;
        try {
            tasks = storage.loadTasks(); // ✅ load on startup
        } catch (JeffException e) {
            System.out.println("Warning: could not load saved tasks. Starting with empty list.");
            tasks = new ArrayList<>();
        }   

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String input = in.nextLine();
                printLine();
                Command c = Parser.parseCommand(input);
                c.execute(tasks);

                // ✅ auto-save after any mutating command
                if (c.isMutating()) {
                    storage.saveTasks(tasks);
                }

                if (c.isExit()) {
                    break;
                }
                printLine();
            } catch (JeffException e) {
                printLine();
                System.out.println(e.getMessage());
                printLine();
            } catch (IOException e) {
                // save error
                System.out.println("Warning: failed to save tasks: " + e.getMessage());
                printLine();
            }
        }

        in.close();
    }
}