package todo.service;

import todo.entity.Task;
import exception.InvalidEntityException;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private static Map<Integer, Task> taskData = new HashMap<>();

    public static void setAsCompleted(int taskId) throws InvalidEntityException {
        Task task = taskData.get(taskId);

        if (task == null) {
            throw new InvalidEntityException("تسکی با این شناسه یافت نشد.");
        }

        task.setStatus(Task.Status.Completed);
        taskData.put(taskId, task);
    }

    public static void setAsInProgress(int taskId) throws InvalidEntityException {
        Task task = taskData.get(taskId);

        if (task == null) {
            throw new InvalidEntityException("تسکی با این شناسه یافت نشد!");
        }

        task.setStatus(Task.Status.InProgress);
        taskData.put(taskId, task);
    }

    public static void setAsNotStarted(int taskId) throws InvalidEntityException {
        Task task = taskData.get(taskId);

        if (task == null) {
            throw new InvalidEntityException("تسکی با این شناسه یافت نشد!");
        }

        task.setStatus(Task.Status.NotStarted);
        taskData.put(taskId, task);
    }

    public static void addTask(int taskId, Task task) {
        taskData.put(taskId, task);
    }
}
