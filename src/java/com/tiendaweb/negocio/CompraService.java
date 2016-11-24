/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.dao.ClienteFacade;
import com.tiendaweb.dao.LineapedidoFacade;
import com.tiendaweb.dao.PedidoFacade;
import com.tiendaweb.dao.ProductoFacade;
import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Lineapedido;
import com.tiendaweb.entidad.Pedido;
import com.tiendaweb.entidad.Producto;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author dansan
 */
@Stateful
public class CompraService implements CompraServiceLocal {

     @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private LineapedidoFacade lineapedidoFacade;
    @EJB
    private PedidoFacade pedidoFacade;
    @EJB
    private ProductoFacade productoFacade;
    
    
    
    private List<Producto> productos;   
       
    public CompraService()
    {
        super();
        productos = new ArrayList<Producto>();
    }
    
    //getter y setter
    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    //metodos de negocio
    
    

    @Override
    public void addProductoCompra(int idProducto, int cantidad) {        
        if(verificarCantidadProducto(idProducto, cantidad))
        {
        Producto p = productoFacade.find((long)idProducto);
        p.setCantidad(cantidad);       
        p.setCantidadAnterior(cantidad);
        int existencias = p.getExistencias();
        p.setExistencias(existencias-cantidad);
        productoFacade.edit(p);
        this.productos.add(p);
        }        
    }

    
    
    @Override
    public void removeProductoCompra(int idProducto) {
        Producto productoABorrar = null;
        for (Producto producto : productos) {
            if(producto.getId()== idProducto)
            {                
                int existencias = producto.getExistencias();
                producto.setExistencias(existencias+producto.getCantidad());
                productoFacade.edit(producto);
                productoABorrar = producto;
                break;
            }
        }
        if(productoABorrar!=null)
            productos.remove(productoABorrar);
    }

    @Override
    public boolean verificarCantidadProducto(int idProducto, int cantidad) {
        boolean hayStock = false;
        Producto p = productoFacade.find((long)idProducto);
        int existencias = p.getExistencias();
        if(cantidad <= existencias)
        {            
            hayStock = true;
        }
        return hayStock;      
    }

    @Override
    public void generarPedido(int idComprador) {
        //el pedido esta asociado a un cliente
        Cliente cliente = clienteFacade.find(idComprador);
        //creo la cabecera del pedido
        Pedido pedido = new Pedido();
        pedido.setClienteId(cliente);
        pedido.setEstado(0);
        pedido.setFecha(new Date());
        pedido.setVersion(0);
        pedidoFacade.create(pedido);
        //detalle del pedido
        for (Producto producto : productos) {
            Lineapedido lp = new Lineapedido();
            lp.setProductoId(producto);
            lp.setPedidoId(pedido);
            lp.setCantidad(BigInteger.valueOf(producto.getCantidad()));            
            lp.setDescuento(Double.valueOf(0));
            lp.setPrecio(producto.getPrecio());            
            lp.setVersion(0);
            lineapedidoFacade.create(lp);
        }
                
    }   

    @Override
    public Producto findProducto(int idProducto) {
        return productoFacade.find((long)idProducto);
    }

    @Override
    public void editProductoCompra(int idProducto) {         
        //busco producto
        for (Producto producto : productos) {
            if(producto.getId()==idProducto)
            {
                int existencias = producto.getExistencias();
                int difCant = producto.getCantidad()-producto.getCantidadAnterior();
                if(difCant>0)
                {
                    if(verificarCantidadProducto(idProducto, difCant))
                    {
                        producto.setExistencias(existencias-difCant);
                        producto.setCantidadAnterior(producto.getCantidad());
                        productoFacade.edit(producto);
                    }
                    else
                    {
                        producto.setCantidad(producto.getCantidadAnterior());
                    }
                    
                }
                else
                {
                    if(difCant<0)
                    {
                        difCant = difCant *-1;
                        producto.setExistencias(existencias+difCant);
                        producto.setCantidadAnterior(producto.getCantidad());
                        productoFacade.edit(producto);
                    }
                }                    
                break;
            }
            
        }        
    }

    @Override
    public double getTotalCompra() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += (producto.getCantidad() * producto.getPrecio());
        }
        return total;
    }
       
   
}
