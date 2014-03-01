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
             <ul>
                 <li>  <div id="left">
                    <h3>Components </h3>
                    <ul>
                        <li>
                            <p>Cpu</p>                       
                            <input type="visible"
                               name="productId"
                               value="${product.id}">
                                <button onclick="addToPC(product.id)">Add</button>
                        </li>
                       <li>
                            <p>GPU</p>
                            <button onclick="addToPC('gpu')">Add</button>
                        </li>
                        <li>
                            <p>RAM</p>
                            <button onclick="addToPC('ram')">Add</button>
                        </li>
                        
                        
		    </ul>
                     </div>    
                 </li>
  <div id="right">
      <li> <h3>Customize PC</h3>
        <ul>
           <li>         
              <div class="info">
                  <div> <p><b>CPU</b></p></div>
                  <label id="cpu">name of component</label>
                  
                  
              </div>
               <HR> 
         
              <div class="info">
                  <div> <p><b>GPU</b></p></div>
                  <p id="gpu">this</p>
               </div>
               <HR> 
               
                <div class="info">
                  <div> <p><b>RAM</b></p></div>
                  <p id="ram">here</p>
               </div>
               <HR> 
            </li> 
         

         </ul>
    </div>
  </ul>             
                
 </section>
</div>                   
       
<script> 
   function addToPC(category){
	document.getElementById(category).innerHTML = category;
   }
</script>

  <%@include file="/WEB-INF/jspf/footer.jspf" %>                      
