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
        HttpSession session = request.getSession();
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        int productId = Integer.parseInt(getValue(request, "productId"));
        Product product = null;
        try {
            product = productIdValidation(productId);
        } catch (Exception e) {
            addErrors("productId", e.getMessage());
        }
        short quantity = Short.parseShort(getValue(request,"quantity"));
        try {
            quantityValidation(quantity);
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

    private Product productIdValidation(int productId) throws Exception{
        if(productId<1)
            throw new Exception("Invalid product !");
        return productValidation(productId);
    }

    private Product productValidation(int productId) throws Exception {
        Product product = null;
        product = productFacade.find(productId);
        if(product == null)
            throw new Exception("This product doesn't exist");
        return product;
    }

    
    private void quantityValidation(int quantity) throws Exception {
        if(quantity>100)
            throw new Exception("You can't order more than 100 of the same item");
    }

}
