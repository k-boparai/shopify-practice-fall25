package ToDoList;
import java.time.LocalDate;

public class Task {
    private boolean completed;
    private String description;
    private LocalDate dueDate;

    public Task(String desc, LocalDate date) {
        completed = false;
        description = desc;
        dueDate = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public void markCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        String status = (completed) ? "[x] " : "[ ] ";
        String due = (dueDate != null) ? " (Due: " + dueDate + ")" : "";
        return status + description + due;
    }
}