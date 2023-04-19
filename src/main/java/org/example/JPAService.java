package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.sql.Time;
import java.util.function.Function;

public class JPAService{

    private static JPAService instance;
    private final EntityManagerFactory entityManagerFactory;
    private JPAService(){
        entityManagerFactory = Persistence.createEntityManagerFactory("JPA-test");
    }

    public static synchronized JPAService getInstance() {
        return instance == null ? instance = new JPAService() : instance;
    }

    public void shutdown(){
        entityManagerFactory.close();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public <T> T runInTransaction(Function<EntityManager, T> function){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean success = false;
        transaction.begin();
        try {
            T returnValue = function.apply(entityManager);
            success = true;
            return returnValue;
        } finally {
            if (success) {
                transaction.commit(); //Commit the transaction
            } else {
                transaction.rollback(); //If you want to rollback because there was an error

            }
        }
    }
}
