package jeff;

import jeff.command.Command;
import jeff.exception.JeffException;
import jeff.parser.Parser;
import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

public class Jeff {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

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

    public static void main(String[] args) {
        new Jeff("data", "jeff.txt").run();
    }
}