/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kelto
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    public final static String ATT_PRODUCTS = "products";
    private final static int DEFAULT_RANGE = 20;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public List<Product> findByCategory(Category category)
    {
        return em.createQuery("SELECT p FROM Product p WHERE p.category = :category").setParameter("category",category).
                getResultList();
    }

    @Override
    protected String getAttName() {
        return ATT_PRODUCTS;
    }
    
    
}
