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

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description, long categories) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = categories;
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

    public Long getCategories() {
        return categories;
    }

    public void setCategories(Long categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String setDate() {
        String pattern = "yyyy-mm-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        String date = simpleDate.format(new Date());
        return date;
    }
}
