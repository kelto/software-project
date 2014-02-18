/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OrderedProduct;
import entity.Product;
import entity.Userorder;
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
public class UserorderFacade extends AbstractFacade<Userorder> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserorderFacade() {
        super(Userorder.class);
    }
    
    public List<Product> getProductsFromOrder(Userorder order)
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
