/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Category;
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
import session.CategoryFacade;
import session.CategoryPool;

/**
 *
 * @author kelto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryManager {

    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private CategoryPool pool;
    @EJB
    private CategoryFacade catFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Category create(String name) {
        Category category = null;
        try {
            category = new Category();
        category.setName(name);
        em.persist(category);
        pool.add(category);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            context.setRollbackOnly();
            category = null;
        }
        return category;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Category update(String name)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Short id) { 
        Category category = catFacade.find(id);
        catFacade.remove(category);
        pool.remove(category);       
    }

    

}
