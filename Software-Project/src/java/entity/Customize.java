/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kelto
 */
public class Customize {
    
    private static final BigDecimal MOUNT_PRICE = new BigDecimal("40.0");
    
    private List<Product> products;
    
    public Customize(List<Product> products)
    {
        this.products = products;
    }
    
    public BigDecimal getPrice()
    {
        BigDecimal total = BigDecimal.ZERO;
        for(Product p : products)
            total = total.add(p.getSellingPrice());
        return total.add(MOUNT_PRICE);
    }
    
    public List<Product> getProducts()
    {
        return this.products;
    }
    
    
}
