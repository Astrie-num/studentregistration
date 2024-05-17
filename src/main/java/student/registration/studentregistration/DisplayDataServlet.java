
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


@WebServlet("/displayData")
public class DisplayDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/subject_db";
        String username = "root";
        String password = "astrie123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subjects");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Subjects: </title>");
            out.println("</head>");
            out.println("<body>");

            if (resultSet.next()) {
                do {
                    String subjectId = resultSet.getString("subject_id");
                    String subjectName = resultSet.getString("subject_name");
                    String subjectTeacher = resultSet.getString("subject_teacher");


                    out.println("<p>Subject ID: " + subjectId + "</p>");
                    out.println("<p>Subject Name: " + subjectName + "</p>");
                    out.println("<p>Instructor: " + subjectTeacher + "</p>");
                    out.println("<br>");

                } while (resultSet.next());
            } else {
                out.println("No subjects available.");
            }
            out.println("<a href='delete.jsp'>DELETE SUBJECT</a>");
            out.println("<a href='index.jsp'>ADD SUBJECT</a>");
            out.println("</body></html>");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (log or display an error message)
        }
    }

}
