package jeff.command;

import java.util.ArrayList;

import jeff.exception.JeffException;
import jeff.task.*;

public class MarkCommand extends Command {
    private final String taskName;
    private final boolean markDone;

    public MarkCommand(String taskName, boolean markDone) {
        this.taskName = taskName == null ? "" : taskName.trim();
        this.markDone = markDone;
    }

    @Override
    public boolean isMutating() {
        return true;
    }

    @Override
    public void execute(ArrayList<Task> tasks) throws JeffException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task name, e.g. mark homework");
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (taskName.equals(tasks.get(i).getTask())) {
                tasks.get(i).setStatus(markDone);
                if (markDone) {
                    System.out.println("Nice! I've marked this task as done:");
                } else {
                    System.out.println("OK, I've marked this task as not done yet:");
                }
                System.out.println("  " + tasks.get(i));
                return;
            }
        }

        throw new JeffException("OOPS!!! I can't find a task named: " + taskName);
    }
}