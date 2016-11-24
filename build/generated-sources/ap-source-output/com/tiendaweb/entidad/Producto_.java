package com.tiendaweb.entidad;

import com.tiendaweb.entidad.Familia;
import com.tiendaweb.entidad.Lineapedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T22:52:45")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Integer> existencias;
    public static volatile SingularAttribute<Producto, String> marca;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, Familia> familiaId;
    public static volatile SingularAttribute<Producto, Long> id;
    public static volatile SingularAttribute<Producto, String> modelo;
    public static volatile SingularAttribute<Producto, Integer> version;
    public static volatile ListAttribute<Producto, Lineapedido> lineapedidoList;
    public static volatile SingularAttribute<Producto, String> detalle;

}