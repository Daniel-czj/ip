package jeff.task;

/**
 * Represents a task in the Jeff application.
 * This is the base class for all task types (Todo, Deadline, Event).
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with a description and completion status.
     *
     * @param description The description of the task.
     * @param isDone      Whether the task is initially marked as done.
     */
    public Task(String description, boolean isDone) {
        setTask(description);
        setStatus(isDone);
    }
    /**
     * Constructs a default Task with no description and not done.
     */
    public Task(){
        this(null, false);
    }

    /**
     * Sets the completion status of the task.
     *
     * @param status {@code true} to mark as done, {@code false} to unmark.
     */
    public void setStatus(boolean status) {
        this.isDone = status;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The new description.
     */
    public void setTask(String description) {
        this.description = description;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return {@code true} if done, {@code false} otherwise.
     */
    public boolean getStatus(){
        return isDone;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getTask(){
        return description;
    }

    /**
     * Returns the status icon for display purposes.
     *
     * @return {@code "X"} if done, {@code " "} otherwise.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}