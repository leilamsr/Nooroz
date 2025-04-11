package todo.validator;

import db.Validator;
import db.Entity;
import todo.entity.Task;
import exception.InvalidEntityException;

public class TaskValidator implements Validator {

    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Task)) {
            throw new InvalidEntityException("Entity must be an instance of Task.");
        }

        Task task = (Task) entity;

        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new InvalidEntityException("Task title cannot be null or empty.");
        }
    }
}
