package com.example.demo16.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Hủy session
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();

        // Xóa cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("userEmail".equals(c.getName()) ||
                        "userFirstName".equals(c.getName()) ||
                        "userLastName".equals(c.getName())) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        response.sendRedirect("albums");
    }
}
