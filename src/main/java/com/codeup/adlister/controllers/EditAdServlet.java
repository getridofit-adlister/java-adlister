package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdServlet", urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
        }
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        User user = (User) request.getSession().getAttribute("user");
        long userId = user.getId();
        Ad adToUpdate = DaoFactory.getAdsDao().thisAd(userId);
        adToUpdate.setTitle(title);
        adToUpdate.setDescription(description);
        DaoFactory.getAdsDao().updateAd(adToUpdate);
        request.getSession().setAttribute("ad", adToUpdate);
        response.sendRedirect("/profile");

    }
}
