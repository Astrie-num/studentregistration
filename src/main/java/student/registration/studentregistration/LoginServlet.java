package student.registration.studentregistration;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        // String bankType = req.getParameter("bankType");
        ResultSet resultSet = insertData(email);
        try {
            if (resultSet.next()) {
                // You can access the columns of the ResultSet here
                String retrievedEmail = resultSet.getString("email");
                String retrievedPassword = resultSet.getString("password");
                String retrievedUsername = resultSet.getString("username");
//                System.out.println(username);

                // Perform your desired logic here
                if (email.equals(retrievedEmail) && password.equals(retrievedPassword)) {
                    // Successful login
                    HttpSession session = req.getSession();
                    session.setAttribute("username", email);
//                    session.setAttribute("amount",amount);
                    res.sendRedirect("view.jsp");
                } else {
                    // Invalid email or password
                    req.setAttribute("error", "Invalid email or password");
                    req.getRequestDispatcher("error.jsp").forward(req, res);
                }
            } else {
                // User not found
                req.setAttribute("error", "User not found");
                req.getRequestDispatcher("error.jsp").forward(req, res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet insertData(String email) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "astrie123";

        String sql = "SELECT * FROM  student where email=? ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);

            return st.executeQuery();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}