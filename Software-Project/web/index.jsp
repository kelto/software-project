<%-- 
    Document   : index
    Created on : 27 févr. 2014, 21:37:25
    Author     : kelto
--%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div id="main">
 <section id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                    <img style="display: none;" src="/Software-Project/img/promo1.jpg" alt="" title="#htmlcaption-1">
                    <img style="display: none;" src="/Software-Project/img/promo2.jpg" alt="" title="#htmlcaption-2">
                    <img style="display: none;" src="/Software-Project/img/promo3.jpg" alt="" title="#htmlcaption-3">
                </div>
                <div id="htmlcaption-1" class="nivo-html-caption">
                    <h5 class="p2">Welcome to the our E-Shop</h5>
                    <p></p>
                </div>
                <div id="htmlcaption-2" class="nivo-html-caption">
                    <h5 class="p2">20% off on all laptops this weekend !!</h5>
                    <p></p>
                </div>
                <div id="htmlcaption-3" class="nivo-html-caption">
                    <h5 class="p2">Buy one get one free on all hard disks </h5>
                    <p></p>
                </div>
                <div id="htmlcaption-4" class="nivo-html-caption">
                    <h5 class="p2">We will double Ram on all Pc purchases over 600</h5>
                    <p></p>
                </div>
            </section>
        </div>

        <div id="submain"><!-- Defining submain content section -->
            <section id="content"><!-- Defining the content section #2 -->
               <div id="left">
                    <h3>Last Product </h3>
                    <ul>
                        
                       
                        <c:forEach var="product" items="${productsPool.topSellMock}">
			
                            <li>
                            <div class="img"><a href="#"><img alt="" src="/Software-Project/img/post4.jpg"></a></div>
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
                            </li>
                         </c:forEach>
                        
		        </ul>
                     </div>
                
                
                
                
    
    <div id="right">
       <h3>Top sellers</h3>
         <ul>
          
          <c:forEach var="product" items="${productsPool.topSellMock}">
              <li>
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
                            <HR> 
                           </li>  
            </c:forEach>
                      
                     </ul>
                </div>
            </section>
        </div>                   
                        
  <%@include file="/WEB-INF/jspf/footer.jspf" %>                      
