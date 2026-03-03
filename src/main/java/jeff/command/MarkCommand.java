package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Represents a command that marks or unmarks a task as done.
 */
public class MarkCommand extends Command {
    private final String taskName;
    private final boolean markDone;

    /**
     * Constructs a MarkCommand.
     *
     * @param taskName The 1-based index or name of the task to mark or unmark.
     * @param markDone {@code true} to mark as done, {@code false} to unmark.
     */
    public MarkCommand(String taskName, boolean markDone) {
        this.taskName = taskName == null ? "" : taskName.trim();
        this.markDone = markDone;
    }

    /**
     * Executes the mark/unmark command, updating the task status and saving.
     * Accepts either a 1-based index (e.g. {@code mark 1}) or a task name.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying output.
     * @param storage The storage handler for persisting the change.
     * @throws JeffException If the argument is empty or no match is found.
     * @throws IOException   If saving to file fails.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task number or name, e.g. mark 1");
        }

        int idx = tasks.resolveIndex(taskName);
        tasks.get(idx).setStatus(markDone);
        ui.showTaskMarked(tasks.get(idx), markDone);
        storage.saveTasks(tasks);
    }
}