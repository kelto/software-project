package entity;

import entity.BasketProduct;
import entity.Comment;
import entity.OrderProduct;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T16:55:07")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile CollectionAttribute<Product, OrderProduct> orderProductCollection;
    public static volatile SingularAttribute<Product, String> sellingPrice;
    public static volatile SingularAttribute<Product, String> productDescription;
    public static volatile CollectionAttribute<Product, Comment> commentCollection;
    public static volatile SingularAttribute<Product, Long> buyingPrice;
    public static volatile SingularAttribute<Product, Integer> productStock;
    public static volatile SingularAttribute<Product, Integer> idProduct;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile CollectionAttribute<Product, BasketProduct> basketProductCollection;

}