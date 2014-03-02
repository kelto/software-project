<%-- 
    Document   : create
    Created on : 1 mars 2014, 18:43:28
    Author     : kelto
--%>
<%@include file="/WEB-INF/view/admin/jspf/header.jspf" %>
<div id="main">
    <section id="content">
        <div id="right">
            
 <form  action="<c:url value="/admin/products/add"/>" method="post">
        <h3>Add Category</h3>        
        <label for="name">product name</label><input type="text" id = "name" name="product_name" /><br /><span class="error">${form.errors.name}</span>
        <label for="description">product description</label><textarea name="description"></textarea> <br /><span class="error">${form.errors.description}</span>
    <label for="buying">buying price</label><input type="text" id = "buying" name="buying_price" /><br /><span class="error">${form.errors.prices}</span>
    <label for="selling">selling price</label><input type="text" id = "selling" name="selling_price" /><br /><span class="error">${form.errors.prices}</span>
    <select name="category">
        <c:forEach items="${categoriesPool.categories}" var="category"><span class="error">${form.errors.category}</span>
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
    <span class="error">${form.result}</span>
        </div>
        <div id="left">
            
 
            
            <form action="<c:url value="/admin/category/add"/>" method="post">
        <h3>Add Category</h3>        
        <label for="category_name">name</label><input type="text" id = "category_name" name="category_name" /><br />
    
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
        </div>
</div>
</section>
<footer><!-- Defining the footer section of the page -->
    <div id="privacy">
        Copyright © 2014 <a class="link" href="#">Andrew,Daniel and Charles </a><br />

    </div>
</footer>
</div>
</body>
</html>                 

