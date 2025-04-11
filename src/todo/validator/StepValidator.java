package todo.validator;

import db.Validator;
import db.Entity;
import todo.entity.Step;
import exception.InvalidEntityException;

public class StepValidator implements Validator {

    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Step)) {
            throw new InvalidEntityException("موجودیت باید از نوع Step باشد!");
        }

        Step step = (Step) entity;

        if (step.getTitle() == null || step.getTitle().trim().isEmpty()) {
            throw new InvalidEntityException("عنوان قدم نمی‌تواند خالی باشد!");
        }

        if (step.getTaskRef() <= 0) {
            throw new InvalidEntityException("taskRef باید یک شناسه معتبر باشد!");
        }
    }
}
