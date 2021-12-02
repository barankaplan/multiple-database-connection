package com.example.demo.data.entity.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    public long id;

    @Column(name = "title", length = 128, nullable = false)
    public String title;

    @Column(name = "description", length = 512)
    public String description;

    @Column(name = "insert_date_time", nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();

    @Column(name = "completed", nullable = false)
    public boolean completed;

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

    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User() {
    }
}