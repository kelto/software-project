/*
 * 
 */
package histogram;

import entity.OrderedProduct;
import entity.Product;
import entity.Userorder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class used to make statistic on product, order and other. Right now it will
 * mainly be used to sort or manage a list of product : the most sold product.
 * This is a classic java class right now. Don't see any use to make it into
 * a Session Bean since it will be used into a singleton bean only
 * @author kelto
 */
public class Histogram {
    
    private Collection<HistogramItem> listItem;
    
    public Histogram()
    {
        this.listItem = new ArrayList<>();
    }
    
    public void recordOrder(Userorder order)
    {
        changeAllValue();
        List<OrderedProduct> list = order.getOrderedProductList();
        for(OrderedProduct product : list)
        {
            HistogramItem item = findItem(product.getProduct());
            if(item == null)
            {
                item = new HistogramItem(product);
                listItem.add(item);
            }
            else
            {
                item.touch(product.getQuantity());
            }
        }
        Collections.sort((List<HistogramItem>) listItem);
    }
    
    //SO UGLY ><
     private Collection<Product> getTopSellRange(int range)
    {
        List<HistogramItem> list;
        if(listItem.size()>range)
        {
            //Not good right now ... have to choose a Collection Type, an arrayList
            //might not be the best one ...
             
            list = ((List<HistogramItem>)listItem).subList(0, range);
            
        }
        else
            list = (List<HistogramItem>)listItem;
        
        List<Product> products = new ArrayList<>();
        for(HistogramItem item : list)
            products.add(item.getProduct());
        return products;
    }
    
    public Collection<Product> getTopSell()
    {
        return getTopSellRange(6);
    }

    private HistogramItem findItem(Product product) {
        HistogramItem item = null;
        
        for(HistogramItem iterate : listItem)
        {
            if(iterate.getProduct().equals(product))
            {
                item = iterate;
                break; // should find a best way ... but prefere that than non foreach
            }
        }
        return item;
    }

    private void changeAllValue() {
        for(HistogramItem item : listItem)
        {
            item.defineValue();
        }
    }

  
}