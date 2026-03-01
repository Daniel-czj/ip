package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.io.IOException;

public class MarkCommand extends Command {
    private final String taskName;
    private final boolean markDone;

    public MarkCommand(String taskName, boolean markDone) {
        this.taskName = taskName == null ? "" : taskName.trim();
        this.markDone = markDone;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException, IOException {
        if (taskName.isEmpty()) {
            throw new JeffException("OOPS!!! Please specify a task name, e.g. mark homework");
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (taskName.equals(tasks.get(i).getTask())) {
                tasks.get(i).setStatus(markDone);
                ui.showTaskMarked(tasks.get(i), markDone);
                storage.saveTasks(tasks);
                return;
            }
        }

        throw new JeffException("OOPS!!! I can't find a task named: " + taskName);
    }
}