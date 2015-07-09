package slbedu.library.web;

import slbedu.library.dao.BookDAO;
import slbedu.library.utils.DatabaseUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-persistence-unit");

    @Override
    public void init() throws ServletException {
        DatabaseUtils utils = new DatabaseUtils(emf);
        utils.addTestDataToDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String bookId = req.getParameter("bookId");

        BookDAO bookDAO = new BookDAO(emf.createEntityManager());

//        if (bookId == null) {
            req.setAttribute("allBooks", bookDAO.getAllBooks());
            req.getRequestDispatcher("books.jsp").forward(req, resp);
//        } else {
//            resource = gson.toJson(bookDAO.findById(Long.parseLong(bookId)));
//        }

    }


}
