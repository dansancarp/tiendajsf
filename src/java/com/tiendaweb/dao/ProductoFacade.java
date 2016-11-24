/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.dao;

import com.tiendaweb.entidad.Familia;
import com.tiendaweb.entidad.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dansan
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "TiendaWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> FindProductosxFamilia(Familia idFamilia)
    {
        List<Producto> productos = null;
        Query query = em.createQuery("select p from Producto p where p.familiaId=:idFamilia");        
        query.setParameter("idFamilia", idFamilia);
        productos = query.getResultList();
        return productos;
    }
    
}
