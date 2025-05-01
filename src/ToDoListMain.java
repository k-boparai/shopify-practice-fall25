import java.time.LocalDate;
import java.util.Scanner;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ToDoList application.");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("exit"))
                break;
            if (input.equals("help")) {
                list.printHelp();
                continue;
            }
            if (input.equals("list")) {
                list.printList();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            switch (command) {
                case "add":
                    String[] argParts = argument.split(";", 2);
                    String desc = argParts[0];
                    LocalDate date = null;
                    if (argParts.length == 2) {
                        try {
                            date = LocalDate.parse(argParts[1].trim());
                        }
                        catch (Exception ex) {
                            System.out.println("Invalid date format.");
                            continue;
                        }
                    }
                    list.addTask(desc, date);
                    System.out.println("Task added to list.");
                    break;
                
                case "complete":
                    try {
                        int index = Integer.parseInt(argument);
                        list.completeTask(index);
                    }
                    catch (Exception ex) {
                        System.out.println("Invalid index provided.");
                        continue;
                    }
                    break;
                
                default:
                    System.out.println("Please provide a valid input.");
            }

        }

        System.out.println("Thanks for using this app.");
        scanner.close();
    }
}
