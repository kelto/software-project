/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package histogram;

import entity.OrderedProduct;
import entity.Product;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


/**
 * An entity used in the Histogram class to be compute into statistic.
 * Not sure if it should be a session bean or not ... will go for a classic
 * class at first.
 * @author kelto
 */
public class HistogramItem implements Comparable<HistogramItem> {

    private Product product;
    private double value;
    private Date lastTouched;
    private static final double GRAVITY = 1.5;
    private static final int FACTOR = 5;
    private long quantity;
    
    public HistogramItem(OrderedProduct product)
    {
        this.product = product.getProduct();
        this.quantity = product.getQuantity();
        lastTouched = new Date();
        value = quantity*5;
    }

    public Product getProduct() {
        return product;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistogramItem other = (HistogramItem) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
     public void defineValue()
    {
        //Simple algorithm : on new purchase of this item = + FACTOR -1
        // on other purchase = -1
        this.value--;
    }
    
    public void touch(int quantity)
    {
        // Trying not to instanciate a new object each time ... too expensive.
        Calendar cal =Calendar.getInstance();
        lastTouched.setTime(cal.getTimeInMillis());
        // not used ... yet
        this.quantity+=quantity;
        
        purchased(quantity);
    }
    
    private void purchased(int quantity)
    {
        this.value += FACTOR*quantity;
    }

    @Override
    public int compareTo(HistogramItem o) {
        return (int)(o.value-this.value);
    }
}
