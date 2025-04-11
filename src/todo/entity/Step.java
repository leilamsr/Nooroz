package todo.entity;

import db.Entity;
import jdk.net.SocketFlow;

public class Step extends Entity {
    private String title;
    private Status status;
    private int taskRef;

    public Step(String title, Status status, int taskRef) {
        this.title = title;
        this.status = status;
        this.taskRef = taskRef;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTaskRef() {
        return taskRef;
    }

    public void setTaskRef(int taskRef) {
        this.taskRef = taskRef;
    }

    @Override
    public Entity copy() {
        return new Step(this.title, this.status, this.taskRef);
    }

    @Override
    public int getEntityCode() {
        return this.id;
    }

    public enum Status {
        NotStarted,
        Completed
    }
}
