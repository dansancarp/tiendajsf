/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.dao;

import com.tiendaweb.entidad.Lineapedido;
import com.tiendaweb.entidad.Pedido;
import com.tiendaweb.entidad.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dansan
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @EJB
    private ProductoFacade productoFacade;

    
    
    @PersistenceContext(unitName = "TiendaWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
    
    public List<Lineapedido> findLineaxPedido(int idPedido)
    {
        List<Lineapedido> lineas = null;
        Query query = em.createQuery("select l from Lineapedido l where l.pedidoId=:idPedido");
        query.setParameter("idPedido", idPedido);
        lineas = query.getResultList();
        return lineas;
    }
    
    public void AnularPedido(Pedido pedido)
    {
        //cambio el estado del pedido
        pedido.setEstado(1);
        this.edit(pedido);
        //devuelvo las cantidades de los productos al stock
        for (Lineapedido linea : pedido.getLineapedidoList()) {
            Producto p = productoFacade.find(linea.getProductoId());
            int stockActual = p.getExistencias()+linea.getCantidad().intValue();
            p.setExistencias(stockActual);
            productoFacade.edit(p);
        }
    }
}
