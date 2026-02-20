package jeff.command;

import jeff.exception.JeffException;
import jeff.task.*;
import java.util.ArrayList;

public abstract class Command {

    public abstract void execute(ArrayList<Task> tasks) throws JeffException;

    public boolean isExit() {
        return false;
    }
}