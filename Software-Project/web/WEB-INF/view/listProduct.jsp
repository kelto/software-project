<%-- 
    Document   : listProduct
    Created on : 3 mars 2014, 15:52:51
    Author     : kelto
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:forEach items="${searchResult}" var="product">
            <p>${product.name}</p>
            
        </c:forEach>
    </body>
</html>
