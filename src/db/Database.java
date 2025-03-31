package db;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();

    public Database() {

    }

    public static void add(Entity entity) {
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
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == entity.id) {
                entities.set(i, entity.copy());
                return;
            }
        }
        throw new EntityNotFoundException();
    }
}
