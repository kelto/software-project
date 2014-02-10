/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import session.UserFacade;

/**
 *
 * @author kelto
 */
@Stateless
public class UserManager {
    
    
    @EJB
    private UserFacade userFacade;

    public User login(String username, String password) {
        User user = userFacade.findByLogin(username, password);
        
        return user;
    }

    public void logout(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User create(String username, String password, String email, String address) {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
