<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>
<link rel="stylesheet" href="css/main.css" type="text/css">

<h2>Download Registration</h2>
<p>To register for our downloads, enter your name and email address below. Then, click on the Submit button.</p>

<form action="register" method="post">
    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>First Name:</label><br>
    <input type="text" name="firstName" required><br><br>

    <label>Last Name:</label><br>
    <input type="text" name="lastName" required><br><br>

    <input type="submit" class="btn-primary" value="Submit">
</form>

<%@ include file="includes/footer.jsp" %>
