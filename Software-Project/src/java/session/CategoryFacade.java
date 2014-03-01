/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelto
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    private static final String ATT_CATEGORIES = "categories";
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    public Category findByName(String name)
    {
        Category category = null;
        try {
            category = (Category)em.createNamedQuery("Category.findByName").setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            category = null;
        }
        return category;
    }   

    @Override
    protected String getAttName() {
        return ATT_CATEGORIES;
    }
    
    
}
