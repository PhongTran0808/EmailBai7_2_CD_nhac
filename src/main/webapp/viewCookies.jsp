<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<h2>All Cookies</h2>

<table border="1" cellpadding="8" cellspacing="0" style="margin:auto; width:60%; text-align:center; border-collapse:collapse;">
    <tr style="background:#f0f0f0;">
        <th>Cookie Name</th>
        <th>Cookie Value</th>
    </tr>
    <%
        jakarta.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie c : cookies) {
    %>
    <tr>
        <td><%= c.getName() %></td>
        <td><%= c.getValue() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<div style="text-align:center; margin-top:20px;">
    <a href="deleteCookies"><button class="btn-primary">Delete All Persistent Cookies</button></a>
</div>

<div style="text-align:center; margin-top:10px;">
    <form action="albums" method="get">
        <input type="submit" class="btn-secondary" value="Back to Album List">
    </form>
</div>

<%@ include file="includes/footer.jsp" %>
