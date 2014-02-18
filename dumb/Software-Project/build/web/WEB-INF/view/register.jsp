<%-- 
    Document   : register
    Created on : 17 févr. 2014, 15:37:53
    Author     : kelto
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
        <h1>Register</h1>
        <form id="CreateUserForm" action="<c:url value='register'/>" method="post">
    
        <label for="username">username</label><input type="text" id = "username" name="username" /> <span class="erreur">${form.errors['username']}</span><br />
        <label for="password">password</label><input type="text" id = "password" name="password" /><span class="erreur">${form.errors['password']}</span><br />
        <label for="password_conf">password</label><input type="text" id = "password_conf" name="password_conf" /><span class="erreur">${form.errors['password_conf']}</span><br />
        <label for="email">email</label><input type="text" id = "email" name="email" /><span class="erreur">${form.errors['email']}</span><br />
        <label for="address">address</label><input type="text" id = "address" name="address" /><span class="erreur">${form.errors['address']}</span><br />
    
    <input type="submit" id="register" value="register" />
    </form>
        <p class="result">${form.result}</p>

        
    </body>
</html>
