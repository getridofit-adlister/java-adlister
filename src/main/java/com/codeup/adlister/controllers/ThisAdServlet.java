package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.ThisAdServlet", urlPatterns = "/thisAd")
public class ThisAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);

        request.setAttribute("ad", DaoFactory.getAdsDao().thisAd(id));
        System.out.println(DaoFactory.getAdsDao().thisAd(id));
        request.getRequestDispatcher("/WEB-INF/ads/thisAd.jsp").forward(request, response);
    }
}

