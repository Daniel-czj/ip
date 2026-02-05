public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description, boolean isDone) {
        setTask(description);
        setStatus(isDone);
    }
    public Task(){
        this(null, false);
    }
    public void setStatus(boolean status) {
        this.isDone = status;
    }
    public void setTask(String description) {
        this.description = description;
    } 
    public boolean getStatus(){
        return isDone;
    }
    public String getTask(){
        return description;
    }
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}