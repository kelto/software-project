<%-- 
    Document   : admin
    Created on : 28 févr. 2014, 01:09:54
    Author     : kelto
--%>
<%@include file="/WEB-INF/view/admin/jspf/header.jspf" %>
            <div id="main">
                <section id="content">
                    <div id="center">
                        <h3>Administration Panel</h3>
                        <p>Administration Panel. Be careful, every update will be spread through all the application.</p>
                        <p>With greats powers, come greats responsabilities.</p>
                        <h5>Quick View</h5>
                        <p>There is <a href="<c:url value="/admin/users"/>">${nbUsers}</a> users in the application</p>
                        <p>There is <a href="<c:url value="/admin/products"/>">${nbProducts}</a> products in the application</p>
                        <p>There is ${nbComments} comments in the application</p>
                    </div>
            </div>
        </section>
        <footer><!-- Defining the footer section of the page -->
            <div id="privacy">
                Copyright © 2014 <a class="link" href="#">Andrew,Daniel and Charles </a><br />

            </div>
        </footer>
    </div>
</body>
</html>                      