package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static HashMap<Integer, Validator> validators = new HashMap<>();
    private static int currentId = 1;

    public Database() {

    }

    public static void add(Entity entity) {
        validataEntity(entity);

        entity.id = currentId++;

        if (entity instanceof Trackable) {
            Trackable trackable = (Trackable) entity;
            Date now = new Date();
            trackable.setCreationDate(now);
            trackable.setLastModificationDate(now);
        }
        entities.add(entity.copy());
    }

    public static Entity get(int id) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.id == id) {
                return entity.copy();
            }
        }
        throw new EntityNotFoundException();
    }

    public static void delete(int id) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.id == id) {
                entities.remove(e);
                return;
            }
        }
        throw new EntityNotFoundException();
    }

    public static void update(Entity entity) throws EntityNotFoundException {
        validataEntity(entity);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == entity.id) {
                if (entity instanceof Trackable) {
                    Trackable trackable = (Trackable) entity;
                    Date now = new Date();
                    trackable.setLastModificationDate(now);
                }
                entities.set(i, entity.copy());
                return;
            }
        }
        throw new EntityNotFoundException();
    }

    public static void registerValidator(int entityCode, Validator validator) {
        if (validators.containsKey(entityCode)) {
            throw new IllegalArgumentException("Validator تکراری است!");
        }
        validators.put(entityCode, validator);
    }

    public static void validataEntity(Entity entity) {
        Validator validator = validators.get(entity.getEntityCode());
        if (validator == null) {
            throw new EntityNotFoundException();
        }
        validator.validate(entity);
    }

    public static ArrayList<Entity> getAll(int entityCode) {
        ArrayList<Entity> result = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity.getEntityCode() == entityCode) {
                result.add(entity.copy());
            }
        }
        return result;
    }
}
