package controllers;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdServlet", urlPatterns = "/ad/edit")
public class EditAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        Ad ad = DaoFactory.getAdsDao().getAdById(id);
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        ad.setTitle(title);
        ad.setDescription(description);
        DaoFactory.getAdsDao().updateAd(ad);

        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().getAdById(id);
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/editAd.jsp").forward(request, response);
    }
}
