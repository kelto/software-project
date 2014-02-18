/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import entity.Category;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import manager.CategoryManager;

/**
 *
 * @author kelto
 */
@Stateless
public class FormCategory extends Form<Category> {
    @EJB
    private CategoryManager manager;

    @Override
    public Category create(HttpServletRequest request) {
        
        String name = getValue(request, "name");
        try {
            nameValidation(name);
        } catch (Exception e) {
            addErrors("name", e.getMessage());
        }
        Category category = null;
        
        
        if(!hasError())
        {
            result = "Creation of category succeed";
            category = manager.create(name);            
        }
        if(hasError() || category == null)
        {
            result="Creation of category failed.";
        }
        return category;
    }

    private void nameValidation(String name) throws Exception
    {
        if(name == null)
        {
            throw new Exception("Name is empty");
        }
        if(name.length()<3)
        {
            throw new Exception("The name of the category should have at least 3 characters");
        }
    }

}
