package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.codeup.adlister.dao.DaoFactory.getUsersDao;


@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    boolean usernameIsEmpty;
    boolean emailIsEmpty;
    boolean passwordIsEmpty;
    boolean passwordsNoMatch;
    boolean duplicateUsername;
    String username ="";
    String email ="";
    String password ="";
    String passwordConfirmation ="";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("emptyName",usernameIsEmpty);
        request.setAttribute("emptyEmail",emailIsEmpty);
        request.setAttribute("emptyPass",passwordIsEmpty);
        request.setAttribute("passwordsNoMatch",passwordsNoMatch);
        request.setAttribute("duplicate", duplicateUsername);
        request.setAttribute("username",username);
        request.setAttribute("email",email);
        request.setAttribute("password",password);
        request.setAttribute("passwordC",passwordConfirmation);

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        passwordConfirmation = request.getParameter("confirm_password");


        usernameIsEmpty = false;
        emailIsEmpty = false;
        passwordIsEmpty = false;
        passwordsNoMatch = false;
        duplicateUsername = false;

        // validate input
     usernameIsEmpty = username.isEmpty();
     emailIsEmpty = email.isEmpty();
     passwordIsEmpty = password.isEmpty();
     passwordsNoMatch = (!password.equals(passwordConfirmation));
     List<String> usernames = DaoFactory.getUsersDao().getUsernames();
     duplicateUsername = false;
     for (String userN : usernames
     ) { if(userN.equals(username)){
         duplicateUsername = true;
     }
     }



        if (usernameIsEmpty
        || emailIsEmpty
        || passwordIsEmpty
        || passwordsNoMatch
        || duplicateUsername) {
            response.sendRedirect("/register");
            return;
        }



        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
