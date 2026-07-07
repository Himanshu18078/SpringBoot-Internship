package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/ems_db?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully!");

            //1. INSERT EMPLOYEE

            String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Himanshu");
            ps.setString(2, "IT");
            ps.setDouble(3, 50000);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted successfully!");
            ps.close();


            // 2. VIEW EMPLOYEE BY ID
            /*

            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1); // change 1 to the actual ID you want to search
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found");
            }
            rs.close();
            ps.close();
            */

            //3. UPDATE SALARY
            /*

            String sql = "UPDATE employees SET salary = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, 75000);   // new salary
            ps.setInt(2, 1);          // change 1 to the actual ID you want to update
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Salary updated successfully!");
            } else {
                System.out.println("Employee not found");
            }
            ps.close();
            */

            /*
            // 4. DELETE EMPLOYEE

            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1); // change 1 to the actual ID you want to delete
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found");
            }
            ps.close();
            */

            /*
            // 5. VIEW ALL EMPLOYEES

            String sql = "SELECT * FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Department: " + rs.getString("department") +
                    ", Salary: " + rs.getDouble("salary")
                );
            }
            rs.close();
            st.close();
            */

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}