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

@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // validate input

        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty();


        if (inputHasErrors) {
            response.sendRedirect("/editProfile");
            return;
        }

        // get session user
        User user = (User) request.getSession().getAttribute("user");
        long userId = user.getId();
        User userToUpdate = DaoFactory.getUsersDao().findByUserId(userId);
        userToUpdate.setUsername(username);
        userToUpdate.setEmail(email);

        DaoFactory.getUsersDao().updateUser(userToUpdate);
        request.getSession().setAttribute("user", userToUpdate);
        response.sendRedirect("/profile");
    }
}
