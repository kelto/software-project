package entity;

import entity.Basket;
import entity.Comment;
import entity.Order1;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T17:34:09")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Order1> order1Collection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> address;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, String> pseudo;
    public static volatile SingularAttribute<User, Basket> basket;
    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;

}