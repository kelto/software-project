<%-- 
    Document   : addCategory
    Created on : 10 févr. 2014, 18:20:35
    Author     : kelto
--%>
<%@include file="/WEB-INF/jspf/header.jspf" %>        



    <body>
         <div id="main">
             <section id="addcat"><!-- Defining the content section #2 -->
                 
        
        <form id="CreateUserForm" action="addCategory" method="post">
        <h3>Add Category</h3>        
        <label for="username">name</label><input type="text" id = "name" name="name" /><br />
    
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>

     
    </section>
      </div>
    </body>
    
<%@include file="/WEB-INF/jspf/footer.jspf" %>
