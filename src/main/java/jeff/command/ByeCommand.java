package jeff.command;

import java.util.ArrayList;

import jeff.task.*;

public class ByeCommand extends Command {

    @Override
    public void execute(ArrayList<Task> tasks) {
        System.out.println(" Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}