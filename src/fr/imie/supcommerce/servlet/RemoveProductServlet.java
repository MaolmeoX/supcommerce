package fr.imie.supcommerce.servlet;

import java.io.IOException;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.entity.Product;
import fr.imie.supcommerce.listener.PersistenceAppListener;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/removeProduct")
@EntityListeners(PersistenceAppListener.class)
public class RemoveProductServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();

            Query query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id")
                    .setParameter("id", Long.parseLong(req.getParameter("remove")));
            Product product = (Product) query.getSingleResult();

            em.remove(product);
            em.flush();
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
            resp.sendRedirect(req.getContextPath() + "/auth/listProduct");
        }

    }
}
