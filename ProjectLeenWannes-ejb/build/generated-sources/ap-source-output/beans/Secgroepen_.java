package beans;

import beans.Secgebruikers;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-18T15:36:20")
@StaticMetamodel(Secgroepen.class)
public class Secgroepen_ { 

    public static volatile SingularAttribute<Secgroepen, BigDecimal> gebruikersnaam;
    public static volatile SingularAttribute<Secgroepen, Secgebruikers> secgebruikers;
    public static volatile SingularAttribute<Secgroepen, String> groep;

}