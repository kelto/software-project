<%-- 
    Document   : category
    Created on : 5 févr. 2014, 20:29:28
    Author     : kelto
--%>
        
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <%@include file="/WEB-INF/jspf/user.jspf" %>
        <c:if test="${ !empty user}">
            <%@include file="/WEB-INF/jspf/commentForm.jspf" %>
        </c:if>
        <h1>List Category</h1>
        <div id="categoryLeftColumn">
            for(Product product : productsPool.getTopSellMock)
            <c:forEach var="product" items="${productsPool.topSellMock}">
                <tr>
                

                <td>
                    ${product.name}
                    <br>
                    <span class="smallText">${product.description}</span>
                </td>

                <td>&euro; ${product.sellingPrice}</td>

                <td>
                    <form action="<c:url value='/addToCart'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>
                
            </c:forEach>
    <c:forEach var="category" items="${categoriesPool.categories}">

        <c:choose>
            <c:when test="${category.name == selectedCategory.name}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/category/${category.name}'/>" class="categoryButton">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>

</div>

<div id="categoryRightColumn">

    <p id="categoryTitle"><fmt:message key="${selectedCategory.name}" /></p>

    <table id="productTable">

        <c:forEach var="product" items="${listProducts}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                

                <td>
                    ${product.name}
                    <br>
                    <span class="smallText">${product.description}</span>
                </td>

                <td>&euro; ${product.sellingPrice}</td>

                <td>
                    <form action="<c:url value='/addToCart'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
    </body>
</html>
