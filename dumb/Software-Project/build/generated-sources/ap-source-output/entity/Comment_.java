package entity;

import entity.Product;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T18:05:20")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, Product> productid;
    public static volatile SingularAttribute<Comment, Short> score;
    public static volatile SingularAttribute<Comment, User> userid;
    public static volatile SingularAttribute<Comment, String> comment;

}