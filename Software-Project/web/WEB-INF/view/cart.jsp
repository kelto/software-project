<%-- /* 
    Document   : cart
    Created on : 18-Feb-2014, 12:11:21
    Author     : andrew
*/--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>            

<body>
    <div id="main">
<div id="singleColumn">

   <c:if test="${!empty cart && cart.numberItems != 0}">

     

      <table id="cartTable">

        <tr class="header">
            <th>product</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
        </tr>

        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

          <c:set var="product" value="${cartItem.product}"/>

          <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">

            <td> <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post2.jpg"></a></div></td>

            <td>${product.name}</td>
            
            <td>
                
                &euro; ${cartItem.total}
                <br>
                <span class="smallText">( &euro; ${product.sellingPrice} / unit )</span>
            </td>

            <td>
                <form action="<c:url value='update'/>" method="post">
                    <input type="hidden"
                           name="productId"
                           value="${product.id}">
                    <input type="text"
                           maxlength="1"
                           size="1"
                           value="${cartItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           name="submit"
                           value="update">
                </form>
            </td>
          </tr>

        </c:forEach>

      </table>

    </c:if>
</div>
        
    <div id="actionBar">
         <h4 id="subtotal">subtotal: &euro; ${cart.total}</h4>
        <%-- clear cart widget --%>
        <c:if test="${!empty cart && cart.numberItems != 0}">

            <c:url var="url" value="viewCart">
                <c:param name="clear" value="true"/>
            </c:url>

            <a href="${url}" class="bubble hMargin">clear cart</a>
        </c:if>

        <%-- continue shopping widget --%>
        <c:set var="value">
            <c:choose>
                <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
                <c:when test="${!empty selectedCategory}">
                    category
                </c:when>
                <%-- otherwise send user to welcome page --%>
                <c:otherwise>
                    /category
                </c:otherwise>
            </c:choose>
        </c:set>
                    
        <c:choose>
        <c:when test="${cart.numberItems > 1}">
            <p>Your shopping cart contains ${cart.numberItems} items.</p>
        </c:when>
        <c:when test="${cart.numberItems == 1}">
            <p>Your shopping cart contains ${cart.numberItems} item.</p>
        </c:when>
        <c:otherwise>
            <p><b>Your shopping cart is empty.</b></p>
        </c:otherwise>
        </c:choose> 
                    
        <c:url var="url" value="${value}"/>
        <a href="${url}" class="bubble hMargin">continue shopping</a>
        <br>

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberItems != 0}">
            <a href="<c:url value='checkout'/>" class="bubble hMargin">proceed to checkout &#x279f;</a>
        </c:if>
    </div>  
   </div>     
    </body>


<%@include file="/WEB-INF/jspf/footer.jspf" %>       
