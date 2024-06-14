package org.example.exercice6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice6.model.User;
import org.example.exercice6.service.UserService;
import org.example.exercice6.util.HibernateSession;

import java.io.IOException;

@WebServlet(name="register", value="/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserService(HibernateSession.getSessionFactory());;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new User(email, name, password);
        userService.saveUser(user);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/login");
    }

}
