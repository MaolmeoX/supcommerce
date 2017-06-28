package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.dao.jpa.JpaCategoryDao;
import fr.imie.supcommerce.entity.Category;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

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
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setDescription(req.getParameter("description"));
        product.setPrice(Float.parseFloat(req.getParameter("price")));

        if (req.getParameter("category") != null && !req.getParameter("category").isEmpty()) {
            Category category = DaoFactory.get_JCD().findById(Integer.parseInt(req.getParameter("category")));
            product.setCategory(category);
        }

        DaoFactory.get_JPD().insert(product);

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categorys", DaoFactory.get_JCD().findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/auth/addProduct.jsp");
        rd.forward(req, resp);
    }
}
