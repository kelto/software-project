<%-- 
    Document   : profile
    Created on : 27 févr. 2014, 22:27:19
    Author     : kelto
--%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<form class="box profile" action="<c:url value='/profile'/>" method="post">
    <fieldset class="boxBody">
        <label for="address">Address</label>
        <input id="address" type="text" name="address" value="${user.address}">${form.errors.address}
        <label for="email">email</label>
        <input type="email" name="email" id="email" value="${user.email}">${form.errors.email}
        <label for="password">Password</label>
        <input id="password" type="password" name="password">${form.errors.password}
        
    </fieldset>
    <footer>
        <input type="submit" value="Edit" class="btnLogin" >
        <p>${form.result}</p>
    </footer>
</form>
<%@include file="/WEB-INF/jspf/footer.jspf" %>