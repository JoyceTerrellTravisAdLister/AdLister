package controllers;

import dao.DaoFactory;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/profile/password")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String hash = Password.hash(newPassword);
        String confirmNewPassword = request.getParameter("confirm-new-password");
        User user = (User)request.getSession().getAttribute("user");

        if (!BCrypt.checkpw(oldPassword, user.getPassword()) || !newPassword.equals(confirmNewPassword)) {
            response.sendRedirect("/profile/password");
        } else {
            user.setPassword(hash);
            DaoFactory.getUsersDao().updatePassword(user);
            response.sendRedirect("/profile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
    }
}
