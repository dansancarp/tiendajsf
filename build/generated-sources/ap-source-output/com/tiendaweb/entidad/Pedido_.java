package com.tiendaweb.entidad;

import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Lineapedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T22:52:45")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fecha;
    public static volatile SingularAttribute<Pedido, Integer> estado;
    public static volatile SingularAttribute<Pedido, Cliente> clienteId;
    public static volatile SingularAttribute<Pedido, Long> id;
    public static volatile SingularAttribute<Pedido, Integer> version;
    public static volatile ListAttribute<Pedido, Lineapedido> lineapedidoList;

}