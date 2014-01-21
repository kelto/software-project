<%-- 
    Document   : printUser
    Created on : 6 janv. 2014, 18:39:17
    Author     : kelto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p> User : <br />
        {{requestScope.user}}
        </p>
    </body>
</html>
