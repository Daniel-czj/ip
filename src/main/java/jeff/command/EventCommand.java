package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Event;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

public class EventCommand extends Command {
    private final String arguments;

    public EventCommand(String arguments) {
        this.arguments = arguments == null ? "" : arguments.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (arguments.isEmpty()) {
            throw new JeffException("OOPS!!! The description of an event cannot be empty.");
        }

        String[] parts1 = arguments.split("\\s*/from\\s*", 2);
        if (parts1.length != 2) {
            throw new JeffException("OOPS!!! Use: event <task> /from <start> /to <end>");
        }

        String desc = parts1[0].trim();
        String[] parts2 = parts1[1].split("\\s*/to\\s*", 2);
        if (parts2.length != 2) {
            throw new JeffException("OOPS!!! Use: event <task> /from <start> /to <end>");
        }

        String from = parts2[0].trim();
        String to = parts2[1].trim();

        if (desc.isEmpty()) {
            throw new JeffException("OOPS!!! The description of an event cannot be empty.");
        }
        if (from.isEmpty() || to.isEmpty()) {
            throw new JeffException("OOPS!!! The /from and /to of an event cannot be empty.");
        }

        Task t = new Event(desc, from, to);
        tasks.add(t);
        ui.showTaskAdded(t, tasks.size());
        storage.saveTasks(tasks);
    }
}