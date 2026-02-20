package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;

public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(Task[] tasks, int[] taskCount) throws JeffException {
        if (description == null || description.trim().isEmpty()) {
            throw new JeffException("OOPS!!! The description of a todo cannot be empty.");
        }
        if (taskCount[0] >= tasks.length) {
            throw new JeffException("OOPS!!! Task list is full.");
        }

        Task t = new Todo(description.trim());
        tasks[taskCount[0]++] = t;

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + taskCount[0] + " tasks in the list");
    }
}