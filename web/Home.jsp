<%-- 
    Document   : Home
    Created on : Jun 3, 2021, 1:04:53 AM
    Author     : Foxxy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Home Page</h1>

        <h4>
            <a href="AddProductServlet">Add product</a>
            <br>
            <a href="LogoutServlet">Logout</a>
        </h4>
        <form action="HomeServlet" method="get">
            <select id="selected" name="select">
                <option selected disabled>Select</option>
                <c:forEach items="${listCate}" var="d">
                    <option value ="${d.categoryId}">${d.categoryName}</option>
                </c:forEach>
            </select>
            <input type="submit" name="submit" value="Submit">
        </form>
        <br>
        <br>
        <h1>List Product</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listP}" var="p">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.productName}</td>
                    <td>${p.price}</td>
                    <td><a href="EditProductServlet?productId=${p.productId}
                           &productName=${p.productName}&price=${p.price}">Edit</a></td>
                    <td><a href="DeleteProductServlet?productId=${p.productId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
