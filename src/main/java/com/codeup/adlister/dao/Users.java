package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    List<User> all();
    User findByUsername(String username);
    Long insert(User user);
    User findByUserId(long id);
    boolean updateUser(User user);
    List<String> getUsernames();
}
