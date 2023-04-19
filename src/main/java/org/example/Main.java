package org.example;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    private static final JPAService jpaService = JPAService.getInstance();


    public static void main(String[] args) {
        try {
        createCitas();
        printCitas();



        } finally {
            jpaService.shutdown();
        }
    }

    public static void createCitas(){
        jpaService.runInTransaction(entityManager -> {
            Date date = new Date(123, 3, 14); // 123 = year-1900, 3 = month (0-indexed), 14 = day
            entityManager.persist(new Citas(1, 1, date, new Time(10, 0, 0)));
            return null;
        });
    }

    public static void printCitas(){
        List<Citas> list = jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select ct from Citas ct", Citas.class)
                    .getResultList();

        });

        list.stream()
                .map(ct -> "Id de la cita: " + ct.getId() + "\nId del pactiente: " + ct.getId_paciente() + "\nId del medico: " + ct.getId_medico() + "\nHora: " + ct.getHora() + "\nFecha: " + ct.getFecha())
                .forEach(System.out::println);
    }


}
