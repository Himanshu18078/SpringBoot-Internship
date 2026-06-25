package JDBC;

import java.sql.*;

public class JDBCConnection {
    static Connection con;

    public static void main(String[] args) throws SQLException {

        /*
         * STEP 1 — LOAD THE MYSQL JDBC DRIVER
         * ─────────────────────────────────────
         * Class.forName() dynamically loads the MySQL driver class
         * into memory at runtime so JDBC knows which database
         * we are trying to connect to.
         *
         * If the driver JAR is not added to the project,
         * ClassNotFoundException will be thrown.
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
         * STEP 2 — ESTABLISH CONNECTION WITH THE DATABASE
         * ─────────────────────────────────────────────────
         * DriverManager.getConnection() takes 3 arguments:
         *
         *   ARG 1 — URL      : jdbc:mysql://localhost:3306/xyz
         *                      │    │        │         │    │
         *                      │    │        │         │    └─ database name
         *                      │    │        │         └────── port (MySQL default)
         *                      │    │        └──────────────── host
         *                      │    └───────────────────────── db type
         *                      └────────────────────────────── protocol
         *
         *   ARG 2 — username : "root"
         *   ARG 3 — password : "root"
         *
         * Returns a Connection object which acts as a live bridge
         * between our Java app and the database.
         */
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/xyz",
                    "root",
                    "root"
            );
            System.out.println("Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
         * STEP 3 — EXECUTE SQL QUERY
         * ───────────────────────────
         * executeUpdate() is used for queries that MODIFY data:
         *   → CREATE, INSERT, UPDATE, DELETE
         *
         * (use executeQuery() instead for SELECT statements
         *  as it returns a ResultSet with the fetched rows)
         *
         * Uncomment the query you want to run:
         */
        try {
            /*
             * STEP 3a — CREATE A STATEMENT OBJECT
             * ─────────────────────────────────────
             * con.createStatement() returns a Statement object.
             *
             * Statement is an interface (java.sql.Statement)
             * it acts as a vehicle to send SQL queries
             * to the database through the active connection.
             *
             * Flow:
             *   con  →  Statement  →  SQL Query  →  Database
             *
             * Types of Statement:
             *   Statement          → simple fixed SQL queries
             *   PreparedStatement  → queries with parameters (? placeholders)
             *   CallableStatement  → calling stored procedures
             */
            Statement stmt = con.createStatement();

//          String sql = "CREATE TABLE emp (id INT, name VARCHAR(50))";
//          String sql = "INSERT INTO emp VALUES (11, 'Harsh')";
//          String sql = "UPDATE emp SET name = 'Rohit' WHERE id = '10'";
            String sql    = "DELETE FROM emp WHERE id = '10'";

            stmt.executeUpdate(sql);
            /* Here Add resultSet*/

//          System.out.println("Table created successfully");
//          System.out.println("Inserted successfully");
            System.out.println("Row deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            /*
             * STEP 4 — CLOSE THE CONNECTION
             * ───────────────────────────────
             * finally block always runs whether an exception
             * occurred or not — making it the safest place
             * to close the connection.
             *
             * Closing is important to free up database
             * resources and avoid memory leaks.
             */
            con.close();
        }
    }
}