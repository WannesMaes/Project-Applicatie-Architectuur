package beans;

import beans.Docenten;
import beans.Extern;
import beans.Reservatie;
import beans.Secgroepen;
import beans.Studenten;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-12-07T17:13:04")
@StaticMetamodel(Secgebruikers.class)
public class Secgebruikers_ { 

    public static volatile CollectionAttribute<Secgebruikers, Reservatie> reservatieCollection;
    public static volatile SingularAttribute<Secgebruikers, BigDecimal> gebruikersnaam;
    public static volatile SingularAttribute<Secgebruikers, Docenten> docenten;
    public static volatile SingularAttribute<Secgebruikers, Studenten> studenten;
    public static volatile SingularAttribute<Secgebruikers, String> paswoord;
    public static volatile SingularAttribute<Secgebruikers, Extern> extern;
    public static volatile SingularAttribute<Secgebruikers, Secgroepen> secgroepen;

}