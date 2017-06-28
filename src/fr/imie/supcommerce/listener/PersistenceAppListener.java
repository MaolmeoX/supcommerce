package fr.imie.supcommerce.listener;

import fr.imie.supcommerce.util.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by MaolmeoX on 23/06/2017.
 */
public class PersistenceAppListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        PersistenceManager.closeEMF();
    }
}
