/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import cart.ShoppingCart;
import entity.User;
import javax.ejb.Local;

/**
 *
 * @author kelto
 */
@Local
public interface OrderManagerLocal {
    public int placeOrder(User user, ShoppingCart cart);

    public int placeOrder(String name, String email, String address, String ccNumber, ShoppingCart cart);
}
