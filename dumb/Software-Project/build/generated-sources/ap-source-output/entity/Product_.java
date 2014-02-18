package entity;

import entity.Category;
import entity.Comment;
import entity.OrderedProduct;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T18:05:20")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, BigDecimal> sellingPrice;
    public static volatile ListAttribute<Product, OrderedProduct> orderedProductList;
    public static volatile SingularAttribute<Product, Category> categoryid;
    public static volatile SingularAttribute<Product, BigDecimal> buyingPrice;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Date> lastUpdate;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile ListAttribute<Product, Comment> commentList;

}