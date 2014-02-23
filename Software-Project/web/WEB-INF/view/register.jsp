<%-- 
    Document   : register
    Created on : 17 févr. 2014, 15:37:53
    Author     : kelto
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
        
<body>

    <!--BEGIN #signup-form -->
    <div id="signup-form">
        
        <!--BEGIN #subscribe-inner -->
        <div id="signup-inner">
        
        	<div class="clearfix" id="header">
        	
        		<img id="signup-icon" src="/Software-Project/img/signup.png" alt="" />
        
                <h1>Register a personal account</h1>

            
            </div>
            <p>Before you can place an order you must create an account </p>

            
            
            <form id="CreateUserForm" action="<c:url value='register'/>" method="post">    
            	
                <p>

                <label for="name">Your Name *</label>
                <input type="text" id = "username" name="username" /> 
                <br />
                <span class="erreur">${form.errors['username']}</span><br />
                </p>
                
                <p>
                <label for="password">Password *</label>
                <input type="text" id = "password" name="password" />
                <br />
                <span class="erreur">${form.errors['password']}</span>
                </p>
               
                <p>
                <label for="password_conf">Confirm password: *</label>
                <input type="text" id = "password_conf" name="password_conf" />
                <br />
                <span class="erreur">${form.errors['password_conf']}</span>
                </p>
          
                <p>

                <label for="email">Email *</label>
                <input type="text" id = "email" name="email" />
                 <br />    
                <span class="erreur">${form.errors['email']}</span>    
                </p>
                
                <p>
                <label for="address">Address  *</label>
                <input type="text" id = "address" name="address" />
                <br />
                <span class="erreur">${form.errors['address']}</span>
                </p>
                
                <p>
                <button id="register" type="submit" value="register">Submit</button>
                </p>
                
                
                </form>
                 <p class="result">${form.result}</p>
		<div id="required">
		<p>* Required Fields<br/>
		
		</div>


            
        
        <!--END #signup-inner -->
        </div>
        
    <!--END #signup-form -->   
    </div>

</body>