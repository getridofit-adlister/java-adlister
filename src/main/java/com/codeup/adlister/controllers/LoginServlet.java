package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    boolean usernameIsEmpty;
    boolean passwordIsEmpty;
    boolean wrongPass;
    boolean validAttempt;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("emptyName",usernameIsEmpty);
        request.setAttribute("emptyPass",passwordIsEmpty);
        request.setAttribute("wrongPass",wrongPass);

        if(request.getSession().getAttribute("validAttempt") != null) {
            Boolean loginIsValid = (Boolean) request.getSession().getAttribute("validAttempt");
            request.setAttribute("loginIsValid", loginIsValid);
        }

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        usernameIsEmpty=false;
        passwordIsEmpty=false;
        wrongPass=false;
        validAttempt=false;
        usernameIsEmpty = username.isEmpty();
        passwordIsEmpty = password.isEmpty();

        wrongPass = !Password.check(password, user.getPassword());

        validAttempt = !usernameIsEmpty && !passwordIsEmpty && !wrongPass

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }
    }
}
