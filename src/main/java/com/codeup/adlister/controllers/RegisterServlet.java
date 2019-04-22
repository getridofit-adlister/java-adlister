package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/ads/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/ads/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirm_password");

        // TODO: ensure the submitted information is valid

        boolean invalidAttempt = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty();

        if (invalidAttempt) {
            response.sendRedirect("/ads/register");

        } else {
            // TODO: create a new user based off of the submitted information
            // TODO: if a user was successfully created, send them to their profile

            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }
    }
}
