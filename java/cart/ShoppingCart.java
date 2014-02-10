/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelto
 */
public class ShoppingCart {
    private List<ShoppingCartItem> items;
    private BigDecimal total;

    public ShoppingCart()
    {
        this.items = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }
    public List<ShoppingCartItem> getItems() {
        return items;
    }
    
    public void addItem(Product product)
    {
        boolean newItem = true;
        for (ShoppingCartItem item : items) {

            if (item.getProduct().getId() == product.getId()) {

                newItem = false;
                item.addQuantity((short)1);
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(product);
            items.add(scItem);
        }
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public int getNumberItems() {
        return this.items.size();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public void calcule()
    {
        this.total = BigDecimal.ZERO;
        for(ShoppingCartItem item : items)
        {
            this.total = this.total.add(item.getTotal());
        }
    }
    
    public void clear()
    {
        this.items.clear();
        this.total = BigDecimal.ZERO;
    }
    
    
    
}
