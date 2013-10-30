package entity;

import entity.BasketProduct;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T17:34:09")
@StaticMetamodel(Basket.class)
public class Basket_ { 

    public static volatile SingularAttribute<Basket, BasketProduct> basketProduct;
    public static volatile SingularAttribute<Basket, Integer> idBasket;
    public static volatile SingularAttribute<Basket, User> user;

}