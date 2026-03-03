package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Deadline;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

/**
 * Represents the command that adds a new Deadline task.
 */
public class DeadlineCommand extends Command {
    private final String arguments;

    /**
     * Constructs a DeadlineCommand with the given argument string.
     *
     * @param arguments The raw arguments containing the description and /by time.
     */
    public DeadlineCommand(String arguments) {
        this.arguments = arguments == null ? "" : arguments.trim();
    }

    /**
     * Executes the deadline command by parsing arguments and adding a Deadline task.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying confirmation.
     * @param storage The storage handler for persisting the new task.
     * @throws JeffException If the description or /by time is missing.
     * @throws IOException   If saving to file fails.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (arguments.isEmpty()) {
            throw new JeffException("OOPS!!! The description of a deadline cannot be empty.");
        }

        // deadline <desc> /by <time>
        String[] parts = arguments.split("\\s*/by\\s*", 2);
        if (parts.length != 2) {
            throw new JeffException("OOPS!!! Use: deadline <task> /by <time>");
        }

        String desc = parts[0].trim();
        String by = parts[1].trim();

        if (desc.isEmpty()) {
            throw new JeffException("OOPS!!! The description of a deadline cannot be empty.");
        }
        if (by.isEmpty()) {
            throw new JeffException("OOPS!!! The /by time of a deadline cannot be empty.");
        }

        Task t = new Deadline(desc, by);
        tasks.add(t);
        ui.showTaskAdded(t, tasks.size());
        storage.saveTasks(tasks);
    }
}