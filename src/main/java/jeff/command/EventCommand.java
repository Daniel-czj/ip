package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;

public class EventCommand extends Command {
    private final String arguments;

    public EventCommand(String arguments) {
        this.arguments = arguments == null ? "" : arguments.trim();
    }

    @Override
    public void execute(Task[] tasks, int[] taskCount) throws JeffException {
        if (arguments.isEmpty()) {
            throw new JeffException("OOPS!!! The description of an event cannot be empty.");
        }

        String[] parts1 = arguments.split("\\s*/from\\s*", 2);
        if (parts1.length != 2) {
            throw new JeffException("OOPS!!! Use: event <task> /from <start> /to <end>");
        }

        String task = parts1[0].trim();
        String[] parts2 = parts1[1].split("\\s*/to\\s*", 2);
        if (parts2.length != 2) {
            throw new JeffException("OOPS!!! Use: event <task> /from <start> /to <end>");
        }

        String from = parts2[0].trim();
        String to = parts2[1].trim();

        if (task.isEmpty()) {
            throw new JeffException("OOPS!!! The description of an event cannot be empty.");
        }
        if (from.isEmpty() || to.isEmpty()) {
            throw new JeffException("OOPS!!! The /from and /to of an event cannot be empty.");
        }
        if (taskCount[0] >= tasks.length) {
            throw new JeffException("OOPS!!! Task list is full.");
        }

        Task t = new Event(task, from, to);
        tasks[taskCount[0]++] = t;

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + taskCount[0] + " tasks in the list");
    }
}