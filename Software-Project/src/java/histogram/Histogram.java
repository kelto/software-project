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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class used to make statistic on product, order and other. Right now it will
 * mainly be used to sort or manage a list of product : the most sold product.
 * This is a classic java class right now. Don't see any use to make it into
 * a Session Bean since it will be used into a singleton bean only
 * @author kelto
 */
public class Histogram {
    
    private Collection<HistogramItem> listItem;
    private Queue<HistogramItem> queueItem;
    private List<Product> topSell;
    private static final int MAX_ITEMS = 100;
    private static final int SIZE_TOP_SELL = 6;
    
    public Histogram()
    {
        this.listItem = new ArrayList<>();
        this.queueItem = new LinkedList<>();
        this.topSell = new ArrayList<>();
    }
    
    public void recordOrder(Userorder order)
    {
        changeAllValue();
        List<OrderedProduct> list = order.getOrderedProductList();
        for(OrderedProduct product : list)
        {
            HistogramItem item = findItem(product.getProduct(),listItem);
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
    
    public void queueRecordOrder(Userorder order)
    {
        List<OrderedProduct> list = order.getOrderedProductList();
        for(OrderedProduct product : list )
        {
            HistogramItem item = findItem(product.getProduct(),queueItem);
            if(item == null)
            {
                item = getNewItem();
                item.initialize(product);
                addToQueue(item);
            }
            else
            {
                item.touch(product.getQuantity());
            }
        }
        setTopSell();
    }
    
    //SO UGLY ><
    
    private List<HistogramItem> getClone()
    {
        List<HistogramItem> clone =(LinkedList<HistogramItem>) ((LinkedList<HistogramItem>)queueItem).clone();
        return clone;
    }
    private List<HistogramItem> getValueSorted()
    {
        List<HistogramItem> list = getClone();
        Collections.sort(list,HistogramItem.Comparators.VALUE);
        return list;
    }
    
    private void setTopSell()
    {
        List<HistogramItem> sorted = getValueSorted();
        int max = sorted.size() > SIZE_TOP_SELL ? SIZE_TOP_SELL : sorted.size();
        topSell.clear();
        for(int i = 0; i < max; i++)
        {
            topSell.add(sorted.get(i).getProduct());
        }
        
    }
    
    public List<Product> getTopSell()
    {
        return topSell;
    }

    private void changeAllValue() {
        for(HistogramItem item : listItem)
        {
            item.defineValue();
        }
    }

    private HistogramItem findItem(Product product, Collection<HistogramItem> collection) {
        for(HistogramItem item : collection)
        {
            if(item.getProduct().equals(product))
                return item;
        }
        return null;
    }
    
    // Right now do nothing except instanciate new item
    // But should take the item from a pool of HistogramItem
    private HistogramItem getNewItem() {
        return new HistogramItem();
    }

    private void addToQueue(HistogramItem item) {
        if(queueItem.size()>= MAX_ITEMS)
            queueItem.remove();
        queueItem.add(item);
    }
    
    private void initialize()
    {
        // Do nothing yet but should instantiate everything
        // Maybe hydrate the list ?
        // and create a pool of HistogramItem
    }

  
}