package db;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("موجودیت مورد نظر یافت نشد!");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int id) {
        super( "موجودیتی با شناسه " + id + "یافت نشد!");
    }

}
