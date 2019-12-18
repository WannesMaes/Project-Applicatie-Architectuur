package beans;

import beans.Machine;
import beans.Secgebruikers;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-18T15:36:20")
@StaticMetamodel(Reservatie.class)
public class Reservatie_ { 

    public static volatile SingularAttribute<Reservatie, Date> datum;
    public static volatile SingularAttribute<Reservatie, Secgebruikers> huurder;
    public static volatile SingularAttribute<Reservatie, BigDecimal> rnr;
    public static volatile SingularAttribute<Reservatie, BigInteger> einduur;
    public static volatile SingularAttribute<Reservatie, String> beschikbaar;
    public static volatile SingularAttribute<Reservatie, BigInteger> startuur;
    public static volatile SingularAttribute<Reservatie, Machine> serienr;

}