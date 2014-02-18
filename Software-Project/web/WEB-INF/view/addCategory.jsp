<%-- 
    Document   : addCategory
    Created on : 10 févr. 2014, 18:20:35
    Author     : kelto
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form id="CreateUserForm" action="addCategory" method="post">
    
        <label for="username">name</label><input type="text" id = "name" name="name" /><br />
    
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>

        
    </body>
</html>

