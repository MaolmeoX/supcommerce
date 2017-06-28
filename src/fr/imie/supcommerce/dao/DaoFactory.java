package fr.imie.supcommerce.dao;

import fr.imie.supcommerce.dao.jpa.JpaCategoryDao;
import fr.imie.supcommerce.dao.jpa.JpaProductDao;
import fr.imie.supcommerce.util.PersistenceManager;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public class DaoFactory {
    private DaoFactory() {
    }

    public static JpaCategoryDao get_JCD(){
        return new JpaCategoryDao(PersistenceManager.getEMF());
    }

    public static JpaProductDao get_JPD(){
        return new JpaProductDao(PersistenceManager.getEMF());
    }
}
