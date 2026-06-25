import java.sql.*;
public class JDBCRevision {
    static Connection con;
    static String url = "jdbc:mysql://localhost:3306/abc";
    static String user ="root";
    static String password = "root";
    public static void main(String [] args){
//        STEP 1 DRIVER
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
//        STEP 2 CONNECTION
        try{
        con = DriverManager.getConnection(url,user,password);
            System.out.println("Connected Successfully");
            /*
            THESE ARE STATIC QUERRY
             String sql = "CREATE TABLE student(roll_no INT , name VARCHAR(100))";
             String sql = "INSERT INTO student VALUES ('100' ,'Himanshu')";
             String sql = "INSERT INTO student VALUES ('101' ,'MOHIT')";
             String sql = "INSERT INTO student VALUES ('102' ,'Gautam')";
             String sql = "UPDATE student SET name ='Mohit' WHERE roll_no = '101'";
             String sql = "DELETE FROM student WHERE roll_no = '102'";
             Statement stmt = con.createStatement();
             */
            /*
            THESE ARE DYNAMIC QUERY
             String sql = "INSERT INTO student VALUES (?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,103);
            pstm.setString(2,"Gautam");
            int i = pstm.executeUpdate();
            */
            String sql = "INSERT INTO student VALUES (?,?)";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                int rollNo =  rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("Roll No : "+rollNo+" Name : "+name);
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
//        RESULT SET NEED TO BE ADDED

    }
}
