package fr.imie.supcommerce.dao.jpa;

import javax.persistence.EntityManagerFactory;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
abstract class JpaDao {
    protected EntityManagerFactory emf;

    public JpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
