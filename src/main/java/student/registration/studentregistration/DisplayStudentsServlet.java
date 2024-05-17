package student.registration.studentregistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



    @WebServlet("/displayStudents")
    public class DisplayStudentsServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String url = "jdbc:mysql://localhost:3306/student_db";
            String username = "root";
            String password = "astrie123";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

                out.println("<html><title>");
                out.println("<style>");
                out.println("body {background-color: #303641;}");
                out.println("</style>");
                out.println("</title><body>");
                out.println("<h2>Students:</h2>");

                // Move the cursor to the first row
                if (resultSet.next()) {
                    do {
                        String lastname = resultSet.getString("last_name");
                        String firstname = resultSet.getString("first_name");
                        String email = resultSet.getString("email");
                        int age = resultSet.getInt("age");
//                        String username = resultSet.getString("username");
//                        String password= resultSet.getString("password");



                        out.println("<p>Last Name: " + lastname + "</p>");
                        out.println("<p>First Name: " + firstname + "</p>");
                        out.println("<p>Email: " + email + "</p>");
                        out.println("<p>Age: " + age + "</p>");
//                        out.println("<p>Instructor: " + password + "</p>");

                        out.println("<br>");

                    } while (resultSet.next());
                } else {
                    out.println("No students available.");
                }
                out.println("<a href='delete.jsp'>delete a student</a>");
                out.println("<a href='index.jsp'>Add a student</a>");
                out.println("</body></html>");

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exceptions (log or display an error message)
            }
        }

    }


