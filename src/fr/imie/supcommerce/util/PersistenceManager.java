package fr.imie.supcommerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public class PersistenceManager {

    private static EntityManagerFactory emf = null;

    private PersistenceManager() {
    }

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("My-PU");
        }
        return emf;
    }

    public static void closeEMF() {
        getEMF().close();
    }
}
