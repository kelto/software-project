<%-- 
    Document   : CreateUser
    Created on : 30 oct. 2013, 17:12:07
    Author     : kelto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/form.css"/>" rel="stylesheet"  type="text/css">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form id="CreateUserForm" action="CreateUser" method="post">
    
        <label for="username">username</label><input type="text" id = "username" name="username" /> <span class="erreur">${form.errors['username']}</span><br />
        <label for="password">password</label><input type="text" id = "password" name="password" /><span class="erreur">${form.errors['password']}</span><br />
        <label for="password_conf">password</label><input type="text" id = "password_conf" name="password_conf" /><span class="erreur">${form.errors['password_conf']}</span><br />
        <label for="email">email</label><input type="text" id = "email" name="email" /><span class="erreur">${form.errors['email']}</span><br />
        <label for="address">address</label><input type="text" id = "address" name="address" /><span class="erreur">${form.errors['address']}</span><br />
    
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
        <p class="result">${form.result}</p>
<a href="ListUser"><strong>Go to List of users</strong></a>
        
    </body>
</html>
