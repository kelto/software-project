/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import cart.ShoppingCartItem;
import cart.ShoppingCart;
import entity.OrderedProduct;
import entity.OrderedProductPK;
import entity.User;
import entity.Userorder;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {
    
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    /*
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(String name, String email, String address, String ccNumber,ShoppingCart cart) {
        try 
        {
            User user = addUser(name, email, address, ccNumber);
            Userorder order = addOrder(user, cart);
            addOrderedItems(order, cart);
            return order.getId();
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }
    * */
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(User user, ShoppingCart cart)
    {
         try 
        {
            Userorder order = addOrder(user, cart);
            addOrderedItems(order, cart);
            return order.getId();
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    }
    
    
    private User addUser(String name, String email, String address, String ccNumber) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setAddress(address);
        //TODO : see where to put the credit card number.
        
        //Really needed ? not sure ...
        em.persist(user);
        return user;
    }

    private Userorder addOrder(User user, ShoppingCart cart) {
        Userorder order = new Userorder();
        order.setUserid(user);
        order.setAmount(cart.getTotal());
        
        Random r = new Random();
        int i = r.nextInt(999999999);
        order.setConfirmationNumber(i);
        
        em.persist(order);
        return order;
    }

    private void addOrderedItems(Userorder order, ShoppingCart cart) {
       em.flush();
        List<ShoppingCartItem> items = cart.getItems();
       
       for(ShoppingCartItem item : items)
       {
           int product_id = item.getProduct().getId();
           
           OrderedProductPK pk = new OrderedProductPK();
           pk.setProductid(product_id);
           pk.setUserorderid(order.getId());
           
           OrderedProduct orderedProduct = new OrderedProduct(pk);
           orderedProduct.setQuantity(item.getQuantity());
           
           em.persist(orderedProduct);
       }
    }

}
