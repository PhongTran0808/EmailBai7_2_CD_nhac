package com.example.demo16.servlet;

import com.example.demo16.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User(email, firstName, lastName);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Tạo cookies nhớ 3 năm
        int threeYears = 60*60*24*365*3;

        Cookie emailC = new Cookie("userEmail", email);
        emailC.setMaxAge(threeYears);
        response.addCookie(emailC);

        Cookie fnC = new Cookie("userFirstName", firstName);
        fnC.setMaxAge(threeYears);
        response.addCookie(fnC);

        Cookie lnC = new Cookie("userLastName", lastName);
        lnC.setMaxAge(threeYears);
        response.addCookie(lnC);

        response.sendRedirect("index.jsp");
    }
}
