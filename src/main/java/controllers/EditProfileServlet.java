package controllers;

import dao.DaoFactory;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("user");
        String email = request.getParameter("email");



        if(user.getEmail().isEmpty() || user.getEmail().equals(email)){
            response.sendRedirect("/profile/edit");
        } else {
            user.setEmail(email);
            DaoFactory.getUsersDao().update(user);
            response.sendRedirect("/profile");
        }
    }
}
