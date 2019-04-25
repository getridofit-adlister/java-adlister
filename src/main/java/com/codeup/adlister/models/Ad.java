package com.codeup.adlister.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private Long categories;
    private String date;
    private String imageURL;

    public Ad(long id, long userId, String title, String description, String imageURL) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Ad(long userId, String title, String description, String imageURL) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.date = setDate();
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

    public Long getCategory() {
        return categories;
    }

    public void setCategory(Long categories) {
        this.categories = categories;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    private String setDate() {
        String pattern = "yyyy-mm-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        String date = simpleDate.format(new Date());
        return date;
    }

    public String getDate() {
        return date;
    }
}
