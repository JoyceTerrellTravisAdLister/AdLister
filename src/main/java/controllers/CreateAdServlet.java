package controllers;

import dao.DaoFactory;
import models.Ad;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if user is not logged in, redirect to login page
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }

        // else, forward to the create-ad.jsp
        request.getRequestDispatcher("/WEB-INF/create-ad.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // if user is not logged in, redirect to login page
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        // create a user object using current user object (set in login servlet)
        User user = (User) request.getSession().getAttribute("user");

        // create a new ad using current user id
        Ad ad = new Ad (
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );

        // insert ad into database
//        DaoFactory.getAdsDao().insert(ad);
//        response.sendRedirect("/profile");


    }
}
