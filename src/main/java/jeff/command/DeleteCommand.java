package jeff.command;

import java.util.ArrayList;

import jeff.exception.JeffException;
import jeff.task.Task;

public class DeleteCommand extends Command {

    private final String taskName;

    public DeleteCommand(String taskName) {
        this.taskName = taskName == null ? "" : taskName.trim();
    }

    @Override
    public boolean isMutating() {
        return true;
    }

    @Override
    public void execute(ArrayList<Task> tasks) throws JeffException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task name, e.g. delete homework");
        }

        int idx = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (taskName.equals(tasks.get(i).getTask())) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            throw new JeffException("OOPS!!! I can't find a task named: " + taskName);
        }

        Task removed = tasks.remove(idx);

        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removed);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}