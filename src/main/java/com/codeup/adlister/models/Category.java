package com.codeup.adlister.models;

public class Category {
    private long id;
    private String title;

    public Category(){

    }

    public Category(long id, String title){
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
