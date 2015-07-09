package slbedu.library.web;

import slbedu.library.dao.BookDAO;
import slbedu.library.dao.UserDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan St. Ivanov
 */
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-persistence-unit");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        if (bookId != null) {
            BookDAO bookDAO = new BookDAO(emf.createEntityManager());
            UserDAO userDAO = new UserDAO(emf.createEntityManager());

            bookDAO.borrowBook(bookDAO.findById(Long.parseLong(bookId)), userDAO.findUserByName((String) req.getSession().getAttribute("currentUser")));
        }

        resp.sendRedirect("book");
    }
}
