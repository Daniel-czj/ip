package jeff;

import jeff.command.Command;
import jeff.exception.JeffException;
import jeff.parser.Parser;
import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Main class for the Jeff chatbot application.
 * Initialises the application components and runs the main event loop.
 */
public class Jeff {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a Jeff instance, loading saved tasks from the specified file.
     *
     * @param folder   The folder where the data file is stored.
     * @param fileName The name of the data file.
     */
    public Jeff(String folder, String fileName) {
        ui = new Ui();
        storage = new Storage(folder, fileName);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (JeffException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main loop of the application, reading and executing user commands
     * until the exit command is given.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readCommand();
                ui.showLine();
                Command c = Parser.parseCommand(input);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (JeffException e) {
                ui.showError(e.getMessage());
            } catch (IOException e) {
                ui.showError("Warning: failed to save tasks: " + e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        ui.close();
    }

    /**
     * Entry point of the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Jeff("data", "jeff.txt").run();
    }
}