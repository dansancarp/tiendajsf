/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.dao.FamiliaFacade;
import com.tiendaweb.dao.ProductoFacade;
import com.tiendaweb.entidad.Familia;
import com.tiendaweb.entidad.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dansan
 */
@Stateless
public class CatalogoService implements CatalogoServiceLocal {

    @EJB
    private FamiliaFacade familiaFacade;
    @EJB
    private ProductoFacade productoFacade;
    
     @Override
    public List<Familia> listFamilias() {
        List<Familia> familias = null;
        familias = familiaFacade.findAll();
        return familias;
    }

    @Override
    public List<Producto> listProductosxFamilia(Familia idFamilia) {
        List<Producto> productos = null;
        productos = productoFacade.FindProductosxFamilia(idFamilia);
        return productos;
    }
    
    

    @Override
    public List<Producto> listProductos() {
        List<Producto> productos = null;
        productos = productoFacade.findAll();
        return productos;    
    }

    @Override
    public Producto findProducto(int idProducto) {
        return productoFacade.find((long)idProducto);
    }

    @Override
    public void addProducto(Producto producto) {
        productoFacade.create(producto);
    }

    @Override
    public void editProducto(Producto producto) {
        productoFacade.edit(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoFacade.remove(producto);
    }

    @Override
    public Familia findFamilia(int idFamilia) {
        return familiaFacade.find((long)idFamilia);
    }

    @Override
    public void addFamilia(Familia familia) {
        familiaFacade.create(familia);
    }

    @Override
    public void deleteFamilia(Familia familia) {
        familiaFacade.remove(familia);
    }

    @Override
    public void editFamilia(Familia familia) {
        familiaFacade.edit(familia);
    }
    
    
    
    
    
    
}
