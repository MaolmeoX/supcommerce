package fr.imie.supcommerce.dao.jpa;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.entity.Category;
import fr.imie.supcommerce.entity.Product;
import fr.imie.supcommerce.util.PersistenceManager;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public class JpaProductDao extends JpaDao implements ProductDao {

    public JpaProductDao(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Product insert(Product p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(p);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
            return p;
        }
    }

    @Override
    public Product update(Product p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.merge(p);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
            return p;
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(em.merge(findById(id)));
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
    }

    @Override
    public Product findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Product product = null;
        try {
            product = (Product) em.createQuery("SELECT p FROM Product p WHERE p.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Product> query = em.createQuery("from Product ", Product.class);
        return query.getResultList();
    }
}
