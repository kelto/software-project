package entity;

import entity.Order1;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-30T17:34:09")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Boolean> ispaid;
    public static volatile SingularAttribute<Bill, Order1> order1;
    public static volatile SingularAttribute<Bill, Integer> idBill;
    public static volatile SingularAttribute<Bill, Double> totalPrice;
    public static volatile SingularAttribute<Bill, Date> datePayment;

}