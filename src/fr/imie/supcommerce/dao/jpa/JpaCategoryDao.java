package fr.imie.supcommerce.dao.jpa;

import fr.imie.supcommerce.dao.CategoryDao;
import fr.imie.supcommerce.entity.Category;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public class JpaCategoryDao extends JpaDao implements CategoryDao {

    public JpaCategoryDao(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Category insert(Category c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(c);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
        return c;
    }

    @Override
    public Category update(Category c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(c);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
        return c;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        Category category = findById(id);
        try {
            t.begin();
            em.remove(category);
            t.commit();
        } finally {
            if (t.isActive()) t.rollback();
            em.close();
        }
    }

    @Override
    public Category findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Category category = null;
        try {
            category = (Category) em.createQuery("SELECT c FROM Category c WHERE c.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Category> query = em.createQuery("from Category", Category.class);
        return query.getResultList();
    }
}
