<%-- 
    Document   : checkout
    Created on : 25-Feb-2014, 11:13:47
    Author     : andrew
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

<body>
    <div id="main1">
   
    
 <div class="container">
    <form class="form-horizontal" action="<c:url value='/purchase'/>" method="post">
   

      <fieldset>
        <legend>Payment</legend>

        <div class="control-group">
          <label class="control-label" for="card_type">Card Type</label>
          <div class="controls">
            <select id="card_type" name="credit_type">
                <option value="visa">Visa</option>
              <option value=";astercard">Mastercard</option>
              <option value="visadebit">Visa Debit</option>
              <option value="laser">Laser</option>
            </select>
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="card_number">Card Number</label>
          <div class="controls">
              <input type="text" id="card_number" class="span4" name="creditcard" />
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="cardholder_name">Cardholder Name</label>
          <div class="controls">
            <input type="text" id="cardholder_name" class="span5" name="username" />
            
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="verification_code">Verification Code</label>
          <div class="controls">
            <input type="text" id="verification_code" class="span1" name="cvn" />
          </div>
        </div>
      </fieldset>

      <div class="form-actions" style="text-align: right">
          <h4 id="subtotal">Total: &euro; ${cart.total}</h4>
        <a href="index.html" class="btn">Cancel</a>
        <button class="btn btn-primary">Place Order</button>
      </div>
    </form>
  </div>

 
</div>    
</body>



<%@include file="/WEB-INF/jspf/footer.jspf" %>