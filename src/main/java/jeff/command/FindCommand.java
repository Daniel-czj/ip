package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword == null ? "" : keyword.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException {
        if (keyword.isEmpty()) {
            throw new JeffException("OOPS!!! Please provide a keyword to search for.");
        }
        ArrayList<Task> results = tasks.find(keyword);
        ui.showMatchingTasks(results);
    }
}
