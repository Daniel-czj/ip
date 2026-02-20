package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;

public class ByeCommand extends Command {

    @Override
    public void execute(Task[] tasks, int[] taskCount) {
        System.out.println(" Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}