<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <%--<%@include file="/WEB-INF/jspf/user.jspf" %>
 --%>
 
<%@include file="/WEB-INF/jspf/header.jspf" %>


<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en"><head>

</head>
<body>
    <div id="main">
        <section id="cart">

 

      <c:choose>
        <c:when test="${cart.numberItems > 1}">
            <p>Your shopping cart contains ${cart.numberItems} items.</p>
        </c:when>
        <c:when test="${cart.numberItems == 1}">
            <p>Your shopping cart contains ${cart.numberItems} item.</p>
        </c:when>
        <c:otherwise>
            <p>Your shopping cart is empty.</p>
        </c:otherwise>
    </c:choose>

    <div id="actionBar">
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

        <c:url var="url" value="${value}"/>
        <a href="${url}" class="bubble hMargin">continue shopping</a>

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberItems != 0}">
            <a href="<c:url value='checkout'/>" class="bubble hMargin">proceed to checkout &#x279f;</a>
        </c:if>
    </div>

    <c:if test="${!empty cart && cart.numberItems != 0}">

      <h4 id="subtotal">subtotal: &euro; ${cart.total}</h4>

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

            <td>${product.name}</td>

            <td>
                &euro; ${cartItem.total}
                <br>
                <span class="smallText">( &euro; ${product.sellingPrice} / unit )</span>
            </td>

            <td>
                <form action="<c:url value='updateCart'/>" method="post">
                    <input type="hidden"
                           name="productId"
                           value="${product.id}">
                    <input type="text"
                           maxlength="2"
                           size="2"
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
</section>
    </div>
</body>        
        
        
                        
  <%@include file="/WEB-INF/jspf/footer.jspf" %>                      