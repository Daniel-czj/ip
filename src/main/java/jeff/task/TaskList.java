package jeff.task;

import java.util.ArrayList;

import jeff.exception.JeffException;

/**
 * Manages the list of tasks in the Jeff application.
 * Provides operations to add, remove, retrieve, and search tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList from an existing list of tasks.
     *
     * @param tasks The existing list of tasks to initialise with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes and returns the task at the given index.
     *
     * @param index The zero-based index of the task to remove.
     * @return The removed task.
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the task at the given index.
     *
     * @param index The zero-based index of the task.
     * @return The task at the specified index.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the underlying list of all tasks.
     *
     * @return The full {@code ArrayList} of tasks.
     */
    public ArrayList<Task> getAll() {
        return tasks;
    }


    /**
     * Resolves a task argument to a zero-based index.
     * If the argument is a number, it is treated as a 1-based index.
     * Otherwise, it is matched against task descriptions.
     *
     * @param arg The argument string (number or task name).
     * @return The zero-based index of the matching task.
     * @throws JeffException If the argument is invalid or no match is found.
     */
    public int resolveIndex(String arg) throws JeffException {
        try {
            int oneBasedIndex = Integer.parseInt(arg);
            int idx = oneBasedIndex - 1;
            if (idx < 0 || idx >= tasks.size()) {
                throw new JeffException(
                        "OOPS!!! Task index " + oneBasedIndex + " is out of range.");
            }
            return idx;
        } catch (NumberFormatException e) {
            for (int i = 0; i < tasks.size(); i++) {
                if (arg.equals(tasks.get(i).getTask())) {
                    return i;
                }
            }
            throw new JeffException("OOPS!!! I can't find a task named: " + arg);
        }
    }
    /**
     * Searches for tasks whose descriptions contain the given keyword (case-insensitive).
     *
     * @param keyword The keyword to search for.
     * @return A list of tasks matching the keyword.
     */
    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> results = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTask().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(task);
            }
        }
        return results;
    }
}
