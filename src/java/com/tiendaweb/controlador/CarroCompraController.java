/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.controlador;

import com.tiendaweb.entidad.Producto;
import com.tiendaweb.negocio.CompraServiceLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author dansan
 */
@Named(value = "carroCompraController")
@SessionScoped
public class CarroCompraController implements Serializable {

    @EJB
    private CompraServiceLocal compraService;      

    public List<Producto> getListaProductos() {
        return compraService.getProductos();
    }

    public void setListaProductos(List<Producto> listaProductos) {
        compraService.setProductos(listaProductos);
    }   
    
    
    public CarroCompraController() {                
    }
    
    public String addProductoCompra(int idProducto, int cantidad)
    {
        compraService.addProductoCompra(idProducto, cantidad);         
        return "carrito";
    }
    
    public String removeProductoCompra(int idProducto)
    {
        compraService.removeProductoCompra(idProducto);                
        return "carrito";
    }
    
    public String editProductoCompra(int idProducto)            
    {                    
        compraService.editProductoCompra(idProducto);
        return "carrito";
    }
    
    public double getTotalCompra()
    {
        return compraService.getTotalCompra();
    }
    
}
