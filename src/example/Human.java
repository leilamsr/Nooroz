package example;

import db.Entity;

public class Human extends Entity {
    public static String name;
    public static int age;
    public static final int HUMAN_ENTITY_CODE = 14;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Human copy() {
        Human copyHuman = new Human(name, age);
        copyHuman.id = id;
        copyHuman.age = age;

        return copyHuman;
    }

    @Override
    public int getEntityCode() {
        return HUMAN_ENTITY_CODE;
    }
}
