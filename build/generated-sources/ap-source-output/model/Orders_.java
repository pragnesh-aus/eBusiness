package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-08T23:51:23")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Double> carPrice;
    public static volatile SingularAttribute<Orders, String> car;
    public static volatile SingularAttribute<Orders, Integer> Qty;
    public static volatile SingularAttribute<Orders, Long> id;
    public static volatile SingularAttribute<Orders, Date> creationDate;
    public static volatile SingularAttribute<Orders, String> customer;

}