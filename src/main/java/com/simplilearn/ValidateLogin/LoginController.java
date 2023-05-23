package com.simplilearn.ValidateLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RequestDispatcher rd = null;

        if (username != null && password != null && username.equalsIgnoreCase("soumya") && password.equalsIgnoreCase("12345")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            String welcomeMessage = "<h4>Welcome " + username + ". Login Successful at " + dateFormat.format(new Date()) + ".</h4>";
            String logoutLink = "<a href=\"logout.html\"><b><h2>Logout.</h2></b></a>";
            rd = request.getRequestDispatcher("SuccessServlet");
            rd.include(request, response);
        } else {
            rd = request.getRequestDispatcher("login.html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Login</title></head>");
            out.println("<body>");
            out.println("<div style='display: flex; justify-content: center; align-items: center; height: 100vh;'>");
            out.println("<div style='text-align: center;'>");
            out.println("<h2>Invalid Credentials!</h2>");
            out.println("<a href='login.html'><button>Login</button></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}