package jeff.command;

import java.util.ArrayList;
import jeff.exception.JeffException;
import jeff.task.*;

public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(ArrayList<Task> tasks) throws JeffException {
        if (description.isEmpty()) {
            throw new JeffException("OOPS!!! The description of a todo cannot be empty.");
        }
        Task t = new Todo(description);
        tasks.add(t);

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list");
    }
}