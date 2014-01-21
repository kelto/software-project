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
    <table>
        <tr><td>pseudo</td><td><input type="text" id = "login" name="login" /></td></tr>
        <tr><td>pass</td><td><input type="text" id = "pass" name="pass" /></td></tr>
        <tr><td>conf</td><td><input type="text" id = "pass_conf" name="pass_conf" /></td></tr>
        <tr><td>email</td><td><input type="text" id = "email" name="email" /></td></tr>
        <tr><td>adress</td><td><input type="text" id = "address" name="address" /></td></tr>
    </table>
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
