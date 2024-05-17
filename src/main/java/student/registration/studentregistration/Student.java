package student.registration.studentregistration;


import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/addStudent")
public class Student {
    public void addStudent(String last_name, String first_name, String email, int age, String username, String password) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String pass = "astrie123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO student (last_name, first_name, email, age, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, last_name);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("The values were successfully inserted!");
            }

//            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM student");
//
//            while (resultSet.next()) {
//                System.out.println("last_name: " + resultSet.getString("last_name") + ", "
//                        + "first_name: " + resultSet.getString("first_name") + ", "
//                        + "email: " + resultSet.getString("email") + ", "
//                        + "age : " + resultSet.getInt("age"));
//            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

}
