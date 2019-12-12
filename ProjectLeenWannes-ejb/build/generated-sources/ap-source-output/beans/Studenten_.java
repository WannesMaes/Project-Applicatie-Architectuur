package beans;

import beans.Secgebruikers;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-12-07T17:13:04")
@StaticMetamodel(Studenten.class)
public class Studenten_ { 

    public static volatile SingularAttribute<Studenten, BigDecimal> snr;
    public static volatile SingularAttribute<Studenten, Secgebruikers> secgebruikers;
    public static volatile SingularAttribute<Studenten, String> naam;

}