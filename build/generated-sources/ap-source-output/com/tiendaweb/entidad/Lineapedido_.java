package com.tiendaweb.entidad;

import com.tiendaweb.entidad.Pedido;
import com.tiendaweb.entidad.Producto;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T22:52:45")
@StaticMetamodel(Lineapedido.class)
public class Lineapedido_ { 

    public static volatile SingularAttribute<Lineapedido, Double> precio;
    public static volatile SingularAttribute<Lineapedido, Pedido> pedidoId;
    public static volatile SingularAttribute<Lineapedido, Double> descuento;
    public static volatile SingularAttribute<Lineapedido, Producto> productoId;
    public static volatile SingularAttribute<Lineapedido, Long> id;
    public static volatile SingularAttribute<Lineapedido, BigInteger> cantidad;
    public static volatile SingularAttribute<Lineapedido, Integer> version;

}