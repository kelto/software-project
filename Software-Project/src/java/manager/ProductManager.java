/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Product;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addProduct(Product product)
    {
        try
        {
            productFacade.create(product);
            categoryPool.reload();
        } catch (Exception e)
        {
            context.setRollbackOnly();
        }
    }

}
