<%-- 
    Document   : products
    Created on : 28 févr. 2014, 03:38:20
    Author     : kelto
--%>

<%@include file="/WEB-INF/view/admin/jspf/header.jspf" %>
<div id="main">
    <section id="content">
        <div id="center">
            <h3>Products Administration</h3>
            <c:forEach var="product" items="${products}">
                <p>${product.name} 
                <form action="<c:url value='/admin/products/delete'/>" method="post">
                    <input type="hidden" value="${product.id}" name="product_id">
                    <input type="image" src="/Software-Project/img/delete.png" alt="delete">
                </form>
                </p>
            </c:forEach>
                <p><c:forEach begin="0" end="${nbPages}" varStatus="loop">
                    <a href="<c:url value='/admin/products/${loop.count}'/>">${loop.count}</a></c:forEach></p>
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
