import java.sql.*;

public class ResultStatePreparedStatement {
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

        // STEP 2 - CONNECTION + READ DATA DYNAMICALLY
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully");
            /*
            THESE ARE DYNAMIC QUERY
            String sql = "INSERT INTO student VALUES (?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,103);
            pstm.setString(2,"Gautam");
            int i = pstm.executeUpdate();
            */
            // ? = roll_no to search for — value set dynamically below
            String sql = "SELECT * FROM student WHERE roll_no = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, 100);                         // fills ? with 100

            ResultSet rs = pstm.executeQuery();          // NO argument here

            while (rs.next()) {
                int rollNo = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("Roll No: " + rollNo + " | Name: " + name);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}