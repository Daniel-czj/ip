package jeff.task;

/**
 * Represents an Event task — a task that occurs over a specific time range.
 */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Returns the start time of the event.
     *
     * @return The start time as a string.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the end time of the event.
     *
     * @return The end time as a string.
     */
    public String getTo() {
        return to;
    }

    /**
     * Constructs an Event task.
     *
     * @param description The description of the event.
     * @param from        The start time.
     * @param to          The end time.
     */
    public Event(String description, String from, String to) {
        super(description,false);
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        return "[E]" + super.toString() +
                " (from: " + from + " to: " + to + ")";
    }
}