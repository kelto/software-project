/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.User;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kelto
 */
public class FormUser extends Form<User> {

    public final static String USERNAME="username",EMAIL="email",PASS="password",
            PASS_CONF="password_conf",
            ADDRESS="address";
    @Override
    public User create(HttpServletRequest request)
    {
        String username= getValue(request,USERNAME);
        String email=getValue(request, EMAIL);
        String password=getValue(request, PASS);
        String conf=getValue(request, PASS_CONF);
        String address=getValue(request, ADDRESS);
        User user = new User();
        try
            {
                usernameValidation(username);
            }
            catch(Exception e)
            {
                addErrors(USERNAME, e.getMessage());
            }
        user.setUsername(username);
        try
            {
                passwordValidation(password,conf);
            }
            catch(Exception e)
            {
                addErrors(PASS, e.getMessage());
            }
        user.setPassword(password);
        try
            {
                emailValidation(email);
            }
            catch(Exception e)
            {
                addErrors(EMAIL, e.getMessage());
            }
        user.setEmail(email);
         try
            {
                addressValidation(address);
            }
            catch(Exception e)
            {
                addErrors(ADDRESS, e.getMessage());
            }
        user.setAddress(address);
        if(hasError())
            result="Sign up failed.";
        else
            result="Sign up succeed !";
            
        return user;
    }
    
    // need to add some other test on the address, will see later !
    private void addressValidation(String address) throws Exception
    {
        if(address == null)
            throw new Exception("Address entry is empty.");
        
    }
     private void emailValidation(String email) throws Exception
    {
        if(email!=null)
        {
            if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))
            {
                email="wrong regex!";
                throw new Exception("Email invalid format !");
            }
        }
        else
            throw new Exception("No email entry !");
    }
    
    private void passwordValidation(String pass,String confirmation) throws Exception
    {
        if(pass != null && confirmation != null)
        {
            if(!pass.equals(confirmation))
                throw new Exception("The password entry and confirmation entry are different");
            else if(pass.length()<6)
                throw new Exception("The password should have at least 6 characters");
        }
        else
            throw new Exception("The password and/or confirmation entry is empty.");
    }
    
    private void usernameValidation(String username) throws Exception
    {
        if(username == null)
            throw new Exception("username entry is empty.");
        else if(username.length()<3)
            throw new Exception("The username should have at least 3 characters");
        
        
        //check if EntityManager present to test the presence of user with same
        // username
        if(this.em != null)
        {
            User user = null;
            Query q = em.createNamedQuery("User.findByUsername");
            q.setParameter("username",username);
            try
            {
                user = (User) q.getSingleResult();
            } catch(NoResultException e)
            {
                
            }
            if(user != null)
                throw new Exception("username already exists please choose another one");
        }
        if(this.em == null)
            throw new Exception("Can't check if user exist");
        
    }
    
}
