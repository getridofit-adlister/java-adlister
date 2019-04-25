package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String category;
    private String imageURL;

    public Ad(long id, long userId, String title, String description, String imageURL) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Ad(long userId, String title, String description, String imageUrl) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imageURL = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
