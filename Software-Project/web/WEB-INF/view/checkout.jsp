<%-- 
    Document   : checkout
    Created on : 25-Feb-2014, 11:13:47
    Author     : andrew
--%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

<body>
    <div id="main1">
   
    
 <div class="container">
    <form class="form-horizontal" action="<c:url value='purchase'/>" method="post">
      <fieldset>
        <legend>Customer Info</legend>

        <div class="control-group">
          <label class="control-label" for="email">E-mail</label>
          <div class="controls">
            <input type="text" id="email" class="span6"/>
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="name">Name</label>
          <div class="controls">
            <input type="text" id="name" class="span6"/>
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="address">Address</label>
          <div class="controls">
            <textarea id="address" rows="3" class="span6"></textarea>
          </div>
        </div>
      </fieldset>

      <fieldset>
        <legend>Payment</legend>

        <div class="control-group">
          <label class="control-label" for="card_type">Card Type</label>
          <div class="controls">
            <select id="card_type">
              <option></option>
              <option>Visa</option>
              <option>Mastercard</option>
              <option>Visa Debit</option>
              <option>Laser</option>
            </select>
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="card_number">Card Number</label>
          <div class="controls">
            <input type="text" id="card_number" class="span4" />
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="cardholder_name">Cardholder Name</label>
          <div class="controls">
            <input type="text" id="cardholder_name" class="span5" />
            
          </div>
        </div>

        <div class="control-group">
          <label class="control-label" for="verification_code">Verification Code</label>
          <div class="controls">
            <input type="text" id="verification_code" class="span1" />
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