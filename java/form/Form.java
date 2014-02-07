/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author kelto
 */
public abstract class Form<T> {
    
    protected String result;
    private Map<String, String> errors;
 
    public Form()
    {
        errors = new HashMap<>();
    }
    
    
    public String getResult()
    {
        return result;
    }
    
    public Map<String,String> getErrors()
    {
        return errors;
    }
    
    protected void addErrors(String name,String error)
    {
        errors.put(name,error);
    }
    
    public boolean hasError()
    {
        return !errors.isEmpty();
    }
    
    public abstract T create(HttpServletRequest request);
    
    protected String getValue(HttpServletRequest request,String name)
    {
        String value = request.getParameter(name);
        if(value == null || value.trim().length()==0)
            return null;
        else
            return value.trim();
    }
            
}
