package student.registration.studentregistration;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/deleteData")
public class DeleteDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/subject_db";
        String username = "root";
        String password = "astrie123";


        int subject_id = Integer.parseInt(request.getParameter("subject_id"));
//        String subject_name = String.(request.getParameter("subject_name"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM subjects WHERE subject_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, subject_id);
//            preparedStatement.setString(1, subject_name);


            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                response.sendRedirect("displayData.jsp");
            } else {
                out.println("<html><body>");
                out.println("<h2>No data subjects to delete.</h2>");
                out.println("</body></html>");
            }

            connection.close();
        } catch (Exception e) {
            out.println("An error occurred: " + e.getMessage());
        }
    }
}

