package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.task.Todo;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that adds a new Todo task.
 */
public class TodoCommand extends Command {
    private final String description;

    /**
     * Constructs a TodoCommand with the given task description.
     *
     * @param description The description of the todo task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the todo command by creating and adding a new Todo task.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying confirmation.
     * @param storage The storage handler for persisting the new task.
     * @throws JeffException If the description is empty.
     * @throws IOException   If saving to file fails.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (description.isEmpty()) {
            throw new JeffException("OOPS!!! The description of a todo cannot be empty.");
        }
        Task t = new Todo(description);
        tasks.add(t);
        ui.showTaskAdded(t, tasks.size());
        storage.saveTasks(tasks);
    }
}