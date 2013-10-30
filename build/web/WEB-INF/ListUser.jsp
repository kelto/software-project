<%-- 
    Document   : ListUsers
    Created on : 25 oct. 2013, 19:39:18
    Author     : kelto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users</title>
    </head>
    <body>
        <h1>List User in database</h1>
        
        <table id="personListTable" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>FirstName</th>
    <th bgcolor=>LastName</th>
</tr>
<c:forEach var="user" begin="0" items="${requestScope.userList}">
<tr>
    <td>${user.id}&nbsp;&nbsp;</td> 
    <td>${user.pseudo}&nbsp;&nbsp;</td> 
    <td>${user.adress}&nbsp;&nbsp;</td> 
</tr> 

</c:forEach>

</table>
<a href="createUser.jsp"><strong>Create a user Record</strong></a>
    </body>
</html>
