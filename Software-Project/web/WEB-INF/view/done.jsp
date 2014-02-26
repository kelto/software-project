

<%@include file="/WEB-INF/jspf/header.jspf" %>

    <body>
        <div id="main1">
            <div class="container">
        <h1>Congratulations your purchase is Complete ! </h1>
        <legend>Purchase Info</legend>
        <p>id : ${requestScope.orderId}</p>
        <p>id (session) : ${orderId}</p>
        <p>user : ${user.username}</p>
        <p>cart : ${cart}</p>
        <p>error : ${requestScope.purchaseError}</p>
        </div>
           </div>           
    </body>
    
</html>


<%@include file="/WEB-INF/jspf/footer.jspf" %>