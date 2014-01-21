<%-- 
    Document   : ListProduct
    Created on : 1 nov. 2013, 19:00:44
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
        <title>List Of Product</title>
    </head>
    <body>

    <h1>List of Product currently in Database</h1>
    
<table id="productListTable" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>productName</th>
    <th bgcolor=>description</th>
    <th bgcolor=>buying price</th>
    <th bgcolor=>selling price</th>
    <th bgcolor=>brand</th>
    <th bgcolor=>tag</th>
</tr>
<c:forEach var="product" begin="0" items="${requestScope.productList}">
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