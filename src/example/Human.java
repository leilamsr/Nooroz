package example;

import db.Entity;

public class Human extends Entity {
    public static String name;
    public static int age;

    public Human(String name) {
        this.name = name;
    }

    public Human(int age) {
        this.age = age;
    }

    @Override
    public Human copy() {
        Human copyHuman = new Human(name);
        copyHuman.id = id;
        copyHuman.age = age;

        return copyHuman;
    }
}
