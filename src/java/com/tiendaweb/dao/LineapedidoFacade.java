/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.dao;

import com.tiendaweb.entidad.Lineapedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dansan
 */
@Stateless
public class LineapedidoFacade extends AbstractFacade<Lineapedido> {

    @PersistenceContext(unitName = "TiendaWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineapedidoFacade() {
        super(Lineapedido.class);
    }
    
}
