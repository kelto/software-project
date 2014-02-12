/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.Singleton;

/**
 *
 * @author kelto
 */
@Singleton
public class ProductPool {

    private Collection<Product> topSell ;
    private LinkedList<Product> last;
    
    public ProductPool()
    {
        this.topSell = new ArrayList<>();
        this.last = new LinkedList<>();
    }

    public Collection<Product> getTopSell()
    {
        Collection top = new ArrayList<Product>();
        
        
        return top;
    }
    
    public Collection<Product> getLastProducts()
    {
        return getTopSell();
    }

    
    /**
     * Function to call when a new product is persisted. Should not be used
     * when the Bean is created, instead use @hydrateHistoric()
     * @param product
     */
    public void addProduct(Product product)
    {
        this.last.add(product);
        this.last.remove();
    }
    
    public void hydrateHistoric(Product product)
    {
        this.last.add(product);
    }
    
    
}
