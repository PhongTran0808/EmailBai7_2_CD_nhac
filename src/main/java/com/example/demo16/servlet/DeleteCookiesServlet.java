package com.example.demo16.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);   // xoá cookie
                c.setPath("/");   // quan trọng: xoá đúng path
                response.addCookie(c);
            }
        }

        response.sendRedirect("viewCookies.jsp");
    }
}
