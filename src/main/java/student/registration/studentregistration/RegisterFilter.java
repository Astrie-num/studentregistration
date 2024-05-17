package student.registration.studentregistration;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/register")
public class RegisterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
//        String firstname = req.getParameter("first_name");
//        String lastname = req.getParameter("last_name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        if (username == null || username.trim().isEmpty()) {
            // Handle invalid username
            request.setAttribute("error", "Username is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            // Handle invalid email
            request.setAttribute("error", "Email is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (password == null || password.isEmpty()) {
            // Handle invalid password
            request.setAttribute("error", "Password is required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (password.length() > 10){
            request.setAttribute("error", "Password must be less than 10 characters.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;

        }

        if (password.length() < 7){
            request.setAttribute("error", "Password must be between 7 and 10 characters.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;

        }

        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        if (!Pattern.matches(passwordPattern, password)) {
            request.setAttribute("error", "Password must contain numbers, uppercase, lowercase and special characters.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (age < 16) {
            request.setAttribute("error", " age must be equal to 16 or greater ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        } else if (age > 20) {

            request.setAttribute("error", " age must be equal to 16 or less ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // If all parameters are valid, continue with the filter chain
        chain.doFilter(request, response);
    }
}