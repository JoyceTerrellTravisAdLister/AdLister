package models;

import java.sql.Timestamp;

public class Ad {
    private long userId;
    private long id;
    private String title;
    private String description;
    private Timestamp timeCreated;

    public Ad() { }

    public Ad(long id, long userId, String title, String description, Timestamp timeCreated){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.timeCreated = timeCreated;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.timeCreated = new Timestamp(System.currentTimeMillis());
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }
}
