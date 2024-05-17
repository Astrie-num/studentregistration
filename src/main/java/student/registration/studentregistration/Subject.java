

package student.registration.studentregistration;


import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/addStudent")
public class Subject {
    public void addSubject(String subject_name, String subject_teacher) {
        String url = "jdbc:mysql://localhost:3306/subject_db";
        String user = "root";
        String pass = "astrie123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO subjects (subject_name, subject_teacher) VALUES ( ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subject_name);
            preparedStatement.setString(2, subject_teacher);


            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("The subject was successfully added!");
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
