package jeff.command;

import jeff.exception.JeffException;
import jeff.storage.Storage;
import jeff.task.Task;
import jeff.task.TaskList;
import jeff.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a command that searches for tasks containing a given keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand with the given search keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword == null ? "" : keyword.trim();
    }

    /**
     * Executes the find command by searching for tasks matching the keyword
     * and displaying the results.
     *
     * @param tasks   The current list of tasks.
     * @param ui      The UI handler for displaying results.
     * @param storage Not used by this command.
     * @throws JeffException If the keyword is empty.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException {
        if (keyword.isEmpty()) {
            throw new JeffException("OOPS!!! Please provide a keyword to search for.");
        }
        ArrayList<Task> results = tasks.find(keyword);
        ui.showMatchingTasks(results);
    }
}
