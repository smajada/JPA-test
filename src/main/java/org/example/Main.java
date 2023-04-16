package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final JPAService jpaService = JPAService.getInstance();


    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = jpaService.getEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            entityManager.persist(new Citas(1, 1, "10-04-2023", "10:00:00"));

            transaction.commit(); //Commit the transaction
//            transaction.rollback(); //If you want to rollback because there was an error


        } finally {
        jpaService.shutdown();
        }
    }
}