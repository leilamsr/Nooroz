package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;
import java.util.List;

public class Task extends Entity implements Trackable {

    private String title;
    private String description;
    private Date dueDate;
    private Status status;
    private List<Step> steps;

    private Date creationDate;
    private Date lastModificationDate;

    public Task(String title, String description, Date dueDate, List<Step> steps) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        setStatus(Status.NotStarted);
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    @Override
    public Date getCreationDate() {
        return this.creationDate;
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.lastModificationDate = date;
    }

    @Override
    public Date getLastModificationDate() {
        return this.lastModificationDate;
    }

    @Override
    public Entity copy() {
        return new Task(this.title, this.description, this.dueDate, this.steps);
    }

    @Override
    public int getEntityCode() {
        return this.id;
    }

    public enum Status {
        NotStarted,
        InProgress,
        Completed
    }
}

