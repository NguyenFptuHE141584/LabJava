<%-- 
    Document   : AddProduct
    Created on : Jun 9, 2021, 4:53:34 PM
    Author     : Foxxy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Product</h1>
        <form action="AddProductServlet" method="post">
            Product ID<input type="text" name="productId">
            <br>
            <br>
            Product Name<input type="text" name="productName" >
            <br>
            <br>
            Price<input type="text" name="price" >
            <br>
            <br>
            <select id="selected" name="select">
                <option selected disabled>Select</option>
                <c:forEach items="${listCate}" var="d">
                    <option value ="${d.categoryId}">${d.categoryName}</option>
                </c:forEach>
            </select>   
            <input type="submit" value="Add Product" name="btnAdd">
        </form>
    </body>
</html>
