/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kelto
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    public static final String ATT_USER = "users";
    private static final int DEFAULT_RANGE = 20;

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
    public User findByUsername(String username)
    {
        User user = null;
        try
        {
            user = (User)em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
        } catch(Exception e)
        {
            user = null;
        }
        
        return user;
    }

    @Override
    protected String getAttName() {
        return ATT_USER;
    }
    
    
}
