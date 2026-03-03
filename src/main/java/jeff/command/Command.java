package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Represents an executable command in the Jeff application.
 * All concrete command classes must extend this class and implement {@link #execute}.
 */
public abstract class Command {

    /**
     * Executes the command with access to the task list, UI, and storage.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying output.
     * @param storage The storage handler for persisting tasks.
     * @throws JeffException If a user-facing error occurs.
     * @throws IOException   If a file I/O error occurs.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException;

    /**
     * Returns whether this command signals the application to exit.
     *
     * @return {@code true} if the app should exit, {@code false} otherwise.
     */
    public boolean isExit() {
        return false;
    }
}