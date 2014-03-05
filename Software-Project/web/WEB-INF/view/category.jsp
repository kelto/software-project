<%-- /* 
    Document   : category
    Created on : 20-Feb-2014, 18:51:29
    Author     : andrew
*/--%>



<%@include file="/WEB-INF/jspf/header.jspf" %>

<div id="main">
    <section id="content">
        <div id="left">
            <h3>${selectedCategory.name}</h3>
            <ul>
                <li>
                    <c:forEach var="product" items="${listProducts}" varStatus="iter">
                        <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post3.jpg"></a>
                        </div>
                        <div class="info">
                            <a class="title" href="<c:url value="/product">
  <c:param name="productId" value="${product.id}"/>
                   </c:url>">${product.name}</a>
                            <p>${product.description}</p>
                            <div class="price">
                                <span class="st">Our price:</span><strong>$${product.sellingPrice}</strong>
                            </div>
                            <form action="<c:url value='/add'/>" method="post">
                                <input type="hidden"
                                       name="productId"
                                       value="${product.id}">
                                <input type="submit"
                                       name="submit"
                                       value="add to cart">
                            </form>
                        </div>
                    </c:forEach>
                </li>
            </ul>
        </div>	
    </section>
</div>


<%@include file="/WEB-INF/jspf/footer.jspf" %>                      