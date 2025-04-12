import db.Database;
import db.Entity;
import exception.InvalidEntityException;
import todo.entity.Step;
import todo.entity.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException {
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command :");
            String command = scn.nextLine().trim();

            switch (command.toLowerCase()) {
                case "add task" :
                    addTask();
                    break;

                case "add step" :
                    addStep();
                    break;

                case "delete" :
                    delete();
                    break;

                case "update" :
                    update();
                    break;

                case "update step" :
                    updateStep();
                    break;

                case "get task-by-id" :
                    getTaskById();
                    break;

                case "get all-tasks" :
                    getAllTasks();
                    break;

                case "exit" :
                    Exit();
                    break;

                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    public static void addTask() throws ParseException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter title :");
        String title = scn.nextLine();
        System.out.println("Enter description :");
        String description = scn.nextLine();
        System.out.println("Enter dueDate :");
        Date dueDate = dateFormat.parse(scn.nextLine());
        List<Step> steps = new ArrayList<>();
        Task task = new Task(title, description, dueDate, steps);
        try {
            Database.add(task);
            System.out.println("Task saved successfully.");
            System.out.println("ID: " + task.id);
        } catch (InvalidEntityException e) {
            System.out.println("Cannot save task.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addStep() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter title :");
        String title = scn.nextLine();
        System.out.println("Enter taskRef :");
        int taskRef = scn.nextInt();

        Task task;
        try {
            task = (Task) Database.get(taskRef);
        } catch (Exception e) {
            System.out.println("Cannot save step.");
            System.out.println("Error: Cannot find task with ID=" + taskRef);
            return;
        }

        Step step = new Step(title, taskRef);
        try {
            Database.add(step);
            System.out.println("Step saved successfully.");
            System.out.println("ID: " + step.id);
            System.out.println("Creation Date: " + task.getCreationDate());
        } catch (InvalidEntityException e) {
            System.out.println("Cannot save step.");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void delete() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = scn.nextInt();

        try {
            Database.delete(id);
            System.out.println("Entity with ID=" + id + " successfully deleted.");
        } catch (Exception e) {
            System.out.println("Cannot delete entity with ID=" + id + ".");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void update() throws ParseException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = scn.nextInt();
        System.out.println("Enter title :");
        String title = scn.nextLine();
        System.out.println("Enter description :");
        String description = scn.nextLine();
        System.out.println("Enter dueDate :");
        Date dueDate = dateFormat.parse(scn.nextLine());

    }

    public static void updateStep() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = scn.nextInt();
        System.out.println("Enter title :");
        String title = scn.nextLine();
        System.out.println("Enter taskRef :");
        int taskRef = scn.nextInt();
    }

    public static void getTaskById() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = scn.nextInt();

        try {
            Task task = (Task) Database.get(id);
            System.out.println("ID: " + task.id);
            System.out.println("Title: " + task.getTitle());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Status: " + task.getStatus());

            List<Step> steps = task.getSteps();
            if (steps.isEmpty()) {
                System.out.println("No steps available.");
            } else {
                System.out.println("Steps:");
                for (Step step : steps) {
                    System.out.println(" + " + step.getTitle() + ":");
                    System.out.println("ID: " + step.id);
                    System.out.println("Status: " + step.getStatus());
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot find task with ID=" + id);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getAllTasks() {
        int entityCode = 1;
        ArrayList<Entity> entities = Database.getAll(entityCode);
        List<Task> tasks = new ArrayList<>();

        for (Entity entity : entities) {
            if (entity instanceof Task) {
                tasks.add((Task) entity);
            }
        }

        tasks.sort(Comparator.comparing(Task::getDueDate));

        for (Task task : tasks) {
            System.out.println("ID: " + task.id);
            System.out.println("Title: " + task.getTitle());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Status: " + task.getStatus());
            List<Step> steps = task.getSteps();
            if (!steps.isEmpty()) {
                System.out.println("Steps:");
                for (Step step : steps) {
                    System.out.println(step.getTitle() + ":");
                    System.out.println("ID: " + step.id);
                    System.out.println("Status: " + step.getStatus());
                }
            }
        }
    }

    public static void Exit() {
        System.exit(0);
    }
}
