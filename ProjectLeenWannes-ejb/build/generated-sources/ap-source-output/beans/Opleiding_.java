package beans;

import beans.Docenten;
import beans.Machine;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-13T15:26:16")
@StaticMetamodel(Opleiding.class)
public class Opleiding_ { 

    public static volatile CollectionAttribute<Opleiding, Docenten> docentenCollection;
    public static volatile CollectionAttribute<Opleiding, Machine> machineCollection;
    public static volatile SingularAttribute<Opleiding, String> naam;

}