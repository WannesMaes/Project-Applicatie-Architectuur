package beans;

import beans.Opleiding;
import beans.Reservatie;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-12-07T17:13:04")
@StaticMetamodel(Machine.class)
public class Machine_ { 

    public static volatile CollectionAttribute<Machine, Reservatie> reservatieCollection;
    public static volatile SingularAttribute<Machine, String> beschrijving;
    public static volatile SingularAttribute<Machine, BigInteger> uurprijs;
    public static volatile SingularAttribute<Machine, BigInteger> aankoopprijs;
    public static volatile SingularAttribute<Machine, String> naam;
    public static volatile SingularAttribute<Machine, String> lokaal;
    public static volatile SingularAttribute<Machine, BigDecimal> serienr;
    public static volatile SingularAttribute<Machine, Opleiding> opleiding;

}