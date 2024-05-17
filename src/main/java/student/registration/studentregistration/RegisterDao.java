package student.registration.studentregistration;


import java.sql.*;

public class RegisterDao {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "astrie123";
    String sql = "SELECT * FROM  student where email=? ";

    public  boolean checkEmail(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}