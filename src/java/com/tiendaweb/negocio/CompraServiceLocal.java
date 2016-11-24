/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.entidad.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dansan
 */
@Local
public interface CompraServiceLocal {
    void addProductoCompra(int idProducto, int cantidad);

    void removeProductoCompra(int idProducto);

    boolean verificarCantidadProducto(int idProducto, int cantidad);

    void generarPedido(int idComprador);

    Producto findProducto(int idProducto);

    public List<Producto> getProductos();
    public void setProductos(List<Producto> productos);

    void editProductoCompra(int idProducto);

    double getTotalCompra();

   
}
