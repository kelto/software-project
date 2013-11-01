/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kelto
 */
public class FormUser extends Form<User> {

    public final static String LOGIN="login",EMAIL="email",PASS="pass",
            PASS_CONF="pass_conf",
            ADDRESS="address";
    @Override
    public User create(HttpServletRequest request)
    {
        String login= getValue(request,LOGIN);
        String email=getValue(request, EMAIL);
        String password=getValue(request, PASS);
        String conf=getValue(request, PASS_CONF);
        String address=getValue(request, ADDRESS);
        User user = new User();
        try
            {
                loginValidation(login);
            }
            catch(Exception e)
            {
                addErrors(LOGIN, e.getMessage());
            }
        user.setPseudo(login);
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
    
    private void loginValidation(String login) throws Exception
    {
        if(login == null)
            throw new Exception("Login entry is empty.");
        else if(login.length()<3)
            throw new Exception("The Login should have at least 3 characters");
    }
    
}
