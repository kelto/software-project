<%-- 
    Document   : done
    Created on : 17 févr. 2014, 16:51:28
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
        <h1>Purchase done</h1>
        <p>id : ${requestScope.orderId}</p>
        <p>id (session) : ${orderId}</p>
        <p>user : ${user.username}</p>
        <p>cart : ${cart}</p>
        <p>error : ${requestScope.purchaseError}</p>
    </body>
</html>
