<%-- 
    Document   : index
    Created on : 27 f�vr. 2014, 21:37:25
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
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-2" class="nivo-html-caption">
                    <h5 class="p2">This is promo area</h5>
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-3" class="nivo-html-caption">
                    <h5 class="p2">Where you can add any feature products</h5>
                    <p>Put any description here</p>
                </div>
                <div id="htmlcaption-4" class="nivo-html-caption">
                    <h5 class="p2">Or something else</h5>
                    <p>Put any description here</p>
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
                                <p class="description">${product.description}</p>
                                <div class="price">
                                    <span class="st">Our price:</span><strong>$${product.sellingPrice}</strong>
                                </div>
                                <form name="prod" onsubmit="addToPC()">                              
                                   <input type="hidden"
                                          class="price"
                                          value="${product.sellingPrice}">
                                   <input type="hidden"
                                          class="productId"
                                          value="2">
                                   <input type="hidden"
                                          class="categoryId"
                                          value="${product.categoryid.id}">
                                   
                                   <button type="button"
                                           class="buttonAdd">add to PC</button>
                               
                                 </form>
                            </div>
                            </li>
                         </c:forEach>
                        
		        </ul>
                     </div>
  
       <div id="right">
       <h3>Customize PC</h3>
       <form action="/customize" method="post">
           <table id="cust">
           <c:forEach var="category" items="${categoriesPool.categories}">          
                <tr>
                    <td class="customizeCat"><label>${category.name}</label></td>                                
                    <td class="customizeProd"><label type="text" id="${category.id}_name"></label></td>
                    <td class="customizePrice"><label type="text" id="${category.id}_price"></label></td>
                    <td> <button class="removeButton" id="${category.id}" onclick="" type="button">x</button></td>
                    <td> <input type="hidden" id="${category.id}"></td>   
                </tr>                 
           </c:forEach>
                </table>
           <hr>
           <label class="totalPrice" id="totPrice"></label>
           
       </form>
    </div>
            </section>
        </div>                   
       
<script> 
  //  var productId = new Array("a", "b", "c");
  var allButton = document.querySelectorAll(".buttonAdd");
  for (var i = 0, length = allButton.length; i < length; i++) {
     allButton[i].onclick = function(e) {        
        
        //product name
        var pname = (e.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling
                 .previousSibling.previousSibling.text);
        //category id
        var catid = (e.target.previousSibling.previousSibling.value);
        //product id
        var  prid = (e.target.previousSibling.previousSibling.previousSibling.previousSibling.value);   
        //product price
        var price = (e.target.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.value);  
        
      document.getElementById(catid+"_name").innerHTML = pname;    
      document.getElementById(catid+"_price").innerHTML = price; 
      document.getElementById(catid+"_id").value = prid; 
      updateTotal();
     };
     
     
  }
  
 function updateTotal(){    
        var price = 0;     
        var table = document.getElementById("cust");    
        var rows = table.rows.length;   
        for(var i=0; i<rows; i++)
        {
           if(table.rows[i].cells[2].firstChild.innerHTML !== "")
                price = price + parseInt(table.rows[i].cells[2].firstChild.innerHTML);
        }
       document.getElementById("totPrice").innerHTML = "Total price: $" + price;
  }
</script>

  <%@include file="/WEB-INF/jspf/footer.jspf" %>                      