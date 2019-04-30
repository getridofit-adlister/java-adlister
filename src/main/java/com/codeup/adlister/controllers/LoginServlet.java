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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    boolean passwordIsEmpty;
    boolean wrongPass;
    boolean usernameIsEmpty;
    boolean validAttempt;
    boolean userExists;
    String username = "";
    String password = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("emptyPass",passwordIsEmpty);
        request.setAttribute("wrongPass",wrongPass);
        request.setAttribute("userExists",userExists);
        request.setAttribute("username",username);
        request.setAttribute("password",password);

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
        username = request.getParameter("username");
        password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        usernameIsEmpty=false;
        passwordIsEmpty=false;
        wrongPass=false;
        validAttempt=false;
        userExists= false;
        passwordIsEmpty = password.isEmpty();

        List<String> usernames = new ArrayList<>();
        usernames = DaoFactory.getUsersDao().getUsernames();
        for (String validUser: usernames
             ) {if (username.equals(validUser)){
                 userExists = true;
        }
        }

        if(userExists && !password.equals("")) {
            wrongPass = !Password.check(password, user.getPassword());
        }


        validAttempt = !usernameIsEmpty && !passwordIsEmpty && !wrongPass && userExists;


        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }
    }
}
