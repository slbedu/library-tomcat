package slbedu.library.web;

import slbedu.library.dao.UserDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static slbedu.library.utils.EntityManagerProvider.getEntityManager;

/**
 * @author Ivan St. Ivanov
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO(getEntityManager());

        if (userDAO.validateUserCredentials(userName, password)) {
            req.getSession().setAttribute("currentUser", userName);
            resp.sendRedirect("/book");
        } else {
            doGet(req, resp);
        }
    }
}
