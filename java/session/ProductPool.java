/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import javax.ejb.EJB;
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
    
    /**************** MOCK PART **************************/

    
    @EJB
    private CategoryPool categoryPool;
    
    public Collection<Product> getTopSellMock()
    {
        Collection top = new ArrayList<Product>();
        
        top.add(createMock("XZ - 23",225,299.99,"New XZ, waterproof and unbreakable"));
        top.add(createMock("Zaphyre B28",79,99.99,"Without a doubt the best product you could ever find for that category, and not that expensive"));
        top.add(createMock("Zaphyre B27",58,75.60,"The famous B27, one of the last of this category, take it before all is sold !"));
        top.add(createMock("Samsung T-380",400,582.80,"Samsung is the reference brand for this type of product. Jump on this occasion !"));
        top.add(createMock("Vaio T-3 Pro",225,299.99,"As shiny as you could ever hope !"));
        top.add(createMock("Microsoft v3",300,350,"Very expensive, not that good ... Microsoft."));
        return top;
    }
    
    public Collection<Product> getLastProductsMock()
    {
        return getTopSell();
    }
    
    private Product createMock(String name, double buying,double selling,String description)
    {
        Product product =  new Product();
        product.setName(name);
        product.setBuyingPrice(new BigDecimal(buying).setScale(2, BigDecimal.ROUND_HALF_UP));
        product.setSellingPrice(new BigDecimal(selling).setScale(2, BigDecimal.ROUND_HALF_UP));
        product.setDescription(description);
        product.setCategoryid(categoryPool.randomCategory());
        return product;
    }
    
}
