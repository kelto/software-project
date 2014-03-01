/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Encrypter encrypter;
    @EJB
    private UserFacade userFacade;
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    public User login(String username, String password) {
        try {
            User user = userFacade.findByUsername(username);
            if(user.getPassword().equals(encrypter.encrypt(password+user.getSalt())))
                return user;

            return null;
        } catch (Exception ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void logout(User user) {
        
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public User create(String username, String password, String email, String address) {

        try {
            User user = new User();
            String salt = encrypter.generateSalt();
            user.setSalt(salt);
            user.setUsername(username);
            user.setPassword(encrypter.encrypt(password+salt));
            user.setAddress(address);
            user.setEmail(email);
            em.persist(user);
            return user;
        } catch (Exception e) {
            context.setRollbackOnly();
            return null;
        }

    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(User user)
    {
        try
        {
            userFacade.edit(user);
        } catch (Exception e) {
            context.setRollbackOnly();
        }
    }

    
}
