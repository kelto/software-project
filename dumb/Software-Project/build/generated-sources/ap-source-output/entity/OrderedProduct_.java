package entity;

import entity.OrderedProductPK;
import entity.Product;
import entity.Userorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T18:05:20")
@StaticMetamodel(OrderedProduct.class)
public class OrderedProduct_ { 

    public static volatile SingularAttribute<OrderedProduct, Product> product;
    public static volatile SingularAttribute<OrderedProduct, OrderedProductPK> orderedProductPK;
    public static volatile SingularAttribute<OrderedProduct, Short> quantity;
    public static volatile SingularAttribute<OrderedProduct, Userorder> userorder;

}