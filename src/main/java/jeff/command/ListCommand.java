package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;

public class ListCommand extends Command {
    @Override
    public void execute(Task[] tasks, int[] taskCount) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount[0]; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
}