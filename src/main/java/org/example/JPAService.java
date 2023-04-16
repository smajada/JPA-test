package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAService{

    private static JPAService instance;
    private EntityManagerFactory entityManagerFactory;
    private JPAService(){
        entityManagerFactory = new Persistence.createEntityManagerFactory("JPA-test");
    }

    public static synchronized JPAService getInstance() {
        return instance == null ? instance = new JPAService() : instance;
    }

    public void shutdown(){
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
