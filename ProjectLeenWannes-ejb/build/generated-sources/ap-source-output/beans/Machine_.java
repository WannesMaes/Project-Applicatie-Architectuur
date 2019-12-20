package beans;

import beans.Opleiding;
import beans.Reservatie;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-20T12:56:56")
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