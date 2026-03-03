package jeff.command;

import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

/**
 * Represents the command that lists all tasks.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all current tasks.
     *
     * @param tasks   The current list of tasks to display.
     * @param ui      The UI handler for displaying the task list.
     * @param storage The storage handler (not used).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}