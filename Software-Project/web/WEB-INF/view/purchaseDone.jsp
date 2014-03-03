

<%@include file="/WEB-INF/jspf/header.jspf" %>

    <body>
        <div id="main1">
            <div class="container">
                <c:choose>
                <c:when test="${success}">
        <h1>Congratulations your purchase is Complete ! </h1>
        <legend>Purchase Info</legend>
            <p>confirmation number : ${order.confirmationNumber}</p>
            <p>amount : ${order.amount}</p>
                </c:when>
            <c:otherwise>
                <h1>Failed to complete your purchase </h1>
                <p>Reason :</p>
                <c:forEach items="${form.errors}" var="error">
                    <p>${error.key} : ${error.value}</p>
                </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
           </div>           
    </body>
    
</html>


<%@include file="/WEB-INF/jspf/footer.jspf" %>