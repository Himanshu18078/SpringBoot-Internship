package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            System.out.println("Hibernate configured successfully!");

            // 1. ADD EMPLOYEE

            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Employee emp = new Employee();
            emp.setName("Himanshu");
            emp.setDepartment("IT");
            emp.setSalary(50000);
            session.save(emp);
            t.commit();
            System.out.println("Employee Inserted Successfully");
            session.close();


            //2. VIEW EMPLOYEE BY ID
            /*

            Session session = sessionFactory.openSession();
            Employee emp = session.get(Employee.class, 1);Employee emp = session.get(Employee.class, 1);
            // ask Hibernate to find the employee row where id = 1, and return it as an Employee object (or null if not found)
            if (emp != null) {
                System.out.println(emp); //Here we are using the toString class
            } else {
                System.out.println("Employee not found");
            }
            session.close();
            */

            // 3. UPDATE SALARY

            /*
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            if (emp != null) {
                emp.setSalary(75000);
                session.update(emp);
                t.commit();
                System.out.println("Salary Updated Successfully");
            } else {
                System.out.println("Employee not found");
                t.rollback();
            }
            session.close();
            */

            // 4. DELETE EMPLOYEE

            /*
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            if (emp != null) {
                session.delete(emp);
                t.commit();
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee not found");
                t.rollback();
            }
            session.close();
            */

            // 5. VIEW ALL EMPLOYEES
            /*
            Session session = sessionFactory.openSession();
            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();
            for (Employee e : list) {
                System.out.println(e);
            }
            session.close();
            */

            sessionFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}