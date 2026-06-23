package JDBC;

import java.sql.*;

public class JDBCConnection {
   static Connection con;

    public static void main(String [] args) throws SQLException {
//        The following is for driver
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
//            The following code is to get connected with the databse
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xyz",
                "root",
                "root"
        );
            System.out.println("Connected Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
//        The following if to insert data into the database
        try{
        Statement stmt = con.createStatement();
//        String sql = "Create table emp(id int, name varchar(50))";
//            String sql = "insert into emp values (11 , 'Harsh')";
//            String sql = "update emp set name = 'Rohit' where id ='10' ";
            String sql = "delete from emp where id = '10'";
        stmt.executeUpdate(sql);
//        System.out.println("Table Created successfully");
//            System.out.println("Inserted Successfully");
            System.out.println("Row deleted Successfully.");
        }catch (SQLException e){
            e.printStackTrace();
        } finally{
//            The following is to close the connection
            con.close();
        }
    }
}
