<%-- 
    Document   : CreateUser
    Created on : 30 oct. 2013, 17:12:07
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
        <form id="CreateUserForm" action="CreateUser" method="post">
    
        <label for="username">username</label><input type="text" id = "username" name="username" /> <span class="erreur">${form.errors['username']}</span>
        <label for="password">password</label><input type="text" id = "password" name="password" />
        <label for="password_conf">password</label><input type="text" id = "password_conf" name="password_conf" />
        <label for="email">email</label><input type="text" id = "email" name="email" />
        <label for="address">address</label><input type="text" id = "address" name="address" />
    
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
        <p class="result">${form.result}</p>
        <span>${form.errors['login']}</span>
        <span>${form.errors['email']}</span>
        <span>${form.errors['address']}</span>
        <span>${form.errors['pass']}</span>
        <span>${form.errors['login']}</span>
<a href="ListUser"><strong>Go to List of users</strong></a>
        
    </body>
</html>
