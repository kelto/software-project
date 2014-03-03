/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import cart.ShoppingCart;
import entity.Customize;
import entity.User;
import entity.UserOrder;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import manager.Credential;
import manager.OrderManager;

/**
 *
 * @author kelto
 */
@Stateless
public class FormPurchase extends Form<UserOrder> {
    @EJB
    private OrderManager orderManager;

    private static final String NAME = "username",
            CVN = "cvn",
            TYPE = "credit_type",
            CREDIT = "creditcard";
    
    @Override
    public UserOrder create(HttpServletRequest request) {
        Credential credential = verification(request);
        UserOrder userOrder = null;
        result = "failed to purchased the items.";
        if(!hasError())
        {
            User user = (User) request.getSession().getAttribute("user");
            assert user != null;
            ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
            userOrder = orderManager.placeOrder(user, cart, credential);
            result = (userOrder == null ? "failed to purchased the items." : "Purchase done.");
        }
        
        return userOrder;
        
    }
    
    private Credential verification(HttpServletRequest request)
    {
        clear();
        String name = getValue(request,NAME);
        String cvn = getValue(request,CVN);
        String address = getValue(request,TYPE);
        String ccNumber = getValue(request,CREDIT);
        try {
            nameValidation(name);
        } catch (Exception e) {
            addErrors(NAME, e.getMessage());
        }
        try {
            typeValidation(address);
        } catch (Exception e) {
            addErrors(TYPE,e.getMessage());
        }
        try {
             cardValidation(ccNumber,cvn);
        } catch (Exception e) {
            addErrors(CREDIT,e.getMessage());
        }
        return new Credential(ccNumber, address, name);
    }
    public UserOrder createMount(HttpServletRequest request) {
        Credential credential = verification(request);
        UserOrder userOrder = null;
        result = "failed to purchased the items.";
        if(!hasError())
        {
            User user = (User) request.getSession().getAttribute("user");
            assert user != null;
            Customize customize = (Customize)request.getSession().getAttribute("customize");
            assert customize != null;
            userOrder = orderManager.mountPC(user, customize, credential);
            result = (userOrder == null ? "failed to purchased the items." : "Purchase done.");
        }
        
        return userOrder;
    }

    private void nameValidation(String name) {
        // nothing in mind
    }

    private void typeValidation(String address) {
        // nothing in mind
    }

    private void cardValidation(String ccNumber, String cvn) throws Exception {
        if(ccNumber.length()!=16)
            throw new Exception("Invalid Card number");
        
    }

    

    

}
