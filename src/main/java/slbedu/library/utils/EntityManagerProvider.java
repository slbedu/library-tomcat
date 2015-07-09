package slbedu.library.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ivan St. Ivanov
 */
public class EntityManagerProvider {

    private static final String PERSISTENCE_UNIT = "library-persistence-unit";

    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }
}
