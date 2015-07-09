package slbedu.library.web;

import slbedu.library.dao.BookDAO;
import slbedu.library.dao.UserDAO;

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
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        if (bookId != null) {
            BookDAO bookDAO = new BookDAO(getEntityManager());
            UserDAO userDAO = new UserDAO(getEntityManager());

            bookDAO.borrowBook(bookDAO.findById(Long.parseLong(bookId)), userDAO.findUserByName((String) req.getSession().getAttribute("currentUser")));
        }

        resp.sendRedirect("book");
    }
}
