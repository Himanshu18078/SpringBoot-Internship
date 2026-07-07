import java.sql.*;
import java.util.Scanner;

public class JDBCCrud {
    static Connection con;
    static final String URL = "jdbc:mysql://localhost:3306/abc";
    static final String USER = "root";
    static final String PASSWORD = "root";

    // ─── CONNECTION ───────────────────────────────────────────────
    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connected Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
//    INSERT
    public static void insert(int rollNo, String name) {
        String sql = "INSERT INTO student VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, rollNo);
            pstmt.setString(2, name);
            int rows = pstmt.executeUpdate();
            System.out.println("INSERT successful. Rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public static void readAll() {
        String sql = "SELECT * FROM student";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nStudent Records:");
            System.out.println("-----------------------------");
            while (rs.next()) {
                int rollNo = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("Roll No: " + rollNo + " | Name: " + name);
            }
            System.out.println("-----------------------------\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  READ BY ID
    public static void readById(int rollNo) {
        String sql = "SELECT * FROM student WHERE roll_no = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, rollNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Found → Roll No: " + rs.getInt(1) + " | Name: " + rs.getString(2));
            } else {
                System.out.println("No record found for Roll No: " + rollNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ─── UPDATE ───────────────────────────────────────────────────
    public static void update(int rollNo, String newName) {
        String sql = "UPDATE student SET name = ? WHERE roll_no = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, rollNo);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("UPDATE successful for Roll No: " + rollNo);
            else
                System.out.println("No record found for Roll No: " + rollNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void delete(int rollNo) {
        String sql = "DELETE FROM student WHERE roll_no = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, rollNo);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("DELETE successful for Roll No: " + rollNo);
            else
                System.out.println("No record found for Roll No: " + rollNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MAIN
    public static void main(String[] args) {
        connect();
        insert(100, "Himanshu");
        insert(101, "Mohit");
        insert(102, "Gautam");
        insert(103, "Anjali");

        readAll();

        readById(101);

        update(102, "Gaurav");
        readAll();

        delete(103);
        readAll();

        try {
            con.close();
            System.out.println("🔒 Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}