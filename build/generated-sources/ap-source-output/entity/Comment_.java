package entity;

import entity.Product;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T16:55:07")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Product> product;
    public static volatile SingularAttribute<Comment, Integer> score;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, User> user;
    public static volatile SingularAttribute<Comment, Integer> idComment;

}