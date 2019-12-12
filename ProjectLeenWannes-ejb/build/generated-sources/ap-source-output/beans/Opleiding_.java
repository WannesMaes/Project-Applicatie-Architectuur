package beans;

import beans.Docenten;
import beans.Machine;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-12-07T17:13:04")
@StaticMetamodel(Opleiding.class)
public class Opleiding_ { 

    public static volatile CollectionAttribute<Opleiding, Docenten> docentenCollection;
    public static volatile CollectionAttribute<Opleiding, Machine> machineCollection;
    public static volatile SingularAttribute<Opleiding, String> naam;

}