import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (add task, exit):");
            String command = scn.nextLine().trim();

            if (command.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (command.equals("add task")) {
                System.out.print("Enter Task Title: ");
                String title = scn.nextLine();

                System.out.print("Enter Task Description: ");
                String description = scn.nextLine();

                System.out.print("Enter Task Due Date (yyyy-mm-dd): ");
                String dueDate = scn.nextLine();

                System.out.println("Task saved successfully.");
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Due Date: " + dueDate);
            }
            else {
                System.out.println("Unknown command.");
            }
        }
    }
}
