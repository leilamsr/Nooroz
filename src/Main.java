import db.Database;
import example.Document;
import db.Validator;
import exception.InvalidEntityException;
import db.Entity;

public class Main {
    public static void main(String[] args) throws InvalidEntityException {
        // ثبت Validator برای Document به طور مستقیم
        Database.registerValidator(0, new Validator() {
            @Override
            public void validate(Entity entity) throws InvalidEntityException {
                if (!(entity instanceof Document)) {
                    throw new InvalidEntityException("نوع ورودی اشتباه است!");
                }

                Document document = (Document) entity;

                if (document.getContent() == null || document.getContent().isEmpty()) {
                    throw new InvalidEntityException("محتوا نمی‌تواند خالی باشد!");
                }
            }
        });

        Document doc = new Document("Eid Eid Eid");

        Database.add(doc);

        System.out.println("Document added");
        System.out.println("id: " + doc.id);
        System.out.println("content: " + doc.getContent());
        System.out.println("creation date: " + doc.getCreationDate());
        System.out.println("last modification date: " + doc.getLastModificationDate());
        System.out.println();

        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }

        doc.content = "This is the new content";

        Database.update(doc);

        System.out.println("Document updated");
        System.out.println("id: " + doc.id);
        System.out.println("content: " + doc.content);
        System.out.println("creation date: " + doc.getCreationDate());
        System.out.println("last modification date: " + doc.getLastModificationDate());
    }
}
