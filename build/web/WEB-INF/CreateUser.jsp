<%-- 
    Document   : CreateUser
    Created on : 25 oct. 2013, 19:56:35
    Author     : kelto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
        <tr><td>pseudo</td><td><input type="text" id = "pseudo" name="pseudo" /></td></tr>
        <tr><td>pass</td><td><input type="text" id = "pass" name="pass" /></td></tr>
        <tr><td>email</td><td><input type="text" id = "email" name="email" /></td></tr>
        <tr><td>adress</td><td><input type="text" id = "adress" name="adress" /></td></tr>
    </table>
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
<a href="ListPerson"><strong>Go to List of persons</strong></a>
        
    </body>
</html>
