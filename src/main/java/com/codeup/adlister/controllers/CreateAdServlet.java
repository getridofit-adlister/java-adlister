package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Categories;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("categories",DaoFactory.getCategoriesDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);

        }
        System.out.println(DaoFactory.getCategoriesDao().all());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = (User) request.getSession().getAttribute("user");
        String categoryString = request.getParameter("category");
        Long categoryId = Long.parseLong(categoryString);
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("file-url")
        );

        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/profile");
    }
}
