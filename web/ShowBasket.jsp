<%-- 
    Document   : ShowBasket
    Created on : Jan 19, 2014, 6:26:52 PM
    Author     : Daniel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>[USER] Basket</h1>
        
        <table id="basketList" border="3">
<tr>
    <th bgcolor=>ID</th>
    <th bgcolor=>productName</th>
    <th bgcolor=>description</th>
    <th bgcolor=>buying price</th>
    <th bgcolor=>selling price</th>
    <th bgcolor=>brand</th>
    <th bgcolor=>tag</th>
</tr>
<c:if test="${ empty requestScope.basket }" >
    basket doesnt exist, problem !
</c:if>
    
    <table>
     <c:forEach items="${requestScope.basket}" var="product">
        <tr>           
           <td>${product.idProduct}&nbsp;&nbsp;</td> 
           <td>${product.productName}&nbsp;&nbsp;</td> 
           <td>${product.productDescription}&nbsp;&nbsp;</td> 
           <td>${product.buyingPrice}&nbsp;&nbsp;</td> 
           <td>${product.sellingPrice}&nbsp;&nbsp;</td> 
           <td>${product.brand.name}&nbsp;&nbsp;</td> 
           <td>${product.tag.name}&nbsp;&nbsp;</td> 
        </tr>
     </c:forEach>
    </table>
    
    
    
    
    
    </body>
</html>
