/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Product;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kelto
 */
@Stateless
public class FormProduct extends Form<Product> {

    @Override
    public Product create(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
