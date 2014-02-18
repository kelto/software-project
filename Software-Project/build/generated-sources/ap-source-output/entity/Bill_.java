package entity;

import entity.Userorder;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T18:05:20")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Boolean> isPaid;
    public static volatile SingularAttribute<Bill, Date> datePayment;
    public static volatile SingularAttribute<Bill, Userorder> userorderid;

}