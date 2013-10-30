package entity;

import entity.Bill;
import entity.OrderProduct;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T17:34:09")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile CollectionAttribute<Order1, OrderProduct> orderProductCollection;
    public static volatile SingularAttribute<Order1, Integer> idOrder;
    public static volatile SingularAttribute<Order1, String> status;
    public static volatile CollectionAttribute<Order1, Bill> billCollection;
    public static volatile SingularAttribute<Order1, User> user;

}