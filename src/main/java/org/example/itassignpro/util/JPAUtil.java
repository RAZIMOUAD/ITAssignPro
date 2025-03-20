package org.example.itassignpro.util;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ITAssignProPU");
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
