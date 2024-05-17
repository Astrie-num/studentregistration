package student.registration.studentregistration;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
     private RequestDispatcher dispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
//        System.out.println(first_name);

        RegisterDao signUpDao = new RegisterDao();

        if (signUpDao.checkEmail(email)) {
            req.setAttribute("error", "Email already exists");
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, res);
            System.out.println("error here on validation of email");
        }
        int resultSet = insertData(first_name, last_name, username, email, password, age);
        System.out.println(resultSet);
        if (resultSet == 1) {
            System.out.println("success register");
            System.out.println(resultSet);
            req.setAttribute("success", "you have created account successfully");
            RequestDispatcher dispatcher1 = req.getRequestDispatcher("login.jsp");
            dispatcher1.forward(req, res);
        } else {
            System.out.println("error during registratiton");
            req.setAttribute("error", "error during creating user");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, res);
        }


    }

    private int insertData(String first_name, String last_name, String username, String email, String password, int age) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String usernameDb = "root";
        String passwordDb = "astrie123";
        String sql = "INSERT INTO student (first_name, last_name,username,email,password,age) VALUES(?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, usernameDb, passwordDb);
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, first_name);
            st.setString(2, last_name);
            st.setString(3, username);
            st.setString(4, email);
            st.setString(5, password);
            st.setInt(6, age);
            st.executeUpdate();
            System.out.println("successfully ");
            return 1;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}