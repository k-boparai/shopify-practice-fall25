package ToDoList;
import java.time.LocalDate;
import java.util.*;

public class ToDoList {
    List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String desc, LocalDate due) {
        tasks.add(new Task(desc, due));
    }

    public void completeTask(int index) {
        if (index >= tasks.size() || index < 0) {
            System.out.println("Invalid tasks index.");
            return;
        }
        tasks.get(index).markCompleted();
        System.out.println("Task " + index + " is marked complete.");
    }

    public void printList() {
        System.out.println("To Do List:");
        if (tasks.size() == 0) {
            System.out.println("\tThere are no tasks in the list.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + i + ": " + tasks.get(i));
        }
    }

    public void printHelp() {
        System.out.println("Commands:");
        System.out.println("  add description ; YYYY-MM-DD (optional)");
        System.out.println("  list");
        // System.out.println("  filter completed");
        // System.out.println("  filter incomplete");
        System.out.println("  complete index");
        // System.out.println("  clear");
        System.out.println("  exit");
    }
}
