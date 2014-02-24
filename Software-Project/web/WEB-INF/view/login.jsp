<%-- /* 
    Document   : login
    Created on : 23-Feb-2014, 21:51:51
    Author     : andrew
*/--%>



<%@include file="/WEB-INF/jspf/header.jspf" %>


<body>
<form class="box login" action="login_check" method=post>
	<fieldset class="boxBody">
	  <label>Username</label>
	  <input type="text" tabindex="1" placeholder="PremiumPixel" required name="username">
	  <input type="password" tabindex="2" required name="password">
	</fieldset>
	<footer>
	<input type="submit" class="btnLogin" value="submit" tabindex="4">
    <c:if test="${ !empty error}"><p class="error">the username and/or password is incorrect</p></c:if>
	</footer>
</form>

</body>





