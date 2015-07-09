package slbedu.library.web;

import slbedu.library.dao.UserDAO;
import slbedu.library.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Ivan St. Ivanov
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-persistence-unit");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");

        if (userName == null || password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            doGet(req, resp);
        } else {
            UserDAO userDAO = new UserDAO(emf.createEntityManager());

            userDAO.addUser(new User(userName, password, email, new Date()));
            req.getSession().setAttribute("currentUser", userName);
            resp.sendRedirect("/book");
        }
    }
}
