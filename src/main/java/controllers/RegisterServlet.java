package controllers;

//import dao.DaoFactory;


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

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String hash = Password.hash(password);
//
        // validate input
        boolean inputHasErrors = username.isEmpty() || email.isEmpty() || password.isEmpty()
                || (! password.equals(passwordConfirmation));
//
        if (inputHasErrors) {
            response.sendRedirect("/register");
        }   else {

            User user = new User(username, email, hash);

            DaoFactory.getUsersDao().insertUser(user);

            response.sendRedirect("/login");
        }

    }
}
