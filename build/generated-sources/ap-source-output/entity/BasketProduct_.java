package entity;

import entity.Basket;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T17:34:09")
@StaticMetamodel(BasketProduct.class)
public class BasketProduct_ { 

    public static volatile SingularAttribute<BasketProduct, Integer> amount;
    public static volatile SingularAttribute<BasketProduct, Product> product;
    public static volatile SingularAttribute<BasketProduct, Integer> basket;
    public static volatile SingularAttribute<BasketProduct, Basket> basket1;

}