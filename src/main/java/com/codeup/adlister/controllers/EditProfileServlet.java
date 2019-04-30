package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
boolean duplicateUsername;
String username;
String email;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("duplicate", duplicateUsername);
            request.setAttribute("username",username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        username = request.getParameter("username");
        email = request.getParameter("email");
        duplicateUsername = false;
        // validate input
        List<String> usernames = DaoFactory.getUsersDao().getUsernames();
        duplicateUsername = false;
        for (String userN : usernames
        ) { if(userN.equals(username)){
            duplicateUsername = true;
        }
        }
        System.out.println(duplicateUsername);

        if(!duplicateUsername){
        // get session user
        User user = (User) request.getSession().getAttribute("user");
        long userId = user.getId();
        User userToUpdate = DaoFactory.getUsersDao().findByUserId(userId);
        userToUpdate.setUsername(username);
        userToUpdate.setEmail(email);

        DaoFactory.getUsersDao().updateUser(userToUpdate);
        request.getSession().setAttribute("user", userToUpdate);
        response.sendRedirect("/profile");
    }else{
            response.sendRedirect("/editProfile");
        }
        }
}

