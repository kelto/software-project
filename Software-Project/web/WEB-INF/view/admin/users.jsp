<%-- 
    Document   : users
    Created on : 28 févr. 2014, 02:28:16
    Author     : kelto
--%>
<%@include file="/WEB-INF/view/admin/jspf/header.jspf" %>
<div id="main">
    <section id="content">
        <div id="center">
            <h3>Users Administration</h3>
            <c:forEach var="user" items="${users}">
                <p>${user.username} 
                <form action="<c:url value='/admin/users/delete'/>" method="post">
                    <input type="hidden" value="${user.id}" name="user_id">
                    <input type="image" src="/Software-Project/img/delete.png" alt="delete">
                </form>
                </p>
            </c:forEach>
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
