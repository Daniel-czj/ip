package jeff.command;

import java.util.ArrayList;

import jeff.task.*;

public class ListCommand extends Command {
    @Override

    public void execute(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}