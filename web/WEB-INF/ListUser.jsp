<%-- 
    Document   : ListUsers
    Created on : 25 oct. 2013, 19:39:18
    Author     : kelto
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Persons</title>
    </head>
    <body>

    <h1>List of Persons currently in Database</h1>
    
<table id="userListTable" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>pseudo</th>
    <th bgcolor=>pass</th>
    <th bgcolor=>email</th>
    <th bgcolor=>address</th>
</tr>
<c:forEach var="person" begin="0" items="${requestScope.userList}">
<tr>
    <td>${person.idUser}&nbsp;&nbsp;</td> 
    <td>${person.pseudo}&nbsp;&nbsp;</td> 
    <td>${person.password}&nbsp;&nbsp;</td> 
    <td>${person.email}&nbsp;&nbsp;</td> 
    <td>${person.address}&nbsp;&nbsp;</td> 
</tr> 

</c:forEach>

</table>
<a href="CreateUser.jsp"><strong>Create a UserRecord</strong></a>
</body>
</html>
