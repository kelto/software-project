/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kelto
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findByLogin(String username,String password)
    {
        User user = null;
        try
        {
            user = (User)em.createNamedQuery("User.findByLogin").setParameter("username", username).setParameter("password", password).getSingleResult();
        } catch(Exception e)
        {
            user = null;
        }
        
        return user;
    }
    
}
