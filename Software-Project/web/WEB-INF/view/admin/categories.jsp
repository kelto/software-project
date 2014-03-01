<%-- 
    Document   : categories
    Created on : 1 mars 2014, 17:54:17
    Author     : kelto
--%>

<%@include file="/WEB-INF/view/admin/jspf/header.jspf" %>
<div id="main">
    <section id="content">
        <div id="center">
            <h3>Categories Administration</h3>
            <c:forEach var="category" items="${categories}">
                <p>${category.name} 
                <form action="<c:url value='/admin/category/delete'/>" method="post">
                    <input type="hidden" value="${category.id}" name="category_id">
                    <input type="image" src="/Software-Project/img/delete.png" alt="delete">
                </form>
                </p>
            </c:forEach>
                <p><c:forEach begin="0" end="${nbPages}" varStatus="loop">
                    <a href="<c:url value='/admin/users/category/${loop.count}'/>">${loop.count}</a></c:forEach></p>
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

