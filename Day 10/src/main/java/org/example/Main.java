package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);

        // Build SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();

        // Open Session
        Session session = factory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // ============================================================
        // INSERT OPERATION
        // ============================================================

        /*
        Employee emp1 = new Employee();
        emp1.setName("Himanshu");

        Employee emp2 = new Employee();
        emp2.setName("Mohit");

        Employee e3 = new Employee();
        e3.setName("Rohan");

        session.persist(emp1);
        session.persist(emp2);
        session.persist(e3);


        System.out.println("Employees inserted successfully!");
        */



        // ============================================================
        // READ OPERATION
        // ============================================================

        /*
        Employee emp = session.get(Employee.class, 2);

        if (emp != null) {
            System.out.println("Employee ID : " + emp.getId());
            System.out.println("Employee Name : " + emp.getName());
        } else {
            System.out.println("No record found.");
        }
        */

        // ============================================================
        // UPDATE OPERATION
        // ============================================================

        /*
        Employee emp = session.get(Employee.class, 2);

        if (emp != null) {
            emp.setName("Rohit");
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("No record found.");
        }
        */

        // ============================================================
        // DELETE OPERATION
        // ============================================================

        /*
        Employee emp = session.get(Employee.class, 2);

        if (emp != null) {
            session.remove(emp);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("No record found.");
        }
        */

        // ============================================================
        // SELECT OPERATION
        // ============================================================

//        String hql = "from Employee";
//        Query<Employee> query = session.createQuery(hql, Employee.class);
//        List<Employee> employees = query.getResultList();
//
//        for (Employee emp : employees) {
//            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName());
//        }

        String hql = "FROM Employee WHERE id = :id";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("id", 3);
        Employee emp = query.uniqueResult();

        if (emp != null) {
            System.out.println("Employee name: " + emp.getName());
        } else {
            System.out.println("No employee found with id 3");
        }
        // Commit Transaction
        transaction.commit();

        // Close Resources
        session.close();
        factory.close();
    }
}