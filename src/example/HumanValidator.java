package example;

import db.Entity;
import db.Validator;
import exception.InvalidEntityException;

public class HumanValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Human)) {
            throw new InvalidEntityException("نوع ورودی اشتباه است!");
        }

        Human human = (Human) entity;

        if (human.age < 0) {
            throw new InvalidEntityException("سن اشتباه وارد شده است!");
        }

        if (human.name == null) {
            throw new InvalidEntityException("نام خود را وارد کنید!");
        }
    }
}

