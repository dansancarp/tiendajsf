/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.entidad.Familia;
import com.tiendaweb.entidad.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dansan
 */
@Local
public interface CatalogoServiceLocal {
    public List<Familia> listFamilias();
    public List<Producto> listProductosxFamilia(Familia idFamilia);

    List<Producto> listProductos();

    Producto findProducto(int idProducto);

    void addProducto(Producto producto);

    void editProducto(Producto producto);

    void deleteProducto(Producto producto);

    Familia findFamilia(int idFamilia);

    void addFamilia(Familia familia);

    void deleteFamilia(Familia familia);

    void editFamilia(Familia familia);
}
