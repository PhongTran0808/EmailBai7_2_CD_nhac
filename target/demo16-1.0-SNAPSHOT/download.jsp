<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<div class="form-center">
    <h2>Download Page</h2>

    <%
        com.example.demo16.model.User user = (com.example.demo16.model.User) session.getAttribute("user");
        if (user != null) {
    %>
    <p><b>Email:</b> <%= user.getEmail() %></p>
    <p><b>First Name:</b> <%= user.getFirstName() %></p>
    <p><b>Last Name:</b> <%= user.getLastName() %></p>
    <%
        }
    %>
</div>

<h3 style="text-align:center;">Available Downloads</h3>

<table border="1" cellpadding="8" cellspacing="0"
       style="margin:auto; width:80%; text-align:left; border-collapse:collapse;">
    <tr style="background:#f0f0f0;">
        <th>Song / Album</th>
        <th>Format</th>
    </tr>
    <tr>
        <td><a href="download?file=86_true_life.mp3">86 (the band) - True Life Songs and Pictures</a></td>
        <td>MP3</td>
    </tr>
    <tr>
        <td><a href="download?file=paddlefoot_first.mp3">Paddlefoot - The First CD</a></td>
        <td>MP3</td>
    </tr>
    <tr>
        <td><a href="download?file=paddlefoot_second.mp3">Paddlefoot - The Second CD</a></td>
        <td>MP3</td>
    </tr>
    <tr>
        <td><a href="download?file=joe_rut_genuine.mp3">Joe Rut - Genuine Wood Grained Finish</a></td>
        <td>MP3</td>
    </tr>
</table>

<form action="albums" method="get" style="margin-top:20px; text-align:center;">
    <input type="submit" value="Back to Album List" class="btn-primary">
</form>


<%@ include file="includes/footer.jsp" %>
