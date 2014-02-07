/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.User;
import javax.ejb.Local;

/**
 *
 * @author kelto
 */
@Local
public interface UserManagerLocal {
    
    public User login(String username,String password);
    public void logout(User user);
    public User create(String username, String password, String email,String address);
}
