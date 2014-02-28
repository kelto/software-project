/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import cart.ShoppingCart;
import entity.Product;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.ProductFacade;

/**
 *
 * @author kelto
 */
@Stateless
public class FormCartUpdate extends Form<Boolean> {

    @EJB
    private ProductFacade productFacade;
    
    //Not good yet, will think of something
    @Override
    public Boolean create(HttpServletRequest request) {
        clear();
        HttpSession session = request.getSession();
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        int productId = Integer.parseInt(getValue(request, "productId"));
        Product product = null;
        try {
            product = productIdValidation(getValue(request, "productId"));
        } catch (Exception e) {
            addErrors("productId", e.getMessage());
        }
        short quantity = -1;
        
        try {
            quantity = quantityValidation(getValue(request,"quantity"));
        } catch (Exception e) {
            addErrors("quantity", e.getMessage());
        }
        boolean success = false;
        if(!hasError())
            success = cart.update(product,quantity);
        if(success)
            result = "Update succeed";
        else
            result = "Failed to update Cart";
        return success;
    }

    
   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Product productIdValidation(String productId) throws Exception{
        int id = -1;
        try {
            id = Integer.parseInt(productId);
        } catch (Exception e) {
            
        }
        if(id<1)
            throw new Exception("Invalid product !");
        return productValidation(id);
    }

    private Product productValidation(int productId) throws Exception {
        Product product = null;
        product = productFacade.find(productId);
        if(product == null)
            throw new Exception("This product doesn't exist");
        return product;
    }

    
    private short quantityValidation(String quantity) throws Exception {
        
        short qty = -1;
        try
        {
            qty = Short.parseShort(quantity);
        }catch(NumberFormatException ex){
            throw new Exception("Quantity argument is not a number");
        }
        if(qty>100)
            throw new Exception("You can't order more than 100 of the same item");
        return qty;
    }

}
