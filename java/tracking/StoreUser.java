/*
 * This class will be used in order to store information about the user
 * still don't know how exactly we will use it though ...
 */
package tracking;

import javax.servlet.http.HttpSession;

/**
 *
 * @author kelto
 */
public class StoreUser {
    
    protected HttpSession session;
    
    public StoreUser(HttpSession session)
    {
        this.session= session ;
    }
    
    public boolean logout()
    {
        //should store everything in the database here
        
        this.session.invalidate();
        return true;
    }
    
}
