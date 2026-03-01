package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Deadline;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

public class DeadlineCommand extends Command {
    private final String arguments;

    public DeadlineCommand(String arguments) {
        this.arguments = arguments == null ? "" : arguments.trim();
    }

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