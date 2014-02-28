/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.User;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import manager.Encrypter;
import manager.UserManager;

/**
 *
 * @author kelto
 */
@Stateless
public class FormUser extends Form<User> {

    public final static String USERNAME = "username", EMAIL = "email", PASS = "password",
            PASS_CONF = "password_conf",
            ADDRESS = "address";
    @EJB
    private Encrypter encrypter;
    @EJB
    private UserManager userManager;
    @PersistenceContext(unitName = "Software-ProjectPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    @Override
    public User create(HttpServletRequest request) {
        clear();
        String username = getValue(request, USERNAME);
        String email = getValue(request, EMAIL);
        String password = getValue(request, PASS);
        String conf = getValue(request, PASS_CONF);
        String address = getValue(request, ADDRESS);
        User user;
        try {
            usernameValidation(username);
        } catch (Exception e) {
            addErrors(USERNAME, e.getMessage());
        }
        try {
            passwordValidation(password, conf);
        } catch (Exception e) {
            addErrors(PASS, e.getMessage());
        }
        try {
            emailValidation(email);
        } catch (Exception e) {
            addErrors(EMAIL, e.getMessage());
        }
        try {
            addressValidation(address);
        } catch (Exception e) {
            addErrors(ADDRESS, e.getMessage());
        }

        user = null;
        if (!hasError()) {
            user = userManager.create(username, password, email, address);
        }

        result = user == null ? "Sign up failed." : "Sign up succeed !";

        return user;
    }
    
    public boolean Update(HttpServletRequest request, User user)
    {
        clear();
        String email = getValue(request, EMAIL);
        String password = getValue(request, PASS);
        String conf = getValue(request, PASS_CONF);
        String address = getValue(request, ADDRESS);
        try {
            passwordValidation(password, user);
        } catch (Exception e) {
            addErrors(PASS, e.getMessage());
        }
        try {
            emailValidation(email);
        } catch (Exception e) {
            addErrors(EMAIL, e.getMessage());
        }
        try {
            addressValidation(address);
        } catch (Exception e) {
            addErrors(ADDRESS, e.getMessage());
        }
        
        if (!hasError()) {
            
            user.setAddress(address);
            user.setEmail(email);
            userManager.update(user);
            result = "Profile updated";
            return true;
        }
        result = "Failed to update profile";
        return false;
    }

    // need to add some other test on the address, will see later !
    private void addressValidation(String address) throws Exception {
        if (address == null) {
            throw new Exception("Address entry is empty.");
        }

    }

    private void emailValidation(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Email invalid format !");
            }
        } else {
            throw new Exception("No email entry !");
        }
    }

    private void passwordValidation(String pass, String confirmation) throws Exception {
        if (pass != null && confirmation != null) {
            if (!pass.equals(confirmation)) {
                throw new Exception("The password entry and confirmation entry are different");
            } else if (pass.length() < 6) {
                throw new Exception("The password should have at least 6 characters");
            }
        } else {
            throw new Exception("The password and/or confirmation entry is empty.");
        }
    }

    private void usernameValidation(String username) throws Exception {
        if (username == null) {
            throw new Exception("username entry is empty.");
        } else if (username.length() < 3) {
            throw new Exception("The username should have at least 3 characters");
        }


        //check if EntityManager present to test the presence of user with same
        // username
        if (this.em != null) {
            User user = null;
            Query q = em.createNamedQuery("User.findByUsername");
            q.setParameter("username", username);
            try {
                user = (User) q.getSingleResult();
            } catch (NoResultException e) {
            }
            if (user != null) {
                throw new Exception("username already exists please choose another one : "+user.getUsername());
            }
        }
        if (this.em == null) {
            throw new Exception("Can't check if user exist");
        }

    }

    private void passwordValidation(String password, User user) throws Exception {
        if(!user.getPassword().equals(encrypter.encrypt(password+user.getSalt())))
            throw new Exception("Invalid password.");
                
    }
}
