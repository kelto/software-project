/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import java.math.BigDecimal;

/**
 *
 * @author kelto
 */
public class ShoppingCartItem {
    
    private Product item;
    private short quantity;
    private BigDecimal total;
    
    public ShoppingCartItem(Product item)
    {
        this.item = item;
        this.quantity = 1;
    }
    
    public ShoppingCartItem(Product item,short quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }
    
    public Product getProduct()
    {
        return this.item;
    }
    
    public short getQuantity()
    {
        return this.quantity;
    }
    
    public void setQuantity(short newQuantity)
    {
        if(newQuantity > 0)
            this.quantity = newQuantity;
    }
    
    public void addQuantity(short newQuantity)
    {
        this.setQuantity((short) (this.quantity + newQuantity));
    }
    
    
    public BigDecimal getTotal()
    {
        return this.item.getSellingPrice().multiply(new BigDecimal(this.getQuantity()));
    }
    
    public boolean equals(Object object)
    {
        if(!(object instanceof ShoppingCartItem))
            return false;
        ShoppingCartItem scItem = (ShoppingCartItem) object;
        return this.item.equals(scItem.getProduct());
    }
    
}
