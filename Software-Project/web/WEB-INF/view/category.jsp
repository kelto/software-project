<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <%--<%@include file="/WEB-INF/jspf/user.jspf" %>
 --%>
 
<%@include file="/WEB-INF/jspf/header.jspf" %>


<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<body>

<!DOCTYPE html>
<div id="main"><!-- Defining submain content section -->
            <section id="content"><!-s- Defining the content section #2 -->
               <div id="left">
                    <h3>${selectedCategory.name}</h3>
                    <ul>
                        <li>
                        <c:forEach var="product" items="${listProducts}" varStatus="iter">
			<div class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
			</div>
                            <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post3.jpg"></a></div>
                            <div class="info">
                                <a class="title" href="#">${product.name}</a>
                                <p>${product.description}</p>
                                <div class="price">
                                    <span class="st">Our price:</span><strong>$${product.sellingPrice}</strong>
                                </div>
                                 <form action="<c:url value='/addToCart'/>" method="post">
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
             
  </body>                    
                        
  <%@include file="/WEB-INF/jspf/footer.jspf" %>                      