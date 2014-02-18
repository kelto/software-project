<%-- 
    Document   : commentDone
    Created on : Feb 18, 2014, 1:55:05 PM
    Author     : Daniel
--%>

 <%@include file="/WEB-INF/jspf/header.jspf" %>
 <form action="<c:url value='/comment'/>" method="post">
       
     <input type="text" name="productId">
           <textarea name="comment"> </textarea>

        <p><strong>score:</strong>
            <input type="number" size="20" name="score"></p>

        <p><input type="submit" value="submit"></p>
     
 </form>
        <p>success : ${form.result} </p>
        <c:forEach var="error" items="${form.errors}">
            ${error}
        </c:forEach>
    </body>
</html>
