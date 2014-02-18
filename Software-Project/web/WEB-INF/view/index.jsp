<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="/WEB-INF/jspf/user.jspf" %>
<%@include file="/WEB-INF/jspf/header.jspf" %>


<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <meta charset="utf-8">
	
	<c:if test="${ !empty user}">
            <%@include file="/WEB-INF/jspf/commentForm.jspf" %>
   </c:if>

  <!-- Linking styles -->
    <link rel="stylesheet" href="/Software-Project/css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/Software-Project/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/Software-Project/css/nivo-slider.css" type="text/css" media="screen">

    <!-- Linking scripts -->
    <script src="/Software-Project/js/jquery.js" type="text/javascript"></script>
    <script src="/Software-Project/js/jquery.nivo.slider.pack.js" type="text/javascript"></script>
    <script src="/Software-Project/js/main.js" type="text/javascript"></script>
    <script type="text/javascript" src="/Software-Project/js/html5.js"></script>
   
    
    
     <title><fmt:message key='title' /></title>
</head>
<body>
 <div id="main">
 <section id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                    <img style="display: none;" src="/Software-Project/img/promo1.jpg" alt="" title="#htmlcaption-1">
                    <img style="display: none;" src="/Software-Project/img/promo2.jpg" alt="" title="#htmlcaption-2">
                    <img style="display: none;" src="/Software-Project/img/promo3.jpg" alt="" title="#htmlcaption-3">
                </div>
                <div id="htmlcaption-1" class="nivo-html-caption">
                    <h5 class="p2">Welcome to the our E-Shop</h5>
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-1" class="nivo-html-caption">
                    <h5 class="p2">This is promo area</h5>
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-2" class="nivo-html-caption">
                    <h5 class="p2">Where you can add any feature products</h5>
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-3" class="nivo-html-caption">
                    <h5 class="p2">Or something else</h5>
                    <p>Put any description here</p>
                </div>
            </section>
        </div>

        <div id="main"><!-- Defining submain content section -->
            <section id="content"><!-- Defining the content section #2 -->
               <div id="left">
                    <h3> <p id="categoryTitle"><fmt:message key="${selectedCategory.name}" /></p></h3>
                    <ul>
                        <li>
                        <c:forEach var="product" items="${listProducts}" varStatus="iter">
			<div class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
			</div>
                            <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post1.jpg"></a></div>
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
                
                
                
                
    
    <div id="right">
       <h3>Top sellers</h3>
         <ul>
          <li>
          <c:forEach var="product" items="${productsPool.topSellMock}">
                            <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post1.jpg"></a></div>
                            <div class="info">
                            
                                <a class="title" href="#"> ${product.name}</a>
                                <div class="price">
                                    
                                    <span class="special">&euro; ${product.sellingPrice} </span>
                                </div>
                            
                                 <form action="<c:url value='addToCart'/>" method="post">
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