package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;

public abstract class Command {

    public abstract void execute(Task[] tasks, int[] taskCount) throws JeffException;

    public boolean isExit() {
        return false;
    }
}