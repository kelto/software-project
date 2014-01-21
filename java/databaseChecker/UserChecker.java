package databaseChecker;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 * Parse the database, load the User, or just notice if errors or something like this ...
 * This class is needed, just for the respect of the MVC purpose, this should be done for every access of
 * the database ...
 * @author kelto
 */
public class UserChecker {
    
    
    private String error;
    private User user = null;
    
    public boolean exist()
    {
        return user!=null;
    }
    
    public User getUser()
    {
        return this.user;
    }
    
    public String error()
    {
        return error;
    }
    
    // Todo : Try look at EntityManager.find() for this one !
    // JPA autoprotection from sql injection, no test needed 
    //(have to check this, just in case ....)
    public boolean loadUser(HttpServletRequest request,EntityManager em, String login, String password)
    {
        
        Query q = em.createQuery("select u From User u where u.pseudo = :login and u.password = :pass");
        q.setParameter("login",login);
        q.setParameter("pass",password);
        
        // not using this one, because if not result are found
        try
        {
            this.user = (User) q.getSingleResult();
        } catch(NoResultException e)
        {
            
        }
        //this.user = (User) q.getResultList().get(0);
        
        if(user !=null)
        {
            error = "No error";
            return true;
        }
        else
        {
            this.error = "Login failed. Username and/or Password incorrect.";
            return false;
        }
    }
}
