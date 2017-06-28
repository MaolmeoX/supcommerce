package fr.imie.supcommerce.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
@WebServlet(urlPatterns = "/auth/listProduct")
public class CheaperProductsServlet extends HttpServlet {
    EntityManagerFactory emf = null;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("My-PU");
    }

    @Override
    public void destroy() {
        emf.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT product FROM Product product where price < 100");
        List list = query.getResultList();

        req.setAttribute("products", list);
        RequestDispatcher rd = req.getRequestDispatcher("/auth/listProduct.jsp");
        rd.forward(req, resp);
    }
}
