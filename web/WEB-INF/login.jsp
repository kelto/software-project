<%-- 
    Document   : login
    Created on : 30 oct. 2013, 17:12:07
    Author     : kelto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${ empty sessionScope.user}" >
    
    
                <form id="LoginForm" action="ConnectionServlet" method="post">
                    <table>
                        <tr><td>pseudo</td><td><input type="text" id = "login" name="login" /></td></tr>
                        <tr><td>pass</td><td><input type="text" id = "pass" name="password" /></td></tr>
                    </table>
                    <input type="submit" id="submitLogin" value="Login" />
                </form>
                <span>${error}</span>
        </c:when>
        <c:otherwise>
            <p>You're already login</p>
            <a href="logout">Logout</a>
        </c:otherwise>
    </c:choose>
<a href="ListUser"><strong>Go to List of users</strong></a>
        
    </body>
</html>
