package com.example.demo16.servlet;

import com.example.demo16.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            // Nếu chưa đăng ký → quay về trang đăng ký
            String url = "/register.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }

        // Nếu đã có user → cho phép tải nhạc
        String file = request.getParameter("file");
        if (file == null) {
            response.sendRedirect("albums");
            return;
        }

        String path = getServletContext().getRealPath("/music/" + file);
        File downloadFile = new File(path);

        if (!downloadFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType("audio/mpeg");
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadFile.getName());

        try (FileInputStream in = new FileInputStream(downloadFile);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
