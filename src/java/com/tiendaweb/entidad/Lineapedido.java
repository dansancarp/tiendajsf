/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dansan
 */
@Entity
@Table(name = "lineapedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineapedido.findAll", query = "SELECT l FROM Lineapedido l")
    , @NamedQuery(name = "Lineapedido.findById", query = "SELECT l FROM Lineapedido l WHERE l.id = :id")
    , @NamedQuery(name = "Lineapedido.findByDescuento", query = "SELECT l FROM Lineapedido l WHERE l.descuento = :descuento")
    , @NamedQuery(name = "Lineapedido.findByPrecio", query = "SELECT l FROM Lineapedido l WHERE l.precio = :precio")
    , @NamedQuery(name = "Lineapedido.findByCantidad", query = "SELECT l FROM Lineapedido l WHERE l.cantidad = :cantidad")
    , @NamedQuery(name = "Lineapedido.findByVersion", query = "SELECT l FROM Lineapedido l WHERE l.version = :version")})
public class Lineapedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "VERSION")
    private Integer version;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Pedido pedidoId;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Producto productoId;

    public Lineapedido() {
    }

    public Lineapedido(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineapedido)) {
            return false;
        }
        Lineapedido other = (Lineapedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tiendaweb.entidad.Lineapedido[ id=" + id + " ]";
    }
    
}
