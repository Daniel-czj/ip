package jeff.command;

import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

/**
 * Represents the command that exits the application.
 */
public class ByeCommand extends Command {

    /**
     * Executes the bye command by displaying the farewell message.
     *
     * @param tasks   The current list of tasks (not used).
     * @param ui      The UI handler for displaying the goodbye message.
     * @param storage The storage handler (not used).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showBye();
    }

    /**
     * Returns {@code true} to signal the application to exit.
     *
     * @return {@code true} always.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}