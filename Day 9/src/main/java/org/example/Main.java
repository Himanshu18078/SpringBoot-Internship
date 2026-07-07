package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            System.out.println("Hibernate configured successfully!");

            Session session =  sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Student s = new Student();
            s.setId(200);
            s.setName("Himanshu");
            session.save(s);
            t.commit();
            System.out.println("Successfully Inserted");
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}