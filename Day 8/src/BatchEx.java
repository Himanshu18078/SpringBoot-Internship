import java.sql.*;
import java.util.Scanner;

public class BatchEx {
    static Connection con;
    static String url = "jdbc:mysql://localhost:3306/abc";
    static String user = "root";
    static String password = "root";

    public static void main(String[] args) {

        // STEP 1 - DRIVER
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // STEP 2 - CONNECTION
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully");
            String sql = "INSERT INTO student VALUES(?,?)";
            PreparedStatement pstm =  con.prepareStatement(sql);
            while (true){
                Scanner input = new Scanner(System.in);
                System.out.print("Enter Student Roll Number : ");
                int rollNumber = input.nextInt();
                System.out.print("Enter Student Name : ");
                String name = input.next();
                pstm.setInt(1,rollNumber);
                pstm.setString(2,name);
                pstm.addBatch();
                System.out.println("Do you want to enter more record ?\n(YES / NO)");
                String n = input.next();
                if(n.equalsIgnoreCase("NO")){
                    break;
                }
            }
            pstm.executeBatch();
            System.out.println("Record Updated Successfully");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}