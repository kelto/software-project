package entity;

import entity.Comment;
import entity.Userorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T18:05:20")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile ListAttribute<User, Userorder> userorderList;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Comment> commentList;

}