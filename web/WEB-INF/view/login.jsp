<%-- 
    Document   : login
    Created on : 5 févr. 2014, 19:02:36
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
        <h2>${user.username}</h2>
        <form action="login_check" method=post>
    <div id="loginBox">
        <p><strong>username:</strong>
            <input type="text" size="20" name="username"></p>

        <p><strong>password:</strong>
            <input type="password" size="20" name="password"></p>

        <p><input type="submit" value="submit"></p>
        <c:if test="${ !empty error}"><p class="error">the username and/or password is incorrect</p></c:if>
    </div>
</form>
    </body>
</html>
