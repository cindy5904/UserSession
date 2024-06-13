package org.example.exercice6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6.model.User;
import org.example.exercice6.service.UserService;
import org.example.exercice6.util.HibernateSession;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="login", value="/login")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService(HibernateSession.getSessionFactory());;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println(path);
        switch (path) {
            case "/login":
                formUser(req, resp);
                break;
            default:
                resp.sendRedirect("erreur");
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(email, name, password);
        HttpSession session = req.getSession();
        userService.saveUser(user);
        req.setAttribute("users", userService);
        resp.sendRedirect("productListe");
    }
    private void formUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }


}
