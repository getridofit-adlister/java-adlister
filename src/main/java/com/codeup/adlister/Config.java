package com.codeup.adlister;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    public String getUsername() {
        return "someuser";
    }
    public String getPassword() {
        return "strongpassword";
    }
}