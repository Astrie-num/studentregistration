package student.registration.studentregistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class AddSubjectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject_name = request.getParameter("subject_name");
        String subject_teacher = request.getParameter("subject_teacher");



        Subject subject = new Subject();
        subject.addSubject(subject_name,subject_teacher);

        response.sendRedirect("view.jsp");

//        System.out.println("Last Name: " + last_name);
//        System.out.println("First Name: " + first_name);
//        System.out.println("Email: " + email);
//        System.out.println("Age: " + age);


    }

}
