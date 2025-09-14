<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<h2>List of Albums</h2>
<ul>
    <%
        java.util.List<String> albums = (java.util.List<String>) request.getAttribute("albums");
        if (albums != null) {
            for (String album : albums) {
    %>
    <li><%= album %></li>
    <%
            }
        }
    %>
</ul>

<%
    com.example.demo16.model.User user = (com.example.demo16.model.User) session.getAttribute("user");
    if (user == null) {
%>
<p style="text-align:center; margin-top:20px;">
    <a href="register.jsp"><button class="btn-primary">Register to download</button></a>
</p>
<%
} else {
%>
<p style="text-align:center; margin-top:20px;">
    <a href="download.jsp"><button class="btn-primary">Go to Downloads</button></a>
</p>
<p style="text-align:center; margin-top:10px;">
    <a href="viewCookies.jsp"><button class="btn-secondary">View All Cookies</button></a>
</p>
<p style="text-align:center; margin-top:10px;">
    <a href="logout"><button class="btn-secondary">Logout</button></a>
</p>
<%
    }
%>

<%@ include file="includes/footer.jsp" %>
