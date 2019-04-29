package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditAdServlet", urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {

    String id;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            id = request.getParameter("id");
            request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);

        }
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String stringId = id;
        long id = Long.parseLong(stringId);
        List<Category> categories = DaoFactory.getCategoriesDao().all();
        List<Long> checkedIds = new ArrayList<>();
        Long checkedIdL = null;


        Ad adToUpdate = DaoFactory.getAdsDao().thisAd(id);
        adToUpdate.setTitle(title);
        adToUpdate.setDescription(description);
        DaoFactory.getAdsDao().updateAd(adToUpdate);

        DaoFactory.getAdCatDao().delete(id);
        for (Category cat:categories
        ) {
            String checkedIdS = request.getParameter(cat.getTitle());
            if(checkedIdS != null){
                checkedIdL = Long.parseLong(checkedIdS);
                checkedIds.add(checkedIdL);
            }
        }
        for (Long catId: checkedIds
        ) {DaoFactory.getAdCatDao().insert(id,catId);

        }
        response.sendRedirect("/profile");
    }
}
