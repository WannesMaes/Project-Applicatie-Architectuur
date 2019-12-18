package beans;

import beans.Opleiding;
import beans.Secgebruikers;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-18T23:23:16")
@StaticMetamodel(Docenten.class)
public class Docenten_ { 

    public static volatile SingularAttribute<Docenten, Secgebruikers> secgebruikers;
    public static volatile SingularAttribute<Docenten, BigDecimal> dnr;
    public static volatile SingularAttribute<Docenten, String> naam;
    public static volatile SingularAttribute<Docenten, Opleiding> opleiding;

}