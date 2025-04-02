import db.Database;
import example.Human;
import example.HumanValidator;
import exception.InvalidEntityException;

public class Main {
    public static void main(String[] args) throws InvalidEntityException {
        Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

        Human ali = new Human("Ali", 10);
        try {
            Database.add(ali);
        } catch (InvalidEntityException e) {
            System.err.println("خطا در ثبت اطلاعات: " + e.getMessage());
        }
    }
}