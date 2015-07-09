package slbedu.library.web;

import slbedu.library.dao.BookDAO;
import slbedu.library.utils.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static slbedu.library.utils.EntityManagerProvider.getEntityManager;

@WebServlet(urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        DatabaseUtils utils = new DatabaseUtils(getEntityManager().getEntityManagerFactory());
        utils.addTestDataToDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO(getEntityManager());
        req.setAttribute("allBooks", bookDAO.getAllBooks());
        req.getRequestDispatcher("books.jsp").forward(req, resp);

    }


}
