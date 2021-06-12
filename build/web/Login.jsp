<%-- 
    Document   : Login
    Created on : Jun 3, 2021, 12:08:26 AM
    Author     : Foxxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <h3>${mess}</h3>
        <form action="LoginServlet" method="post">
            username <input type="text" name="username" value="">
            <br>
            <br>
            password <input type="password" name="password" value="">
            <br>
            <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
