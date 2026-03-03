package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that deletes a task by index or name.
 */
public class DeleteCommand extends Command {

    private final String taskName;

    /**
     * Constructs a DeleteCommand with the given task index or name.
     *
     * @param taskName The 1-based index or name of the task to delete.
     */
    public DeleteCommand(String taskName) {
        this.taskName = taskName == null ? "" : taskName.trim();
    }

    /**
     * Executes the delete command by removing the matching task.
     * Accepts either a 1-based index (e.g. {@code delete 1}) or a task name.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying confirmation.
     * @param storage The storage handler for persisting the change.
     * @throws JeffException If the argument is empty or no match is found.
     * @throws IOException   If saving to file fails.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task number or name, e.g. delete 1");
        }

        int idx = tasks.resolveIndex(taskName);
        Task removed = tasks.remove(idx);
        ui.showTaskRemoved(removed, tasks.size());
        storage.saveTasks(tasks);
    }
}