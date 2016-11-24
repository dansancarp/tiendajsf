package com.tiendaweb.entidad;

import com.tiendaweb.entidad.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T22:52:45")
@StaticMetamodel(Familia.class)
public class Familia_ { 

    public static volatile SingularAttribute<Familia, String> abreviatura;
    public static volatile ListAttribute<Familia, Producto> productoList;
    public static volatile SingularAttribute<Familia, Long> id;
    public static volatile SingularAttribute<Familia, String> nombre;
    public static volatile SingularAttribute<Familia, Integer> version;

}