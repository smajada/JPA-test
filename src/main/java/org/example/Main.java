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
                System.out.print("Write the ID of the pacient: ");
        int pacientID = scan.nextInt();

        System.out.print("Write the ID of the doctor: ");
        int doctorID = scan.nextInt();

        System.out.print("Write the day of the appointment: ");
        int day = scan.nextInt();
        System.out.print("Write the month of the appointment: ");
        int month = scan.nextInt();
        System.out.print("Write the year of the appointment: ");
        int year = scan.nextInt();

        System.out.println("For that available date, the hour must be 10am.");
        System.out.println("Creating appointment...");


        jpaService.runInTransaction(entityManager -> {
            Date date = new Date(year-1900, month - 1, day); // 123 = year-1900, 3 = month (0-indexed), 14 = day
            entityManager.persist(new Citas(pacientID, doctorID, date, new Time(10, 0, 0)));
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
