package jeff.task;  

/**
 * Represents a Todo task — a task with no date or time attached.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with the given description.
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description, false);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
