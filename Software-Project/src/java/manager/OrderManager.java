/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import cart.ShoppingCartItem;
import cart.ShoppingCart;
import entity.Customize;
import entity.OrderedProduct;
import entity.OrderedProductPK;
import entity.Product;
import entity.User;
import entity.UserOrder;
import java.math.BigDecimal;
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

    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserOrder placeOrder(User user, ShoppingCart cart, Credential credential)
    {
        
         try 
        {
            if (!askForPayment(credential)) {
                throw new Exception("Payment failed.");
            }
            UserOrder order = addOrder(user, cart);
            addOrderedItems(order, cart);
            em.flush();
            return order;
            
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserOrder mountPC(User user, Customize customize, Credential credential) {
         try 
        {
            if (!askForPayment(credential)) {
                throw new Exception("Payment failed.");
            }
            UserOrder order = addMountOrder(user,customize);
            addOrderedItems(order, customize.getProducts());
            em.flush();
            return order;
            
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
    }

    //Won't implement the function.
    private boolean askForPayment(Credential credential)
    {
        return true;
    }
    
    private UserOrder addOrder(User user, ShoppingCart cart) {
        UserOrder order = new UserOrder();
        order.setUserid(user);
        order.setAmount(cart.getTotal());
        
        Random r = new Random();
        int i = r.nextInt(999999999);
        order.setConfirmationNumber(i);
        
        em.persist(order);
        return order;
    }

    private void addOrderedItems(UserOrder order, ShoppingCart cart) {
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

    

    private UserOrder addMountOrder(User user, Customize custom) {
        UserOrder order = new UserOrder();
        order.setUserid(user);
        
       
        order.setAmount(custom.getPrice());
        
        Random r = new Random();
        int i = r.nextInt(999999999);
        order.setConfirmationNumber(i);
        
        em.persist(order);
        return order;
    }

    private void addOrderedItems(UserOrder order, List<Product> products) {
        em.flush();
       
       
       for(Product p : products)
       {
           int product_id = p.getId();
           
           OrderedProductPK pk = new OrderedProductPK();
           pk.setProductid(product_id);
           pk.setUserorderid(order.getId());
           
           OrderedProduct orderedProduct = new OrderedProduct(pk);
           orderedProduct.setQuantity((short)1);
           
           em.persist(orderedProduct);
       }
    }

}
