package org.mohit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Load Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Build SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Start transaction
        session.beginTransaction();

        // Create a new Student object
        Student student = new Student();
        student.setName("MohitThakur");
        student.setEmail("MohitThakur@example.com");

        // Save the student object to the database
        session.persist(student);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();

        System.out.println("Student saved successfully: " + student);
    }
}