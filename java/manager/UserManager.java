/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.User;
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
import session.UserFacade;

/**
 *
 * @author kelto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserManager {
    
    
    @EJB
    private UserFacade userFacade;
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    
    public User login(String username, String password) {
        User user = userFacade.findByLogin(username, password);
        
        return user;
    }

    public void logout(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public User create(String username, String password, String email, String address) {
        
        try {
            User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        em.persist(user);
        return user;
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
