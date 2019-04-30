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
    boolean titleIsEmpty;
    boolean desciptionIsEmpty;
    boolean categoryIsEmpty;
    boolean validPost;
    String title;
    String desciption;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            request.setAttribute("titleEmpty",titleIsEmpty);
            request.setAttribute("descriptionEmpty",desciptionIsEmpty);
            request.setAttribute("catEmpty",categoryIsEmpty);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        title=request.getParameter("title");
        desciption=request.getParameter("description");
        Long checkedId = null;
        List<Long> checkedIds = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");
        List<Category> categories = DaoFactory.getCategoriesDao().all();
        titleIsEmpty=false;
        desciptionIsEmpty=false;
        categoryIsEmpty=false;

        titleIsEmpty = title.isEmpty();
        desciptionIsEmpty = desciption.isEmpty();


        String fileURL = request.getParameter("file-url");
        if(fileURL.isEmpty()){
            fileURL = "https://cdn.filestackcontent.com/UMsdZdq5SAiRuYIiPSfK";
        }

        for (Category cat:categories
        ) {
            String checkedIdString = request.getParameter(cat.getTitle());
            if(checkedIdString != null){
                checkedId = Long.parseLong(checkedIdString);
                checkedIds.add(checkedId);
            }
        }
        categoryIsEmpty = checkedIds.isEmpty();

        validPost = !categoryIsEmpty && !desciptionIsEmpty && !titleIsEmpty;

        if(validPost){
        Ad ad = new Ad(
                user.getId(),
                title,
                desciption,
                fileURL
        );

        DaoFactory.getAdsDao().insert(ad);

        Ad createdAd = DaoFactory.getAdsDao().last();
        long createdAdId = createdAd.getId();


        for (Long catId: checkedIds
             ) {DaoFactory.getAdCatDao().insert(createdAdId,catId);

        }
        response.sendRedirect("/profile");
    }else response.sendRedirect("/ads/create");
    }
}
