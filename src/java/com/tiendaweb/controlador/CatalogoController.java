/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.controlador;

import com.tiendaweb.entidad.Familia;
import com.tiendaweb.entidad.Producto;
import com.tiendaweb.negocio.CatalogoServiceLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dansan
 */
@Named(value = "catalogoController")
@SessionScoped
public class CatalogoController implements Serializable{

    @EJB
    private CatalogoServiceLocal catalogoService;
    /*listas de familias y productos*/    
    private List<Familia> familias;
    private List<Producto> productos;
    private List<Familia> familiasFiltradas;
    private List<Producto> productosFiltrados;
    /*almacena un producto*/
    private Producto producto;
    /*almacena una familia*/
    private Familia familia;

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public List<Familia> getFamiliasFiltradas() {
        return familiasFiltradas;
    }

    public void setFamiliasFiltradas(List<Familia> familiasFiltradas) {
        this.familiasFiltradas = familiasFiltradas;
    }

    public List<Producto> getProductosFiltrados() {
        return productosFiltrados;
    }

    public void setProductosFiltrados(List<Producto> productosFiltrados) {
        this.productosFiltrados = productosFiltrados;
    }
    

    
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }  
    

    public List<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }   
    
    
    
    public CatalogoController() {
    }
    
    @PostConstruct
    public void CargarFamilias()
    {
        this.familias = catalogoService.listFamilias();        
        this.productos = catalogoService.listProductos();
    }
    
    public void CargarProductosAdmin()
    {
        this.productos = catalogoService.listProductos();
    }
    
    public String CargarProductos()
    {
        this.productos = catalogoService.listProductos();
        return "index";
    }
    
    public String CargarProductosPorFamilia(Familia idFamilia)
    {
        this.productos = catalogoService.listProductosxFamilia(idFamilia);
        return "index";
    }
    
    public String VerProducto(int idProducto)
    {
        this.setProducto(catalogoService.findProducto(idProducto));
        return "detalleproducto";
    }
    
    public String irCrearProducto()
    {
        this.producto = new Producto();  
        this.producto.setVersion(1);        
        this.familia = new Familia();
        return "/admin/productos/createproducto";
    }
    
    public String irEditarProducto(int idProducto)
    {
        this.producto = catalogoService.findProducto(idProducto);  
        this.producto.setVersion(this.producto.getVersion()+1);        
        this.familia = producto.getFamiliaId();
        return "/admin/productos/editproducto";
    }
    
    public String doCrearProducto()
    {
        this.familia = catalogoService.findFamilia(this.familia.getId().intValue());
        this.producto.setFamiliaId(this.familia);
        catalogoService.addProducto(producto);
        this.productos = catalogoService.listProductos();
        return "/admin/productos/index";
    }
    
    public String doEditarProducto()
    {
        this.familia = catalogoService.findFamilia(this.familia.getId().intValue());
        this.producto.setFamiliaId(this.familia);
        catalogoService.editProducto(producto);
        this.productos = catalogoService.listProductos();
        return "/admin/productos/index";
    }
    
    public String doBorrarProducto(int idProducto)
    {
        this.producto = catalogoService.findProducto(idProducto);
        catalogoService.deleteProducto(producto);
        this.productos = catalogoService.listProductos();
        return "/admin/productos/index";
    }
    
    public String irCrearFamilia()
    {         
        this.familia = new Familia();
        this.familia.setVersion(1);
        return "/admin/familias/createfamilia";
    }
    
    public String irEditarFamilia(int idFamilia)
    {
        this.familia = catalogoService.findFamilia(idFamilia);               
        this.familia.setVersion(this.familia.getVersion()+1);
        return "/admin/familias/editfamilia";
    }
    
    public String doCrearFamilia()
    {        
        catalogoService.addFamilia(familia);
        this.familias = catalogoService.listFamilias();
        return "/admin/familias/index";
    }
    
    public String doBorrarFamilia(int idFamilia)
    {
        this.familia = catalogoService.findFamilia(idFamilia);
        catalogoService.deleteFamilia(familia);
        this.familias = catalogoService.listFamilias();
        return "/admin/familias/index";
    }
    
    public String doEditFamilia()
    {              
        catalogoService.editFamilia(familia);
        this.familias = catalogoService.listFamilias();
        return "/admin/familias/index";
    }
    
}
