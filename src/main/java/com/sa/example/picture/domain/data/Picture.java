package com.sa.example.picture.domain.data;


import lombok.ToString;

import javax.persistence.*;
import java.awt.*;
import java.io.File;
import java.util.Date;


@Entity
@ToString
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private Category category;
    //    @ManyToOne
//    private User user;
    private boolean accepted;
    private boolean processed;
    private Dimension dimension;
    private String path;
    private Date createdOn;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Picture() {
    }

    public Picture(String description, Category category, boolean accepted, boolean processed, Dimension dimension, String path, Date createdOn, File file) {
        this.description = description;
        this.category = category;
//        this.user = user;
        this.accepted = accepted;
        this.processed = processed;
        this.dimension = dimension;
        this.path = path;
        this.createdOn = createdOn;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date lastUpdate) {
        this.createdOn = lastUpdate;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
