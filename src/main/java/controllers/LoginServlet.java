package controllers;

import dao.DaoFactory;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // if user object is not null, there was a user matching in the database, therefore send to profile
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        // else, display the login.jsp
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve username and password from formcodeup_test_DB//

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // create user object by retrieving from database
        User user = DaoFactory.getUsersDao().getUserByUsername(username);

        // if user object is null, there was no username found; reload login page
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        // set the user object as "user" in the session
        request.getSession().setAttribute("user", user);

        // redirect to profile
        response.sendRedirect("/profile");

    }
}
