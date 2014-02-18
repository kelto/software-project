<%-- 
    Document   : index
    Created on : 3 févr. 2014, 18:13:46
    Author     : kelto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>${user.username}</h2>
        <c:forEach var="category" items="${categories}">
        <a href="category/${category.name}">

                            <span class="categoryLabelText">${category.name}</span> <br />
        </c:forEach>
    </body>
</html>
