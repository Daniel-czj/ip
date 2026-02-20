package jeff.command;

import java.util.ArrayList;

import jeff.exception.JeffException;
import jeff.task.Deadline;
import jeff.task.Task;

public class DeadlineCommand extends Command {
    private final String arguments;

    public DeadlineCommand(String arguments) {
        this.arguments = arguments == null ? "" : arguments.trim();
    }

    @Override
    public void execute(ArrayList<Task> tasks) throws JeffException {
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

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list");
    }
}