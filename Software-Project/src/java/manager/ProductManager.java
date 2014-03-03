/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.CategoryPool;
import session.ProductFacade;

/**
 *
 * @author kelto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductManager {
    @EJB
    private CategoryPool categoryPool;
    @EJB
    private ProductFacade productFacade;
    @Resource
    private SessionContext context;
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Product addProduct(Product product)
    {
        try
        {
            
            em.persist(product);
            categoryPool.reload();
            return product;
        } catch (Exception e)
        {
            context.setRollbackOnly();
            return null;
        }
    }

    public List<Product> search(String search) {
        List<Product> result;
        try {
            result = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',CONCAT(:search,'%'))").setParameter("search",search).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }

}
