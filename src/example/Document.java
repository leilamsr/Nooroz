package example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    private Date CreationDate;
    private Date LastModificationDate;
    public String content;

    public Document(String content) {
        this.content = content;
        this.CreationDate = new Date();
        this.LastModificationDate = new Date();
    }

    public String getContent() {
        return content;
    }

    @Override
    public void setCreationDate(Date date) {
        this.CreationDate = date;
    }

    @Override
    public Date getCreationDate() {
        return CreationDate;
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.LastModificationDate = date;
    }

    @Override
    public Date getLastModificationDate() {
        return LastModificationDate;
    }

    @Override
    public Entity copy() {
        Document copyDocument = new Document(this.content);
        copyDocument.id = this.id;
        copyDocument.CreationDate = this.CreationDate;
        copyDocument.LastModificationDate = this.LastModificationDate;
        return copyDocument;
    }

    @Override
    public int getEntityCode() {
        return 0;
    }
}
