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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);

        }
        System.out.println(DaoFactory.getCategoriesDao().all());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long checkedId = null;
        List<Long> checkedIds = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");
        List<Category> categories = DaoFactory.getCategoriesDao().all();
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("file-url")
        );

        DaoFactory.getAdsDao().insert(ad);

        Ad createdAd = DaoFactory.getAdsDao().last();
        long createdAdId = createdAd.getId();

        for (Category cat:categories
             ) {
            String checkedIdString = request.getParameter(cat.getTitle());
            if(checkedIdString != null){
                checkedId = Long.parseLong(checkedIdString);
                checkedIds.add(checkedId);
            }
        }
        for (Long catId: checkedIds
             ) {DaoFactory.getAdCatDao().insert(createdAdId,catId);

        }
        response.sendRedirect("/profile");
    }
}
