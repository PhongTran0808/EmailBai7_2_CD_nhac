package com.example.demo16.servlet;

import com.example.demo16.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class AlbumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Nếu chưa có user trong session → thử lấy từ cookies
        if (user == null) {
            String email = null, firstName = null, lastName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    switch (c.getName()) {
                        case "userEmail": email = c.getValue(); break;
                        case "userFirstName": firstName = c.getValue(); break;
                        case "userLastName": lastName = c.getValue(); break;
                    }
                }
            }
            if (email != null && firstName != null && lastName != null) {
                user = new User(email, firstName, lastName);
                session.setAttribute("user", user);
            }
        }

        // Danh sách album
        List<String> albums = new ArrayList<>();
        albums.add("86 (the band) - True Life Songs and Pictures");
        albums.add("Paddlefoot - The First CD");
        albums.add("Paddlefoot - The Second CD");
        albums.add("Joe Rut - Genuine Wood Grained Finish");

        request.setAttribute("albums", albums);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
