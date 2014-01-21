<%-- 
    Document   : connection
    Created on : 7 nov. 2013, 12:11:15
    Author     : kelto
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connection</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
 
                <label for="login">login <span class="requis">*</span></label>
                <input type="text" id="login" name="login" value="<c:out value="${user.login}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['login']}</span>
                <br />
 
                <label for="motdepasse">password <span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['password']}</span>
                <br />
 
                <input type="submit" value="login" class="sansLabel" />
                <br />
                 
                <p class="${empty form.errors ? 'succes' : 'erreur'}">${form.results}</p>
            </fieldset>
        </form>
    </body>
</html>