/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author kelto
 */
@Singleton
public class CategoryPool {
    @EJB
    private CategoryFacade categoryFacade;

    private List<Category> categories;
    
    
    public void add(Category category)
    {
        categories.add(category);
    }
    
    public List<Category> getCategories()
    {
        return this.categories;
    }
    
    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    public void remove(Category category) {
        this.categories.remove(category);
    }
    
    public Category randomCategory()
    {
        Random r = new Random();
        int index = r.nextInt(categories.size());
        return categories.get(index);
    }

    public void reload() {
        setCategories(categoryFacade.findAll());
    }

}
