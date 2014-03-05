<%-- 
    Document   : product
    Created on : 01-Mar-2014, 18:43:21
    Author     : andrew
--%>
<%@include file="/WEB-INF/jspf/header.jspf" %>



<%-- <c:if test="${! empty product }">--%>
                            



<div id="main">
<div class="product-view">
    
    
    <div class="product-essential">
    

        <div class="product-shop">
            <div class="product-name">
                <h2 class="product-brand">${selectedCategory.name}</h2>
                <h1> ${product.name} </h1>
            </div>

              <div class="short-description">
                <div class="std"><p> ${product.description} </p></div>
                </div>
            
                    
              <div class="price-box">
                <p class="special-price">
                <span class="price-label"> Price:</span>
                <span class="price" id="product-price-8228">$${product.sellingPrice}</span>
                </p>
                </div>

                <div class="add-to-box">
                <div class="add-to-cart">
    		<form action="<c:url value='/add'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                                 </form>
              </div>
              </div>   
              </div>

        <div class="img"><a href="#"><img alt="" src="/Software-Project/img/cpu1.jpg"></a></div>
        </div>                
           
        <div class="Prod-desc">
                 <fieldset>
                 <legend>Description</legend>                 
                  <p>  ${product.description}  </p>
               
                  </fieldset>              
<br>
             </div>
             

         <div class="review">   
                <fieldset>
                    <legend>Reviews</legend>
                  <c:forEach var="comment" items="${ListComment}"> 
                   <div class='reviews'>
                       <header>${comment.userid.username} </header>
                       <p>${comment.comment}</p>
                    
                    </div>    
                        
                        
                  </c:forEach>
                     
                    <c:if test="${! empty user }">
                  <form action="<c:url value='/comment'/>" method="POST">


                         <b>Write your Review here:</b> <br>
                    <textarea name="comment" rows="10" cols="80"></textarea><br><br>
                    <input type="hidden" name="productId"value="${product.id}">
                    <h2>Please choose your rating from 1-5</h2>
                    <select name="score">
                    <option value="1">1</option>   
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select>
                    <br><br>
                    <input type="submit" value="Submit">

                    </form>
                </c:if>
                </fieldset>  
           </div>
 
     
    </div>
    </div>                              
	
    
<%@include file="/WEB-INF/jspf/footer.jspf" %>