/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OrderedProduct;
import entity.Product;
import entity.UserOrder;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelto
 */
@Stateless
public class UserOrderFacade extends AbstractFacade<UserOrder> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserOrderFacade() {
        super(UserOrder.class);
    }
    
    public List<Product> getProductsFromOrder(UserOrder order)
    {
        List<Product> list = new ArrayList<>();
        List<OrderedProduct> listOrdered = order.getOrderedProductList();
        for(OrderedProduct ordered : listOrdered)
        {
            list.add(ordered.getProduct());
        }
        return list;
    }
}
