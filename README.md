# JPA/Hibernate Practice

This project is a medical appointment management application, which uses JPA (Java Persistence API) to perform read and write operations on the database.

<!-- TOC -->
* [JPA/Hibernate Practice](#jpahibernate-practice)
  * [Prerequisites](#prerequisites)
  * [Database configuration](#database-configuration)
  * [Compiling and running the project](#compiling-and-running-the-project)
  * [Project features](#project-features)
<!-- TOC -->

## Prerequisites
- Java 8+
- Maven 3.6.3+
- MySQL 5.7+

## Database configuration
1. Create a database named appointments_db in your MySQL instance.
2. Update the database connection configuration in the persistence.xml file in the src/main/resources folder. Replace the YOUR_USERNAME and YOUR_PASSWORD values with your MySQL credentials.

```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/citas_db"/>
<property name="javax.persistence.jdbc.user" value="YOUR_USERNAME"/>
<property name="javax.persistence.jdbc.password" value="YOUR_PASSWORD"/>
```

## Compiling and running the project
1. Clone this repository on your local machine.
2. Open a terminal in the project root folder.
3. Run the following command to compile the project:

```
mvn compile
```

4. Run the following command to execute the project:

```
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## Project features
This project includes the following functionality:
- Creation of new appointments
- Printing of all appointments stored in the database.

To use these functionalities, run the Main class from the command line. The application will create an appointment in the database and then print all existing appointments in the database.
