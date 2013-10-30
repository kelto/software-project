package entity;

import entity.Order1;
import entity.OrderProductPK;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T16:55:07")
@StaticMetamodel(OrderProduct.class)
public class OrderProduct_ { 

    public static volatile SingularAttribute<OrderProduct, OrderProductPK> orderProductPK;
    public static volatile SingularAttribute<OrderProduct, Order1> order1;
    public static volatile SingularAttribute<OrderProduct, Integer> amountProduct;
    public static volatile SingularAttribute<OrderProduct, Product> product1;

}