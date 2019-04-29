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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserAd> userAds = new ArrayList<>();
        List<Ad> ads = DaoFactory.getAdsDao().all();
        for (Ad ad : ads) {
            UserAd userAd = new UserAd();
            User user = DaoFactory.getUsersDao().findByUserId(ad.getUserId());
            userAd.setAd(ad);
            userAd.setUser(user);
            userAds.add(userAd);
        }

        request.setAttribute("userAds", userAds);

        List<Ad> allAds = DaoFactory.getAdsDao().all();
        for (Ad ad : allAds) {
            System.out.println(ad.getImageURL());
            System.out.println(ad.getDescription());
            System.out.println(ad.getTitle());
        }

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
