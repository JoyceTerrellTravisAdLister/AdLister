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

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = DaoFactory.getUsersDao().getUserByUsername(username);

        if(email.isEmpty() || email.equals(user.getEmail())){
            response.sendRedirect("/profile/edit");
        } else {
            DaoFactory.getUsersDao().update(user);
        }





    }

}
