package db;

import java.util.ArrayList;

public class Database {
    private ArrayList<Entity> entities = new ArrayList<>();

    public Database() {
        throw new UnsupportedOperationException("این کلاس قابل نمونه سازی نیست!");
    }

    public void add(Entity e) {
        entities.add(e);
    }

    public Entity get(int id) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.id == id) {
                return e;
            }
        }
        throw new EntityNotFoundException();
    }

    public void delete(int id) throws EntityNotFoundException {
        for (Entity e : entities) {
            if (e.id == id) {
                entities.remove(e);
                return;
            }
        }
        throw new EntityNotFoundException();
    }

    public void update(Entity e) throws EntityNotFoundException {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                entities.set(i, e);
                return;
            }
        }
        throw new EntityNotFoundException();
    }
}
