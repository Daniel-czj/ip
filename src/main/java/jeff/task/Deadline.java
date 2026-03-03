package jeff.task;

/**
 * Represents a Deadline task — a task that must be done by a specific time.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Returns the deadline time.
     *
     * @return The deadline time as a string.
     */
    public String getBy() {
        return by;
    }

    /**
     * Constructs a Deadline task.
     *
     * @param description The description of the task.
     * @param by          The deadline time.
     */
    public Deadline(String description, String by) {
        super(description,false);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
