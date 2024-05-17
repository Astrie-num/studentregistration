package student.registration.studentregistration;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        String password = request.getParameter("password");
        String email = request.getParameter("email");


//        private boolean isValidEmail(String email) {
//            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//            return email.matches(emailRegex);
//        }
//
//        private boolean isValidUsername(String username) {
//            // Implement username validation logic here
//            return !username.isEmpty(); // Placeholder for username validation
//        }
//
//        private boolean isValidPassword(String password) {
//            // Implement password validation using regular expressions
//            String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//            return password.matches(passwordRegex);
//        }
//


        if (password == null || password.isEmpty()) {
            // Handle invalid password
            request.setAttribute("error", "Password is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            // Handle invalid bankType
            request.setAttribute("error", "Email is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // If all parameters are valid, continue with the filter chain
        chain.doFilter(request, response);
    }
}

