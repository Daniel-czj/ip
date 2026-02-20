package jeff.command;

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
    public void execute(Task[] tasks, int[] taskCount) throws JeffException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task name, e.g. mark homework");
        }

        boolean found = false;
        for (int i = 0; i < taskCount[0]; i++) {
            if (tasks[i] != null && taskName.equals(tasks[i].getTask())) {
                tasks[i].setStatus(markDone);
                found = true;

                if (markDone) {
                    System.out.println("Nice! I've marked this task as done:");
                } else {
                    System.out.println("OK, I've marked this task as not done yet:");
                }
                System.out.println("  " + tasks[i]);
                break;
            }
        }

        if (!found) {
            throw new JeffException("OOPS!!! I can't find a task named: " + taskName);
        }
    }
}